package Ejercicio1_5;

import java.io.*;

public class Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File directorio = new File(".\\src\\Ejercicio1_5");
        ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");

        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        // se ejecuta el proceso
        Process p = pb.start();

        // Escribimos en el buffer y lo enviamos
        OutputStream os = p.getOutputStream();
        os.write("Hola caracola\n".getBytes());
        os.flush();

        // Obtenemos la lectura
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        is.close();

        // Comprobamos el error
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) {
                System.out.println("ERROR >" + liner);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
