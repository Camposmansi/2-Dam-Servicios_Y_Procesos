package PSP_Hilos;

public class holaMundoHilosRunable implements Runnable {
    private final String cadena;

    public holaMundoHilosRunable(String cadena) {
        this.cadena = cadena;
    }

    public static void main(String[] args) {
        holaMundoHilosRunable hilo1 = new holaMundoHilosRunable("1");
        holaMundoHilosRunable hilo2 = new holaMundoHilosRunable("2");
        holaMundoHilosRunable hilo3 = new holaMundoHilosRunable("3");
        holaMundoHilosRunable hilo4 = new holaMundoHilosRunable("4");
        holaMundoHilosRunable hilo5 = new holaMundoHilosRunable("5");

        new Thread(hilo1).start();
        new Thread(hilo2).start();
        new Thread(hilo3).start();
        new Thread(hilo4).start();
        new Thread(hilo5).start();


    }

    public void run() {
        try {
            Thread.sleep(Thread.currentThread().threadId() * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hola mundo! Mi cadena es del " + this.cadena + " El ID: " + Thread.currentThread().threadId());
    }


}
