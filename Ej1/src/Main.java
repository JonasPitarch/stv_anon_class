class Persona {
    // ...
}
class Alumno extends Persona {

}
interface a{

}

public class Main {

    static void imprimirJerarquiaDeClasses(Class<?> c) {
        System.out.print(c.getName() + (c.getSuperclass() != null ? "  >  " : "\n"));
        if (c.getSuperclass() == null) return;
        imprimirJerarquiaDeClasses(c.getSuperclass());
    }

    public static void main(String[] args) {

        Alumno alumno = new Alumno(){
        };
        a an =new a() {
        };
        imprimirJerarquiaDeClasses(alumno.getClass());
        System.out.println();
        imprimirJerarquiaDeClasses(an.getClass());
    }
}