/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Trimestre2.Ejemplos2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class _01_TestInetAddress {

    public static void main(String[] args) {
        InetAddress dir = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce yo para la maquina local o una web/ip: ");
        String url = sc.nextLine();
        try {
            if (url.equalsIgnoreCase("yo")) {
                url = "localhost";
            }

            System.out.println("========================================================");
            System.out.println("SALIDA PARA " + url);
            System.out.println("========================================================");


            //PRIMERA PRUEBA CON LOCALHOST
            dir = InetAddress.getByName(url);
            pruebaMetodos(dir);//

/*
            //SEGUNDA PRUEBA CON www.youtube.es
            System.out.println("========================================================");
            System.out.println("SALIDA PARA UNA URL (www.youtube.es):");
            System.out.println("========================================================");
            dir = InetAddress.getByName("www.youtube.es");
            pruebaMetodos(dir);

            // Array de tipo InetAddress con todas las direcciones IP
            //asignadas a www.youtube.es
            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());

            for (int i = 0; i < direcciones.length; i++)
                System.out.println("\t\t" + direcciones[i].toString());
*/
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);

            // Probamos los métodos de la clase InetAddress
            System.out.println("\tMetodo getByName():  " + dir);
            System.out.println("\tMetodo getHostName(): " + dir.getHostName());
            System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
            System.out.println("\tMetodo toString(): " + dir);
            System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}//fin




