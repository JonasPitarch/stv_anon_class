import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class Ej1 {
    public static void main(String[] args) {
        String[] palabras = {
                "manzana", "pera", "naranja", "uva", "manzana", "naranja", "naranja", "uva",
                "naranja", "manzana", "naranja", "uva", "manzana", "naranja", "naranja", "uva",
                "manzana", "naranja", "naranja", "uva", "naranja", "manzana", "naranja", "uva",
                "pera", "naranja", "pera", "naranja", "uva", "naranja", "naranja", "manzana",
                "pera", "pera", "naranja", "manzana", "naranja", "naranja", "pera", "manzana",
                "uva", "naranja", "manzana", "pera", "pera", "naranja", "naranja", "manzana",
                "pera", "naranja", "uva", "pera", "manzana", "naranja", "naranja", "naranja",
                "pera", "uva", "manzana", "naranja", "pera", "uva", "naranja", "manzana",
                "naranja", "manzana", "uva", "pera", "pera", "naranja", "uva", "manzana",
                "naranja", "uva", "manzana", "naranja", "pera", "naranja", "manzana", "pera",
                "naranja", "uva", "manzana", "pera", "manzana", "naranja", "manzana", "pera",
                "naranja", "manzana", "manzana", "naranja", "uva", "naranja", "manzana", "naranja"
        };

        Map<String, Integer> mapa = new ConcurrentHashMap<>();

        try (var ececutor = Executors.newVirtualThreadPerTaskExecutor()){
            ececutor.submit(() -> {
                for(int i =0 ; i< palabras.length/2;i++){

                        mapa.compute(palabras[i],(_,v)->v==null? 1 : v+1);

                }
            });

            ececutor.submit(() -> {
                for(int i =palabras.length/2 ;i<palabras.length;i++){
                    mapa.compute(palabras[i],(_,v)->v==null ? 1 : v+1);
                }
            });
        }
        if (mapa.get("manzana")!=24
                || mapa.get("pera")!=18
                || mapa.get("naranja")!=38
                || mapa.get("uva")!=16
        ){
            System.out.println("ERROR");
        }
        mapa.forEach((k,v)-> System.out.println(k + ": " + v));
    }
}