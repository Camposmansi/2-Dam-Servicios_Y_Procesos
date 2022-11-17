package PSP_Hilos;

public class holaMundo_hilos extends Thread {
    public static void main(String[] args) {
        holaMundo_hilos hilo1 = new holaMundo_hilos();
        holaMundo_hilos hilo2 = new holaMundo_hilos();
        holaMundo_hilos hilo3 = new holaMundo_hilos();
        holaMundo_hilos hilo4 = new holaMundo_hilos();
        holaMundo_hilos hilo5 = new holaMundo_hilos();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

    }

    //Con esto cambiamos el mensaje del HILO
    public void run() {
        System.out.println("Hilo con id: " + Thread.currentThread().threadId() + ". Hola mundo! ");
    }
}
