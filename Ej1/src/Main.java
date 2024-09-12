class Persona {
    // ...
}
class Alumno extends Persona {

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
        java.lang.Object alumno2=new java.lang.Object(){

        };
        imprimirJerarquiaDeClasses(alumno.getClass());
        System.out.println();
        imprimirJerarquiaDeClasses(alumno2.getClass());
    }
}