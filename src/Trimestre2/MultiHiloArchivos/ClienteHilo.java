package Trimestre2.MultiHiloArchivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteHilo extends Thread {

    private final DataInputStream in;
    private final DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

        Scanner sn = new Scanner(System.in);

        String mensaje;
        int opcion = 0;
        boolean salir = false;

        while (!salir) {

            try {
                System.out.println("1. Almacenar numero en el archivo");
                System.out.println("2. Numeros almacenados hasta el momento");
                System.out.println("3. Lista de numeros almacenados");
                System.out.println("4. El numero de numeros almacenados por el cliente");
                System.out.println("5. Crear archivo con los numeros del cliente");
                System.out.println("6. Salir");

                opcion = sn.nextInt();
                out.writeInt(opcion);

                switch (opcion) {
                    case 1:
                        // Genero un numero aleatorio del 1 al 100
                        int numeroaleatorio = generaNumeroAleatorio(1, 100);
                        System.out.println("numero generado: " + numeroaleatorio);
                        // Le mando al servidor el numero aleatorio
                        out.writeInt(numeroaleatorio);
                        // Recibo y muestro el mensaje
                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                        break;
                    case 2:
                        // recibo el numero de lineas
                        int numLineas = in.readInt();
                        System.out.println("Hay " + numLineas + " números");
                        break;
                    case 3:
                        // recibo el numero de numeros que hay
                        int limite = in.readInt();
                        // Recibo los numeros uno a uno
                        for (int i = 0; i < limite; i++) {
                            System.out.println(in.readInt());
                        }
                        break;
                    case 4:
                        // Recibo el numero de lineas
                        int numLineasCliente = in.readInt();
                        System.out.println("Hay " + numLineasCliente + " números de este cliente");
                        break;
                    case 5:
                        // recibo el limite de bytes
                        int limiteFichero = in.readInt();
                        // Creo un array de bytes
                        byte[] contenidoFichero = new byte[limiteFichero];

                        // Recibo el contenido array
                        for (int i = 0; i < limiteFichero; i++) {
                            contenidoFichero[i] = in.readByte();
                        }
                        // Creo el string 
                        String contenido = new String(contenidoFichero);
                        // lo guardo en un nuevo fichero
                        FileWriter fw = new FileWriter("numeros_cliente.txt");
                        fw.write(contenido);
                        fw.close();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        mensaje = in.readUTF();
                        System.out.println(mensaje);

                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
}
