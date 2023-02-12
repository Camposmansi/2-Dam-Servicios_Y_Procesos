package Trimestre2.URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDescarga2 {
    public static URL url;
    public static URLConnection connection;
    public static InputStream inputStream;
    public static FileOutputStream outputStream;
    public static String ruta = "src/Trimestre2/URL/";
    public static byte[] buffer;
    public static int bytesRead;

    public static void main(String[] args) {
        try {
            // Descarga de la imagen
            url = new URL("http://www.insmet.cu/Pronostico/tv06.jpg");
            connection = url.openConnection();
            inputStream = connection.getInputStream();
            outputStream = new FileOutputStream(ruta + "tv06.jpg");
            buffer = new byte[1024];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("La imagen ha sido descargada.");

            // Descarga del instalador de Firefox
            url = new URL("https://download.mozilla.org/?product=firefox-stub&os=win&lang=es-ES");
            connection = url.openConnection();
            inputStream = connection.getInputStream();
            outputStream = new FileOutputStream(ruta + "firefox.exe");
            buffer = new byte[1024];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("El instalador de Firefox ha sido descargado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

