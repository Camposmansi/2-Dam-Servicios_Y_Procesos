package PSP_Hilos;

// Definimos unos sencillos hilos. Se detendrán un rato
// antes de imprimir sus nombres y retardos

class extienda_Thread extends Thread {
    private final String nombre;
    private final int retardo;

    // Constructor para almacenar nuestro nombre
    // y el retardo
    public extienda_Thread(String s, int d) {
        nombre = s;
        retardo = d;
    }

    // El metodo run() es similar al main(), pero para
    // threads. Cuando run() termina el thread muere
    public void run() {
        // Retasamos la ejecución el tiempo especificado
        try {
            sleep(retardo);
        } catch (InterruptedException e) {
        }

        // Ahora imprimimos el nombre
        System.out.println("Hola Mundo! " + nombre + " " + retardo);
    }
}

public class MultiHola {
    public static void main(String[] args) {
        extienda_Thread t1, t2, t3, t4, t5;

        // Creamos los threads
        t1 = new extienda_Thread("Identificador 1", (int) (Math.random() * 2000));
        t2 = new extienda_Thread("Identificador 2", (int) (Math.random() * 2000));
        t3 = new extienda_Thread("Identificador 3", (int) (Math.random() * 2000));
        t4 = new extienda_Thread("Identificador 4", (int) (Math.random() * 2000));
        t5 = new extienda_Thread("Identificador 5", (int) (Math.random() * 2000));

        // Arrancamos los threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
