public class RatonThread extends Thread {

    private final String nombre;
    private final int tiempoAlimentacion;

    public RatonThread(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public static void main(String[] args) {
        Thread mario = new RatonThread("mario", 3);
        Thread federico = new RatonThread("federico", 2);
        Thread carlos = new RatonThread("carlos", 6);
        mario.start();
        mario.start();
        federico.start();
        carlos.start();
    }

    public void run() {
        this.comer();
    }

    public void comer() {
        try {
            System.out.printf("El raton %s ha empezado a comer%n", nombre);
            java.lang.Thread.sleep(tiempoAlimentacion * 1000L);
            System.out.printf("El raton %s ha terminado  de comer%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}