import java.util.Arrays;
import java.util.List;

public class a {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("perro", "gato", "elefante", "tigre", "león", "oso", "jirafa");
        long r =palabras.stream().filter(p->p.length()>4).map((String::toUpperCase)).count();
        System.out.println(r);
    }
}
