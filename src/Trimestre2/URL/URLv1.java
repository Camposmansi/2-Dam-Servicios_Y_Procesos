package Trimestre2.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLv1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.es");
            System.out.println("Protocol: " + url.getProtocol());
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida.");
        }
    }
}
