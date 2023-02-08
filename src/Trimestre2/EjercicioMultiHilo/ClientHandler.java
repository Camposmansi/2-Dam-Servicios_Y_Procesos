package Trimestre2.EjercicioMultiHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
    private final Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.client = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error al crear los flujos de entrada y salida: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("*")) {
                    System.out.println("Conexión cerrada por el cliente");
                    break;
                }
                out.println(inputLine.toUpperCase()); //Lo ponemos en mayusculas la misma respuesta
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            System.out.println("Error en la conexión con el cliente: " + e.getMessage());
        }
    }
}

