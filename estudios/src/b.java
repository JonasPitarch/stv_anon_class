import java.util.Arrays;
import java.util.List;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void aplicarDescuento(double porcentaje) {
        this.precio = this.precio * (1 - porcentaje);
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
public class b {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", 1200),
                new Producto("Mouse", 25),
                new Producto("Teclado", 75),
                new Producto("Monitor", 300),
                new Producto("Escritorio", 150),
                new Producto("Silla", 80)
        );
        double pt=productos.stream().filter(p->p.getPrecio()>50).peek(p->p.aplicarDescuento(0.10)).mapToDouble(Producto::getPrecio).sum();
    }
}
