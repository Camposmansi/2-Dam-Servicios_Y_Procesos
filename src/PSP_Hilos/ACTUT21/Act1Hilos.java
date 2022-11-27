package PSP_Hilos.ACTUT21;

public class Act1Hilos extends Thread {
    /**
     * * ATRIBUTOS
     * * i)	    contador: un entero con valor inicial 0.
     * * ii)     max: un entero con valor inicial 100.
     * * iii)	stop: un boolean con valor inicial false.
     **/
    private final String nombre;
    int contador = 0;
    int max = 100;
    boolean stop = false;

    /**
     * * CONTRUCTOR
     * * Se le pasarán 2 variables que indiquen el nombre y un nuevo valor para “max”
     **/
    public Act1Hilos(String nombre, int max) {
        this.nombre = nombre;
        this.max = max;
    }

    /**
     ** METODOS
     ** getContador: retornará el valor del atributo contador
     **/
    public int getContador() {
        return contador;
    }

    /**
     ** resetCont: iniciará el contador a 0
     **/
    public void resetCont() {
        this.contador = 0;
    }

    /**
     ** getMax: retornará el valor del atributo max
     **/
    public int getMax() {
        return max;
    }

    public void pararHilo() {
        stop = true;
    }

    /**
     ** run: mientras que no se le indique que pare, y mientras que el contador sea inferior a Max
     **      imprimirá en la salida estándar su nombre y el valor de su contador.
     **      Después incrementará el contador.
     **      El hilo debe mostrar por la salida estándar cuando finalice.
     **/
    public void run() {

        while (!stop && getContador() < getMax()) {

            try {
                System.out.println("Nombre " + this.nombre + " Contador " + this.contador);

                java.lang.Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Se interumpio la ejecucion de los Hilos");
            }
            this.contador++;

        }
    }
}
