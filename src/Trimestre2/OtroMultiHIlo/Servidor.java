package Trimestre2.OtroMultiHIlo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    private int puerto;
    private boolean parar = false;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }


    public int getPuerto() {
        return puerto;
    }


    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public void pararServidor() {
        this.parar = true;
    }

    public void run() {
        ServerSocket servidor = null;
        try {
            //Ponemos el servidor a escuchar
            servidor = new ServerSocket(this.puerto);
            System.out.println("Esperando conexiones en el puerto " + this.puerto);

            //Mientras que no llamemos al metodo parar recibimos clientes y creamos hilos para cada cliente
            while (!parar) {
                Socket nuevoCliente = servidor.accept();
                ThreadCliente tNuevoCliente = new ThreadCliente(nuevoCliente);
                tNuevoCliente.start();
            }

            //Cerramos el servidor una vez hayamos salido del while
            servidor.close();
            System.out.println("Servidor cerrado correctamente");

        } catch (IOException e) {
            System.out.println("Servidor cerrado abruptamente");
            e.printStackTrace();
        } finally {
            //Cerramos el servidor liberando los recursos una vez hayamos llamado a parar o haya saltado una excepción crítica
            if (servidor != null) {
                try {
                    servidor.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
