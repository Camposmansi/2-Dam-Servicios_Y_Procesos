package Trimestre2.ChatMultiHilo;

import java.net.Socket;

public class ComunHilos {
    private int CONEXIONES;
    private int ACTUALES;
    private int MAXIMO;
    private final Socket[] tabla;
    private String mensajes;

    public ComunHilos() {
        this.MAXIMO = MAXIMO;
        tabla = new Socket[MAXIMO];
        CONEXIONES = 0;
        ACTUALES = 0;
        mensajes = "";
    }

    public synchronized int conectar(Socket cliente) {
        int id = -1;
        if (ACTUALES < MAXIMO) {
            id = CONEXIONES;
            tabla[CONEXIONES] = cliente;
            CONEXIONES++;
            ACTUALES++;
        }
        return id;
    }

    public synchronized void desconectar(int id) {
        for (int i = id; i < CONEXIONES - 1; i++) {
            tabla[i] = tabla[i + 1];
        }
        CONEXIONES--;
        ACTUALES--;
    }

    public synchronized void enviarMensajes(int id, String mensaje) {
        mensajes = mensajes + "Cliente " + id + " dice: " + mensaje + "\n";
    }

    public synchronized String getMensajes() {
        return mensajes;
    }
}
