package Trimestre2.Chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidorChat extends Thread {
    private final Socket cliente;
    private final ComunHilos comun;
    private BufferedReader bufferedReader;
    private PrintWriter salida;
    private String nombreUsuario = "Usuario";

    public HiloServidorChat(Socket cliente, ComunHilos comun) {
        this.cliente = cliente;
        this.comun = comun;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salida = new PrintWriter(cliente.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            nombreUsuario = bufferedReader.readLine();
            if (comun.agregarUsuario(cliente)) {
                comun.enviarMensaje("El usuario " + nombreUsuario + " se ha unido al chat");
                while (true) {
                    String mensaje = bufferedReader.readLine();
                    if (mensaje != null) {
                        comun.enviarMensaje(mensaje);
                    }
                }
            } else {
                comun.enviarMensaje("El usuario " + nombreUsuario + " no se ha unido al chat");
            }
        } catch (IOException e) {
            try {
                comun.enviarMensaje("El usuario " + nombreUsuario + " ha abandonado el chat");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                comun.desConectaCliente(cliente);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
