import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

record Mensaje (String text, LocalDateTime date){
    public Mensaje(String text) {
        this(text, LocalDateTime.now());
    }
}
class Gestordemensajes{
    List<Mensaje> mensajeList = new CopyOnWriteArrayList<>();
    void enviar(Mensaje m){
        mensajeList.add(m);
    }
    void eliminaratiguos(){
        LocalDateTime limite =LocalDateTime.now().minusSeconds(3);
        mensajeList.removeIf(mensaje -> mensaje.date().isBefore(limite));
    }
}
public class Ej5 {
    public static void main(String[] args) {
        Gestordemensajes gestordemensajes = new Gestordemensajes();
       try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
          for (int i = 0 ; i < 30; i++){
              executor.submit(()->{
                  while (true){
                      gestordemensajes.enviar(new Mensaje("Hola buenos dias"));
                      Thread.sleep(ThreadLocalRandom.current().nextInt(2000,4000));
                  }
              });
              executor.submit(()->{
                  while (true) {
                      System.out.println(gestordemensajes.mensajeList.size());
                      gestordemensajes.eliminaratiguos();
                      Thread.sleep(100);
                  }
              });
          }
       }
    }
}
