import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Persona {
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + ciudad + ")";
    }
}
public class c {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 23, "Madrid"),
                new Persona("Luis", 17, "Madrid"),
                new Persona("Carlos", 35, "Barcelona"),
                new Persona("Marta", 28, "Madrid"),
                new Persona("Lucía", 19, "Barcelona"),
                new Persona("Jorge", 42, "Sevilla"),
                new Persona("María", 16, "Sevilla")
        );
        Map<String,Double>ppc=personas.stream().filter(p->p.getEdad()>18).collect(Collectors.groupingBy(Persona::getCiudad,Collectors.averagingInt(Persona::getEdad)));
        ppc.forEach((ciudad, promedio) ->
                System.out.println("Ciudad: " + ciudad + ", Promedio de edad: " + promedio));
    }
}
