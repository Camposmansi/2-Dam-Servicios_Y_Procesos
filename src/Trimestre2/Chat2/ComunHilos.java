package Trimestre2.Chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ComunHilos {
    private static ComunHilos instance = null;
    private final int maximo = 3;
    private final Socket[] tabla = new Socket[maximo];
    private int conexiones = 0;
    private int actuales = 0;
    private String mensajes = "";

    private ComunHilos() {
    }

    public static synchronized ComunHilos getInstance() {
        if (instance == null) {
            instance = new ComunHilos();
        }
        return instance;
    }


    synchronized public boolean agregarUsuario(Socket cliente) throws IOException {

        boolean hayHueco = conexiones < maximo;
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        if (hayHueco) {
            tabla[conexiones] = cliente;
            conexiones++;
            actuales++;
            salida.println("Bienvenido al Servidor");
        } else {
            salida.println("Servidor Lleno");
            cliente.close();
        }

        return hayHueco;
    }

    synchronized public void desConectaCliente(Socket socket) throws IOException {
        socket.close();
        actuales--;
    }

    synchronized public void enviarMensaje(String mensaje) throws IOException {
        mensajes = mensajes.concat(mensaje + "\n");
        for (int i = 0; i < conexiones; i++) {
            Socket cliente = tabla[i];
            if (cliente != null && !cliente.isClosed()) {
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                salida.println(mensajes);
            }
        }
    }

}
