
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lector_NoSeguro extends Thread {
    //private static List<String> palabras = new ArrayList<>();
    private static final List<String> palabras = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Lector_NoSeguro().start();
        }
    }

    @Override
    public void run() {
        palabras.add("nuevaPalabra");
        for (String palabra : palabras) {
            palabra.getBytes();
        }
        System.out.println(palabras.size());
    }
}
