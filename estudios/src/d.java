import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Empleado {
    private String nombre;
    private double salario;
    private int edad;

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return nombre + " (Salario: $" + salario + ", Edad: " + edad + ")";
    }
}
public class d {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana", 60000, 45),
                new Empleado("Luis", 48000, 30),
                new Empleado("Carlos", 75000, 50),
                new Empleado("Marta", 54000, 37),
                new Empleado("Lucía", 80000, 29),
                new Empleado("Jorge", 67000, 40)
        );
        List<Empleado>e=empleados.stream().filter(empleado->empleado.getSalario()>50000).sorted((e1,e2)->Double.compare(e2.getSalario(), e1.getSalario())).limit(3).collect(Collectors.toList());
        System.out.println(e);
    }
}
