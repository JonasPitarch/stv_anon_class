import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

class ChatClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (var executor= Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(()->{

                Socket socket = new Socket("10.2.1.110", 7777);
                System.out.println("Conectado al servidor " + socket);

                var socketWriter = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    System.out.println("Escribe un mensaje:");
                    socketWriter.println(scanner.nextLine());
                    System.out.println("Mensaje enviado");
                }
            });

        }
    }
}