package Trimestre2.Ejercicio02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 60000); // Conectar con el servidor en el host "localhost" y el puerto 60000
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // Crear escritor para enviar mensaje al servidor
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Crear lector para recibir mensaje del servidor
        pw.println("Hola, servidor"); // Enviar mensaje al servidor
        String messageFromServer = br.readLine(); // Recibir mensaje del servidor
        System.out.println("Mensaje del servidor: " + messageFromServer); // Mostrar mensaje del servidor en pantalla
        socket.close(); // Cerrar socket
    }
}

