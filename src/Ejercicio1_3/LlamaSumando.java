package Ejercicio1_3;

import java.io.*;

public class LlamaSumando {
    public static void main(String[] args) throws IOException {
        // File miDir= new File(".");
        // System.out.println("mi directorio es "+miDir.getCanonicalPath());
        int valor;
        File dir = new File(".\\src\\Ejercicio1_3");

        ProcessBuilder pb = new ProcessBuilder("java", "Sumando.java", "5", "6");
        pb.directory(dir);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        Process p = pb.start();

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
            valor = p.waitFor();
            System.out.println("Valor de salida " + valor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
