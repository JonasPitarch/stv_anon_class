import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

record Item(String description, AtomicReference<State> state) {
    enum State {
        CHECKED, UNCHECKED
    }

    public Item(String description) {
        this(description, new AtomicReference<>(Item.State.UNCHECKED));
    }

    void setState(State newState) {
        state.set(newState);
    }

    @Override
    public String toString() {
        return (state.get() == State.CHECKED ? "[x]" : "[]") + description + "\n";
    }
}
public class EJ6 {
    public static void main(String[] args) {
        List <Item> items=new CopyOnWriteArrayList<>();
        Lock lock = new ReentrantLock(true);
        try (var executor= Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(()->{
                while (true){
                        if (items.size()<10){
                            items.add(new Item("Item" + ThreadLocalRandom.current().nextInt()));
                        }
                }
            });
            executor.submit(()->{
                    while (true){
                        try {
                            lock.lock();
                            if (items.size() > 0){
                                items.get(ThreadLocalRandom.current().nextInt(items.size())).setState(Item.State.CHECKED);
                            }

                            lock.unlock();
                        }
                        catch (Exception e){
                            System.out.println("Errorrrrrrrrrrrrrrrrrrrrrrrrrrr");
                        }
                    }

            });
            executor.submit(()->{
                while (true){
                    lock.lock();
                    if (items.size() > 0)
                     items.remove(ThreadLocalRandom.current().nextInt(items.size()));
//                    else
//                        System.out.println("No hay items para borrar");
                    lock.unlock();
                }
            });
            executor.submit(()->{
                while (true) {
                    System.out.println(items);
                    Thread.sleep(1000);
                }
            });
        }
    }
}
