//import java.util.concurrent.Executors;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Ej2 {
//    public class Main {
//        static class Cuenta {
//            int fondos;
//
//            Lock lock = new ReentrantLock(true);
//            Cuenta(int fondos) {
//                this.fondos = fondos;
//            }
//
//            void sumar(int cantidad) {
//                fondos += cantidad;
//            }
//
//          void restar(int cantidad) {
//                fondos -= cantidad;
//            }
//        }
//
//        static class Banco {
//          while(true) {
//                boolean lock1Adquirido = false;
//                boolean lock2Adquirido = false;
//                try {
//                    lock1Adquirido = lock1.tryLock();
//                    lock2Adquirido = lock2.tryLock();
//
//                    if (lock1Adquirido && lock2Adquirido){
//                        // some code
//                        public void transferirDinero(Cuenta origen, Cuenta destino, int cantidad) {
//                            if (origen.fondos > cantidad) {
//                                destino.sumar(cantidad);
//                                origen.restar(cantidad);
//
//                            }
//                        }
//                        break;
//                    }
//                } finally {
//                    if (lock1Adquirido) lock1.unlock();
//                    if (lock2Adquirido) lock2.unlock();
//                }
//            }
//
//        }
//
//        public static void main(String[] args) {
//            Cuenta cuenta1 = new Cuenta(500);
//            Cuenta cuenta2 = new Cuenta(500);
//            Banco banco = new Banco();
//            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//                executor.submit(() -> banco.transferirDinero(cuenta1, cuenta2, 300));
//                executor.submit(() -> banco.transferirDinero(cuenta1, cuenta2, 300));
//            }
//        }
//    }
//}
