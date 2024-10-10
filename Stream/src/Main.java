import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of("ana","pepe","luis","irene","imma")
                .sorted(Comparator.comparing(n-> new StringBuilder(n.toLowerCase()).reverse().toString().compareTo(n)))
                .forEach(x-> System.out.println(x));
    }
}