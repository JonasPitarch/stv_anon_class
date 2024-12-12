import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Ejercicio3 {
    static class Video{
        int descargas;
        int visualizaciones;
        Object o1 = new Object();
        Object o2 = new Object();

        public Video() {}
           void incrementarDescargas(){
            synchronized (o1) {
                descargas++;
            }
        }
            synchronized void incrementarVisualizaciones(){
             synchronized (o2){
                 visualizaciones++;
             }
        }

    }
    public static void main(String[] args) {
        Video video = new Video();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5_000_000; i++) {
                executor.submit(video::incrementarDescargas);
                executor.submit(video::incrementarVisualizaciones);
            }
        }
        System.out.println(video.descargas);
        System.out.println(video.visualizaciones);
    }
}
