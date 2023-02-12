package Trimestre2.URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDescarga1 {
    public static void main(String[] args) {
        try {
            // Crea una URL para la dirección especificada
            URL url = new URL("http://www.insmet.cu/Pronostico/tv06.jpg");

            // Abre una conexión a la URL especificada
            java.net.URLConnection connection = url.openConnection();

            // Obtiene el InputStream para leer los datos desde la URL
            InputStream in = connection.getInputStream();

            // Crea un archivo en disco para almacenar los datos descargados
            FileOutputStream out = new FileOutputStream("tv06.jpg");

            // Crea un buffer de lectura de 1024 bytes
            byte[] buffer = new byte[1024];

            // Variables para mantener la cantidad de datos leídos y escritos
            int read;
            int total = 0;

            // Leemos los datos desde el stream de entrada y los escribe en el archivo en disco
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
                total += read;
            }

            // Cierra los streams
            in.close();
            out.close();

            System.out.println("Archivo descargado con éxito. Tamaño total: " + total + " bytes.");
        } catch (MalformedURLException e) {
            System.out.println("La URL es inválida: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
        }
    }
}

