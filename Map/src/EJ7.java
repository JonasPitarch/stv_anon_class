import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

record Producto(int id, String nombre, AtomicInteger stock){
    void aumentarStock(int cantidad){
       stock.getAndAdd(cantidad);

    }

    void disminuirStock(int cantidad){
        stock.getAndAdd(- cantidad);
    }
}
public class EJ7 {
    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();
        inventario.add(new Producto(1,"PC",new AtomicInteger(100)));
        inventario.add(new Producto(2,"Gráfica",new AtomicInteger(3)));
        inventario.add(new Producto(2,"Raton",new AtomicInteger(43)));
        inventario.add(new Producto(2,"Teclado",new AtomicInteger(33)));
        inventario.add(new Producto(2,"Pantalla",new AtomicInteger(32)));
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){

            executor.submit(()->{
                while (true){
                    System.out.println(inventario);
                }
            });

           for (int i = 0; i< 1000000; i++){
               executor.submit(()->{

                   int random= ThreadLocalRandom.current().nextInt(inventario.size());
                   inventario.get(random).aumentarStock(9);

               });
           }

            for (int i = 0; i< 1000000; i++){
                executor.submit(()->{

                    int random= ThreadLocalRandom.current().nextInt(inventario.size());
                    inventario.get(random).disminuirStock(7);

                });
            }

        }
    }
}
