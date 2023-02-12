package Trimestre2.Chat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
    private final ComunHilos comun;
    private ServerSocket servidor;

    public ServidorChat(int puerto) {
        comun = ComunHilos.getInstance();
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado " + cliente.getInetAddress());
                HiloServidorChat hilo = new HiloServidorChat(cliente, comun);
                hilo.start();
            }
        } catch (IOException e) {
            System.out.println("Error en ejecución del servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ServidorChat servidor = new ServidorChat(5000);
    }
}