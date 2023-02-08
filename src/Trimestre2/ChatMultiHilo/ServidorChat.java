package Trimestre2.ChatMultiHilo;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
    public static void main(String[] args) {
        int puerto = 9999;
        ComunHilos comun = new ComunHilos();
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado desde: " + cliente.getInetAddress().getHostAddress());
                HiloServidorChat hilo = new HiloServidorChat(cliente, comun);
                hilo.start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

