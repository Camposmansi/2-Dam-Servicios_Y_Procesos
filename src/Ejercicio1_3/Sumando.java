package Ejercicio1_3;

import static java.lang.Integer.parseInt;

public class Sumando {
    public static void main(String[] args) {
        if (args.length == 1 || args.length == 0) {
            System.err.println("FALTAN PARAMETROS");
            System.exit(-1);
        } else {
            try {
                int a = parseInt(args[0]);
                int b = parseInt(args[1]);
                int suma = a + b;
                System.out.println("La suma de los numeros  " + a + " y " + b + " es " + suma);
                System.exit(1);
            } catch (IllegalArgumentException n) {
                System.err.println("PARAMETROS INCORRECTOS");
                System.exit(-1);

            }
        }
    }
}
