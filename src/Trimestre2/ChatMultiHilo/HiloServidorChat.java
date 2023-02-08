package Trimestre2.ChatMultiHilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class HiloServidorChat extends Thread {
    private final Socket cliente;
    private final ComunHilos comun;

    public HiloServidorChat(Socket cliente, ComunHilos comun) {
        this.cliente = cliente;
        this.comun = comun;
    }

    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            int id = comun.conectar(cliente);
            String mensaje = "";
            while (!mensaje.equals("*")) {
                mensaje = entrada.readUTF();
                comun.enviarMensajes(id, mensaje);
                salida.writeUTF(comun.getMensajes());
            }
            comun.desconectar(id);
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

