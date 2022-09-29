package Ejercicio1_4;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Sumando_estándar {
    public static void main(String[] args) {

            try {
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in);

                System.out.println("Introduce un numero");
                String uno = br.readLine();
                System.out.println("Introduce un segundo numero");
                String dos = br.readLine();

                int a = parseInt(uno);
                int b = parseInt(dos);
                int suma = a + b;
                System.out.println("La suma de los numeros " + a + " y " + b + " es " + suma);
                System.exit(1);
            } catch (IllegalArgumentException n) {
                System.err.println("PARAMETROS INCORRECTOS");
                System.exit(-1);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}
