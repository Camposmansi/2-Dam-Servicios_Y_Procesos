package Trimestre2.ChatMultiHilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat2 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 9999;
        Scanner teclado = new Scanner(System.in);
        try {
            Socket cliente = new Socket(host, puerto);
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            String mensaje = "";
            while (!mensaje.equals("*")) {
                mensaje = teclado.nextLine();
                salida.writeUTF(mensaje);
                System.out.println(entrada.readUTF());
            }
            cliente.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

