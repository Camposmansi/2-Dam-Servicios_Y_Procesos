package Trimestre2.EjercicioMultiHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_Multihilo {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost", 6000);
            System.out.println("Conexión establecida con el servidor");

            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);

            Scanner keyboard = new Scanner(System.in);
            String inputLine;
            while (true) {
                System.out.print("Ingrese una cadena (ingrese * para finalizar la conexión): ");
                inputLine = keyboard.nextLine();
                if (inputLine.equals("*")) {
                    break;
                }
                out.println(inputLine);
                System.out.println("Respuesta del servidor: " + in.readLine());
            }

            in.close();
            out.close();
            server.close();
            System.out.println("Conexión finalizada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
