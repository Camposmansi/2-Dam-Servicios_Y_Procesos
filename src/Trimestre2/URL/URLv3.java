package Trimestre2.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLv3 {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("http://www.google.es");
            System.out.println("URL 1: " + url1);
        } catch (MalformedURLException e) {
            System.out.println("Error en la construcción de URL 1: " + e.getMessage());
        }

        try {
            URL url2 = new URL("https", "docs.oracle.com", "/javase/7");
            System.out.println("URL 2: " + url2);
        } catch (MalformedURLException e) {
            System.out.println("Error en la construcción de URL 2: " + e.getMessage());
        }

        try {
            URL url3 = new URL("https", "docs.oracle.com", 491, "/javase/7/docs/api/java/net/URL.html");
            System.out.println("URL 3: " + url3);
        } catch (MalformedURLException e) {
            System.out.println("Error en la construcción de URL 3: " + e.getMessage());
        }

        try {
            URL url4 = new URL("htps://www.google.es");
            System.out.println("URL 4: " + url4);
        } catch (MalformedURLException e) {
            System.out.println("Error en la construcción de URL 4: " + e.getMessage());
        }
    }
}
