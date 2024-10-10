import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

record Movie (String title, int duration, double rating, int year){}

public class Main {
    public static void main(String[] args) {

       Stream <Movie>pelis= Stream.of(
                new Movie("The Shawshank Redemption", 142, 9.3, 1994),
                new Movie("The Godfather", 175, 9.2, 1972),
                new Movie("The Dark Knight", 152, 9.0, 2008),
                new Movie("Pulp Fiction", 154, 8.9, 1994),
                new Movie("The Lord of the Rings: The Return of the King", 201, 8.9, 2003),
                new Movie("Schindler's List", 195, 8.9, 1993),
                new Movie("Fight Club", 139, 8.8, 1999),
                new Movie("Inception", 148, 8.8, 2010),
                new Movie("Forrest Gump", 142, 8.8, 1994),
                new Movie("The Matrix", 136, 8.7, 1999),
                new Movie("Goodfellas", 146, 8.7, 1990),
                new Movie("Star Wars: Episode IV - A New Hope", 121, 8.6, 1977),
                new Movie("Interstellar", 169, 8.6, 2014),
                new Movie("The Silence of the Lambs", 118, 8.6, 1991),
                new Movie("Seven", 127, 8.6, 1995)
        );
//        pelis.map(Movie::title).forEach(System.out::println);
//        Optional<Movie> masLarga = pelis.max(Comparator.comparingInt(Movie::duration));
//        if (masLarga.isPresent()) {
//            System.out.println(masLarga.get().title());
//        } else {
//            System.out.println("No se ha encontrado tu película más larga");
//        }
//        Optional<Movie> masCorta = pelis.min(Comparator.comparingInt(Movie::duration));
//        if (masCorta.isPresent()) {
//            System.out.println(masCorta.get().title());
//        } else {
//            System.out.println("No se ha encontrado tu película más corta");
//        }
//
//        pelis.filter(p->p.year()>=2000).forEach(p->System.out.println(p.title()));
//        pelis.filter(p->p.rating()>9).forEach(p->System.out.println(p.title()));
//        long pelis70 = pelis.filter(p->p.year()>1969 && p.year()<1980).count();
//        System.out.println(pelis70);
//        pelis.sorted(Comparator.comparing(Movie::title)).forEach(p -> System.out.println(p.title()));
//        pelis.sorted(Comparator.comparing(Movie::duration)).forEach(p->System.out.println(p.title()));
//        pelis.limit(1).forEach(p -> System.out.println(p.title()));
        //11 ns
//        pelis.filter(p->p.year()<1980).forEach(p->System.out.println(p.title()));
//        pelis.filter(p->p.duration()>100).forEach(p->System.out.println(p.title()));
//        pelis.filter(p->p.rating()<8).forEach(p->System.out.println(p.title()));
        //15 ns



    }
}

//1.Imprime el titulo de todas las peliculas
//2.Encuentra la película maś larga
//3.La más corta
//4.Películas lanzadas después del 2000
//5.Con un rating mayor a 9
//6.Cuenta el número de películas lanzadas en los 70's
//7.Calcula el rating medio de todas las películas
//8.Lista las películas ordenadas alfabéticamente
//9.Ordenadas por duración en orden descendente
//10.La película con el rating más alto
//11.Los títulos en mayúsculas
//12.Encuentra alguna película lanzada antes de 1980
//13.Comprueba si todas las peliculas tienen un duración mayor a 100 minutos
//14.Comprueba si alguna película tiene un rating por debajo de 8
//15.Obtén la duración acumulada de todas las películas

