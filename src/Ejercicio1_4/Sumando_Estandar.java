package Ejercicio1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumando_Estandar {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String num1, num2;
        try {
            System.out.print("Ingrese el primer numero:");
            num1 = br.readLine();
            System.out.print("Ingrese el segundo numero:");
            num2 = br.readLine();
            int resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
            System.out.print("EL resultado de " + num1 + " + " + num2 + " es: " + resultado);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero.");
            System.exit(-1);
        }
        //2ºOpcion
		/*Scanner reader = new Scanner(System.in);
		  String num1 = "5";
		  String num2 = "5";
		  int resultado;
		  int numero1,numero2;
			try {
				numero1 = Integer.parseInt(num1);
				numero2 = Integer.parseInt(num2);
				resultado = numero1 + numero2;
				System.out.println("La suma es " + numero1 + " + " + numero2 + " = " + resultado);
				System.exit(1);
			}catch(NumberFormatException e) {
				System.err.println("Se han introducido caracteres no numericos"); //El System.err muestra la frase en color rojo ya que es un error
				System.exit(-1);
			}*/
    }
}
