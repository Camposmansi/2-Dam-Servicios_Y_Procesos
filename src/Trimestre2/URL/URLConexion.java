package Trimestre2.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConexion {
    public static void main(String[] args) {
        try {
            // Creamos un objeto URL que represente la dirección de la URL con la que queremos comunicarnos
            URL url = new URL("https://www.arteguias.com/alcazar/alcazartoledo.htm");

            // Establecemos la conexión con la URL
            java.net.URLConnection connection = url.openConnection();
            // Obtenemos un objeto BufferedReader para leer los datos de la URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // Leemos los datos de la URL y los almacenamos en una variable
            String line;
            while ((line = reader.readLine()) != null) {
                // Mostramos la línea leída en la consola
                System.out.println(line);
            }
            reader.close(); // Cerramos el objeto BufferedReader
        } catch (Exception e) {
            // Imprimimos una traza de la excepción si se produce algún error
            e.printStackTrace();
        }
    }
}


