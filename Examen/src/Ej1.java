//import java.util.concurrent.atomic.AtomicReference;
//
//public class Ej1 {
//   public static void main(String[] args) {
//
//   }
//    class Product{
//        String nombre;
//       int cantidad;
//
//        public Product(String nombre, int cantidad) {
//            this.nombre = nombre;
//            this.cantidad = cantidad;
//        }
//
//        public String getNombre() {
//            return nombre;
//        }
//
//        public void setNombre(String nombre) {
//            this.nombre = nombre;
//        }
//
//        public int getCantidad() {
//            return cantidad;
//        }
//
//        public void setCantidad(int cantidad) {
//            this.cantidad = cantidad;
//        }
//    }
//    class InventoryManager{
//        AtomicReference<Product> producto = new AtomicReference<>(new Product("Macarrones", 5));
//        InventoryManager(){
//           producto = new AtomicReference<>();
//       }
//        void updateInventory(String nombre , int cantidad){
//           producto.set(new Product(nombre,cantidad));
//        }
//        void updateInventorys(String expectedname , String productname, int Nuevocantidad){
//            producto.getAndUpdate(current ->
//            {
//                if (current.nombre.equals(expectedname) && current.cantidad == Nuevocantidad) {
//                    return current.nombre;
//                }
//            });
//       }
//   }
//}
