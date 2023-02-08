package Trimestre2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio01_CC {
    static InetAddress dr1, dr2, dr3;

    public static void main(String[] args) {
        try {


            dr1 = InetAddress.getByName("localhost");
            dr2 = InetAddress.getLocalHost();
            dr3 = InetAddress.getByName("asfsdfsdfasdf");

            /** 7.1.	Escribe un programa que obtenga la IP de la máquina local localhost. **/
            System.out.println("Metodo getHostAddress():\n\tIp localhost: \t\t" + dr1.getHostAddress()); // Para localhost
            System.out.println("Metodo getLocalHost(): \t" + dr2); // para ip local

            /** 7.2.	Llamando al Metodo mostrarInfo() **/
            mostrarInfo();

            /** 7.3.	Llamando al Metodo mostrarInfoWeb() **/
            mostrarInfoWeb();

            System.out.println("\n=========================================================\n");

            /** 7.4.	Como último paso, el programa mostrará el total de direcciones IP de la máquina representada por www.twitter.com. **/
            System.out.println("Metodo getAllByName():\n\tTODAS LAS DIRECCIONES IP DE " + dr3.getHostName() + ":");
            InetAddress[] direcciones = InetAddress.getAllByName(dr3.getHostName());

            for (int i = 0; i < direcciones.length; i++)
                System.out.println("\t\t" + direcciones[i].toString());

            //System.out.println("Metodo getAllByName(): \t" + Arrays.toString(InetAddress.getAllByName(dr1.getHostName())));
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 7.2. Escribe un método llamado mostrarInfo para mostrar toda la información
     * sobre dicha máquina
     **/
    public static void mostrarInfo() {
        System.out.println("Metodo getHostName(): \t" + dr1.getHostName());
        System.out.println("Metodo getCanonicalHostName(): \t" + dr1.getCanonicalHostName());
    }

    /**
     * 7.3.	Repetimos los pasos 7.1 y 7.2, pero con la máquina www.google.es.
     **/
    public static void mostrarInfoWeb() {
        try {
            System.out.println("\n=========================================================\n");

            dr1 = InetAddress.getByName("www.google.es");

            System.out.println("METODOS PARA: " + dr1.getHostName());
            System.out.println("Metodo getHostAddress():\t\t" + dr1.getHostAddress());
            System.out.println("Metodo getHostName(): \t\t\t" + dr1.getHostName());
            System.out.println("Metodo getCanonicalHostName(): \t" + dr1.getCanonicalHostName());

        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        }
    }
}
