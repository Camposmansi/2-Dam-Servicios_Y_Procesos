package PSP_Hilos;

public class Raton {

    private final String nombre;
    private final int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public static void main(String[] args) {
        Raton mario = new Raton("mario", 3);
        Raton federico = new Raton("federico", 2);
        Raton carlos = new Raton("carlos", 6);
        mario.comer();
        federico.comer();
        carlos.comer();
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
}
