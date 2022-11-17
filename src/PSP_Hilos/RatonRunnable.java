package PSP_Hilos;

public class RatonRunnable implements Runnable {

    private final String nombre;
    private final int tiempoAlimentacion;

    public RatonRunnable(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public static void main(String[] args) {
        RatonRunnable mario = new RatonRunnable("mario", 3);
        RatonRunnable federico = new RatonRunnable("federico", 2);
        RatonRunnable carlos = new RatonRunnable("carlos", 6);
        new Thread(mario).start();
        new Thread(mario).start();
        new Thread(federico).start();
        new Thread(carlos).start();
    }

    public void comer() {
        try {
            System.out.printf("El raton %s ha empezado a comer%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000L);
            System.out.printf("El raton %s ha terminado  de comer%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }


}
