package Trimestre2.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLv4 {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("http://www.google.es");
            URL url2 = new URL("https://docs.oracle.com/javase/7");
            URL url3 = new URL("https://docs.oracle.com:491/javase/7/docs/api/java/net/URL.html");

            mostrarInfo(url1);
            mostrarInfo(url2);
            mostrarInfo(url3);
        } catch (MalformedURLException e) {
            System.out.println("Error al construir la URL: " + e.getMessage());
        }
    }

    public static void mostrarInfo(URL url) {
        System.out.println("\nURL: " + url.toString());
        System.out.println("Protocolo: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Puerto por defecto: " + url.getDefaultPort());
        System.out.println("Puerto: " + url.getPort());
        System.out.println("Fichero: " + url.getFile());
    }
}
