package Ejercicio1_4;

import java.io.*;

public class LlamaSumando_Estandar {

    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\src\\Ejercicio1_4");
        ProcessBuilder pb = new ProcessBuilder("java", "Sumando_Estandar.java");

        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); // Con el INHERIT se ejecuta el pb ya que el sumando_Estandar es un
        //un programa de meter parametros por teclado (INHERIT lo que hace es como si estas ejecutando el padre tanto lo de entrada como el de salida)
        //pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        pb.directory(directorio);

        // se ejecuta el proceso
        Process p = pb.start();

        // lectura -- obtiene la salida - No se usa por el redirectOutput
        //InputStream is = p.getInputStream();
        //int c;
        //while ((c = is.read()) != -1)
        //System.out.print((char) c);
        //is.close();

        // COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("\nValor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
