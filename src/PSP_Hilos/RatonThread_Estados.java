package PSP_Hilos;

import java.util.ArrayList;

public class RatonThread_Estados extends Thread implements Runnable {

    private final String nombre;
    private final int tiempoAlimentacion;


    public RatonThread_Estados(String nombre, int tiempoAlimentacion) {

        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread mario = new RatonThread_Estados("mario", 3);
        ArrayList<State> listaEstados = new ArrayList<>();
        listaEstados.add(mario.getState());
        mario.start();
        listaEstados.add(mario.getState());
        do {
            if (!listaEstados.contains(mario.getState())) {
                listaEstados.add(mario.getState());
            }
        } while (mario.isAlive());

        //while(raton1.getState()!= Thread.State.TERMINATED);//a traves del State para mostrar el estado de los hilos
        if (!listaEstados.contains(mario.getState())) {
            listaEstados.add(mario.getState());
        }

        //Bucle que recorra todos lo estados
        for (Thread.State estado : listaEstados) {
            System.out.println(estado);

        }

    }

    @Override
    public void run() {
        this.comer();
    }

    public void comer() {
        try {
            System.out.printf("El raton %s ha comenzado a comer%n", nombre); //%s es para rellenar con el nombre y %n es un salto de linea
            RatonThread_Estados.sleep(tiempoAlimentacion * 1000L); //pongo * 1000 ya que son milesengundos
            System.out.printf("El raton %s ha terminado de comer%n", nombre);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


}