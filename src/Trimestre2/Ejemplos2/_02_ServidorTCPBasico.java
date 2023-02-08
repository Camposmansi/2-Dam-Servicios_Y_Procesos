package Trimestre2.Ejemplos2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class _02_ServidorTCPBasico {
    public static void main(String[] args) {
        int puerto = 1025;
        try {

            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en el puerto:" + servidor.getLocalPort());
            Socket cliente = servidor.accept();
            Socket cliente2 = servidor.accept();

            servidor.close();

        } catch (IOException a) {
            System.err.println(a.getMessage());
        }
    }
}
