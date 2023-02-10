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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author José Fernández Navas.DNI:28617644D <your.name at your.org>
 */
public class PSP_T04_cliente2_sockets {


    public static void main(String[] args) {
        try {
            //Creamos una variable para los comandos a introducir
            String comando = "";
            String direccionIp = "127.0.0.1";
            int puerto = 9090;

            //Creamos un flujo de entrada de datos para teclado
            BufferedReader lectorDeComandos = new BufferedReader(new InputStreamReader(System.in));

            //El cliente debe conocer la dirección ip y el puerto de conexión
            //Hay que solicitarla para establecer la conexión

            System.out.println("Introduzca la dirección ip del servidor: [127.0.0.1]");
            comando = lectorDeComandos.readLine();
            if (!comando.equalsIgnoreCase("")) {
                direccionIp = comando;


            }

            System.out.println("Introduzca el puerto al que conectarse: [9090]");
            comando = lectorDeComandos.readLine();

            if (!comando.equalsIgnoreCase("")) {
                puerto = Integer.parseInt(comando);

            }

            //Pasamos la ip y el puerto al socket
            Socket cliente = new Socket(direccionIp, puerto);
            System.out.println("Conexión establecida.");

            //Flujo salida para poder enviar informacion al servidor
            PrintWriter enviar = new PrintWriter(cliente.getOutputStream(), true);
            //Flujo entrada para recibir la información del servidor
            BufferedReader recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));


            while (!comando.equalsIgnoreCase("salir")) {
                System.out.println();
                System.out.println("Por favor, introduzca un comando: ");

                comando = lectorDeComandos.readLine();
                enviar.println(comando);
                System.out.println(recibir.readLine());
            }


        } catch (IOException ex) {
            Logger.getLogger(PSP_T04_cliente2_sockets.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
