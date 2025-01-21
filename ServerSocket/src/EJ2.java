import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class EJ2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8099);

            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                while (true){
                    Socket socket = serverSocket.accept();
                executor.submit(() -> {
                    try {
                        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                        Thread.sleep(5000);
                        writer.println("Hola mundo");
                        writer.close();
                        socket.close();
                    }
                    catch (IOException e){
                        System.out.println("Error");
                    }
                    catch (InterruptedException _){
                        System.out.println("Error en el sleep");
                    }


                });
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
