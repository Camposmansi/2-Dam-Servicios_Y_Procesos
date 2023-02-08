package Trimestre2.EjercicioMultiHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor_Multihilo {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Servidor iniciado en el puerto 6000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Conexión aceptada desde: " + client.getInetAddress().getHostAddress());

                ClientHandler handler = new ClientHandler(client);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

