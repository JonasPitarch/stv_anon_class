import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

class Reserva {
    String nombre;
    int entrada;
    int salida;

    public Reserva(String nombre, int entrada, int salida) {
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                        ", entrada=" + entrada +
                        ", salida=" + salida +
                        '}';
    }
}
class Gestordereservas{
    Map<Integer, List<Reserva>> reserva = new ConcurrentHashMap<>();
    boolean reservar(int hab, int ini , int fin , String user){
        reserva.putIfAbsent(hab, new ArrayList<>());

        boolean dispo = false;
        for (var r : reserva.get(hab)) {
            if (r.entrada >= fin || ini >= r.salida ){
                dispo = true;
                break;
            }
        }
        if (dispo){
            reserva.get(hab).add(new Reserva(user, ini, fin));
        }
        reserva.forEach((k,v)-> System.out.println(k + ":" + v));

        return dispo;

    }
}
public class Ej2 {
     public static void main(String[] args) {
         Gestordereservas gestordereserva = new Gestordereservas();
        Scanner teclat=new Scanner(System.in);
        String nombre = "Juan";
        while (true) {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                for (int i = 0; i < 1000; i++) {
                    executor.submit(() -> {
                        gestordereserva.reservar(ThreadLocalRandom.current().nextInt(100),
                                ThreadLocalRandom.current().nextInt(100),
                                ThreadLocalRandom.current().nextInt(100),
                                nombre);
                    });
                }

            }




        }


    }


}