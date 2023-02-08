package Trimestre2.Ejemplos2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class _02_ClienteTCPBasico {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 1025;
        try {
            Socket servidor = new Socket(host, port);

            InetAddress i = servidor.getInetAddress();
            System.out.println("Puerto Local: " + servidor.getLocalPort());
            System.out.println("Puerto Remoto: " + servidor.getPort());
            System.out.println("NombreHost/IP: " + servidor.getInetAddress());
            System.out.println("Host Remoto: " + i.getHostName());
            System.out.println("IP Host Remoto: " + i.getHostAddress());

            servidor.close();

        } catch (IOException a) {
            System.err.println(a.getMessage());

        }
    }
}
