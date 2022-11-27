package Ejemplos;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) throws IOException {

        File miDir = new File(".");
        System.out.println("Directorio actual: " + miDir.getCanonicalPath());

        //creamos objeto File al directorio donde esta Ejemplos Ejemplo2
        File directorio = new File(".\\src\\Ejemplos");

        //El proceso a ejecutar es Ejemplo2.java
        ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo2.java");

        //se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        //se ejecuta el proceso
        Process p = pb.start();

        //obtener la salida devuelta por el proceso
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) System.out.println("Error >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}// Ejemplos.Ejemplo3