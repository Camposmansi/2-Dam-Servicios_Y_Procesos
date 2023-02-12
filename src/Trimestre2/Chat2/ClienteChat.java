package Trimestre2.Chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ClienteChat {

    public ClienteChat(String direccion, int puerto, String nombreUsuario) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket cliente = new Socket(direccion, puerto);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter printWriter = new PrintWriter(cliente.getOutputStream(), true);
            System.out.println("Conectado al servidor");
            printWriter.println(nombreUsuario);
            EscucharMensajes escuchar = new EscucharMensajes(bufferedReader);
            escuchar.start();
            while (true) {
                String mensaje = scanner.nextLine();
                printWriter.println("(" + nombreUsuario + ") " + new Date() + " - " + mensaje);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClienteChat("localhost", 5000, args[0]);
    }

    static class EscucharMensajes extends Thread {
        private final BufferedReader entrada;

        public EscucharMensajes(BufferedReader entrada) {
            this.entrada = entrada;
        }

        public void run() {
            try {
                while (true) {
                    String mensaje = entrada.readLine();
                    if (mensaje != null) System.out.println(mensaje);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}