import java.util.ArrayList;
import java.util.List;
record Esudiante(String nom,int nota){}
interface Filtro{
    boolean filtrar(Esudiante esudiante);
}
class MosradorDeAlumno{
    void mostrar(List<Esudiante>estudiantes ,Filtro filtro){
        for (Esudiante esudiante : estudiantes) {
            if (filtro.filtrar(esudiante)) {
                System.out.println(esudiante);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        List<Esudiante>lista=List.of(
                new Esudiante("Jonas",6)
                ,new Esudiante("Michelle",7)
                ,new Esudiante("Davic",8)
        );
        MosradorDeAlumno mosradorDeAlumno=new MosradorDeAlumno();
        mosradorDeAlumno.mostrar(lista, l -> l.nota()>=8);
        mosradorDeAlumno.mostrar(lista, l -> l.nom().contains("C"));
        mosradorDeAlumno.mostrar(lista,l->true);
    }
}