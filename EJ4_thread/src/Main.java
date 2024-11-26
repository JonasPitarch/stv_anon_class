import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        try (var executor= Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(()->new Server().start());
            executor.submit(()->new Client().start());
        }


    }
}

class Server {
        void start (){
            try {
                ServerSocket serverSocket = new ServerSocket(7777);
                System.out.println("Servidor iniciado " + serverSocket);

                while (true){
                    Socket clientSocket = serverSocket.accept();
                    //System.out.println("Cliente conectado " + clientSocket);

                    var socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    //System.out.println("Esperando mensajes de " + clientSocket + "...");
                    socketReader.lines().forEach(System.out::println);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }


    }
}


class Client {
    PrintWriter [] servidores=new PrintWriter[254];
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);

            Thread.startVirtualThread(()->{
                try{
                    while(true){
                        for (int i = 1; i < 255; i++) {
                            if (servidores[i-1]==null) {
                                final int ii = i;
                                Thread.startVirtualThread(()->{
                                    try {
                                        Socket socket = new Socket("192.168.1.20", 7777);
                                        System.out.println("Conectado al servidor " + socket);
                                        var socketWriter = new PrintWriter(socket.getOutputStream(), true);

                                        servidores[ii - 1] = socketWriter;
                                    }
                                    catch (Exception e){

                                    }

                                });

                            }
                        }
                        Thread.sleep(500);
                    }


                }
                catch (Exception e){

                }

            });

            while (true) {
                System.out.println("Escribe un mensaje:");
                String mensaje = scanner.nextLine();
                for (var server : servidores) {
                    if (server != null)
                    server.println(mensaje);
                }
                System.out.println("Mensaje enviado");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}