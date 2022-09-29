public class Sumando {
    public static void main(String[] args)  {

        if (args.length==1 || args.length==0) {
            System.exit(-1);
        }
        else {
            int numero1 = Integer.parseInt(args[0]);
            int numero2 = Integer.parseInt(args[1]);

            int resultado = numero1 + numero2;
            System.out.println("La suma es " + numero1 + " + " + numero2 + " = " + resultado);
            System.exit(0);
        }
    }
}
