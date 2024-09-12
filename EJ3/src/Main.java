class Executable {
    void executar(){}
}

class Executor extends Executable{
    void executarXVegades(int x, Executable executable){
        for (int i = 0; i < x; i++) {
            executable.executar();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Executor executor = new Executor(){
            void executar(){
                System.out.println("Hello Executable");
            }
        };

        executor.executarXVegades(10, new Executable());
    }
}
