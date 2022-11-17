package Ejercicio1_5;

import java.io.File;
import java.io.IOException;

public class Ejemplo5b {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", ".\\src\\Ejercicio1_5\\Ejemplo5.java");

        File fOut = new File(".\\src\\Ejercicio1_5\\salida.txt");
        File eErr = new File(".\\src\\Ejercicio1_5\\error.txt");

        pb.redirectOutput(fOut);
        pb.redirectError(eErr);
        pb.start();
    }
}
