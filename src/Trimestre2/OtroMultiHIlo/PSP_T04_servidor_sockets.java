/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trimestre2.OtroMultiHIlo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author José Fernández Navas.DNI:28617644D <your.name at your.org>
 */
public class PSP_T04_servidor_sockets {


    public static void main(String[] args) {

        try {
            //Mantener conexión mientras salir sea false
            boolean salir = false;
            int puerto = 9090;

            //Creamos un ServerSocket a la escucha que acepta como parámetro el puerto a conectar
            ServerSocket servidor = new ServerSocket(puerto);

            System.out.println("Esperando conexión del cliente...");

            //Creamos un objeto de la clase socket que aceptará una conexión cliente entrante
            Socket cliente = servidor.accept();

            //Creamos flujo de entrada para recibir información del cliente
            BufferedReader recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            //Creamos un flujo de salida
            PrintWriter enviar = new PrintWriter(cliente.getOutputStream(), true);


            while (!salir) {
                //Esperar a recibir informacion por el flujo de entrada
                String comando = recibir.readLine();
                System.out.println("Comando recibido: " + comando);

                //Switch para los comandos que teclee el cliente
                if (comando.equals("salir")) {
                    salir = true;
                } else {
                    enviar.println("Comando no reconocido.");
                    System.out.println("Comando no reconocido.");
                }

            }
            cliente.close();
            servidor.close();


        } catch (IOException ex) {
            Logger.getLogger(PSP_T04_servidor_sockets.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
