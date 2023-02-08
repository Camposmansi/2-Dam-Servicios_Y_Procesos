package Trimestre2.Ejercicio02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(60000); // Crear socket en el puerto 60000
        Socket clientSocket = serverSocket.accept(); // Aceptar conexión del cliente
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Crear lector para recibir mensaje del cliente
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true); // Crear escritor para enviar mensaje al cliente
        String messageFromClient = br.readLine(); // Recibir mensaje del cliente
        System.out.println("Mensaje del cliente: " + messageFromClient); // Mostrar mensaje del cliente en pantalla
        pw.println("Hola, cliente"); // Enviar mensaje al cliente
        clientSocket.close(); // Cerrar socket
        serverSocket.close(); // Cerrar socket del servidor
    }
}
