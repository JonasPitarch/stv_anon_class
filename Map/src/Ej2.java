import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Ej2 {
     public static void main(String[] args) {
         Reserva r1 = new Reserva("Juan",14,15);
         Reserva r2 = new Reserva("Andres",15,16);
         Reserva r3 = new Reserva("Gerard", 14,15);
         Reserva r4 = new Reserva("Juan" , 19,20);
         List<Reserva>reservas = new ArrayList<>();
         reservas.add(r1);
         reservas.add(r2);
         reservas.add(r3);
         reservas.add(r4);


        Map<Integer, ArrayList<Reserva>> reserva = new ConcurrentHashMap<>();
        reserva.put(1, r1);
        reserva.put(2, r2);
        reserva.put(3, r3);


        reserva.forEach((k,v)-> System.out.println(k + ":" + v));
    }

    static class Reserva {
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
}