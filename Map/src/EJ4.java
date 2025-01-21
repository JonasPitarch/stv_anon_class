import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

public class EJ4 {
    public static void main(String[] args) {
        var l = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 100; i++) {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
                executor.submit(()->{
                    l.add("Hola");
                });

                executor.submit(()->{
                    l.add("Adios");
                });
                System.out.println(l);
            }
        }

    }
}
