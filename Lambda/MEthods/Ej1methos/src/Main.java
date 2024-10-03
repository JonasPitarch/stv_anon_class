import java.util.ArrayList;
import java.util.List;

interface MyLambda<A> {
    A doMyLambda(String name);
}

class CreadorDeObjetos {
    static <T> List<T> crear(MyLambda<T> lambda, List<String> names) {
        List<T> objects = new ArrayList<>();

        for(String name : names) {
            objects.add(lambda.doMyLambda(name));
        }

        return objects;
    }
}

record Ciudad (String name) {}

class Album {
    String titulo;
    Album(String titulo){ this.titulo = titulo; }
    public String toString() { return "Album{titulo='" + titulo + "'}"; }
}

class Coche {
    String marca;
    Coche(String marca){ this.marca = marca; }
    public String toString() { return "Coche{marca='" + marca + "'}"; }
}


public class Main {
    public static void main(String[] args) {

        var ciudades=CreadorDeObjetos.crear(Ciudad::new,
                List.of("Paris", "Londres", "Borriana"));
        var coches=CreadorDeObjetos.crear(Coche::new,
                List.of("Ford", "Ferrari", "Masserati"));
        var album=CreadorDeObjetos.crear(Album::new,
                List.of("El perdedor", "BTR","La Ultima"));
        ciudades.forEach(System.out::println);
        coches.forEach(System.out::println);
        album.forEach(System.out::println);
    }
}