package PSP_Hilos.ACTUT21;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        /**
         ** a) Creará 3 instancias del hilo con nombre a elegir por el programador/a
         ** y con valores máximos 10, 25, 50
         **/
        Act1Hilos uno = new Act1Hilos("uno", 10);
        Act1Hilos dos = new Act1Hilos("dos", 25);
        Act1Hilos tres = new Act1Hilos("tres", 50);

        /**
         ** b) Asignará prioridades mínima, normal y máxima al primer, segundo y tercer hilo
         ** respectivamente.
         **/
        uno.setPriority(Thread.MIN_PRIORITY);
        dos.setPriority(Thread.NORM_PRIORITY);
        tres.setPriority(Thread.MAX_PRIORITY);

        /**
         ** c) Iniciará los dos primeros hilos.
         **/
        uno.start();
        dos.start();

        /**
         ** d) Esperará a que el primer hilo termine para iniciar el tercer hilo.
         **/
        while (uno.isAlive()) {
            tres.join();
        }
        tres.start();

        /**
         ** e) Esperará 1 segundo y reiniciará el contador del segundo hilo.
         **/
        java.lang.Thread.sleep(1000);
        dos.resetCont();

        /**
         ** f) Esperará 1 segundo y parará los 3 hilos.
         **/
        java.lang.Thread.sleep(1000);
        dos.pararHilo();
        tres.pararHilo();

        /**
         ** g) Mostrará por pantalla el contador de los 3 hilos.
         **/
        System.out.println("Contador hilo uno = " + uno.getContador());
        System.out.println("Contador hilo dos = " + dos.getContador());
        System.out.println("Contador hilo tres = " + tres.getContador());
    }
}
