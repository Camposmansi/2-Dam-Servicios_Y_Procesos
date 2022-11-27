
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class linkedlist_NoSeguro implements Runnable {
    private final Queue<Integer> cola = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new linkedlist_NoSeguro()).start();
        }
    }

    @Override
    public void run() {
        cola.add(10);
        for (Integer n : cola) {
            System.out.println(n + ":");
        }
        System.out.println("Tamanio:" + cola.size());
    }
}
