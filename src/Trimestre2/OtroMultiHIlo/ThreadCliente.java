package Trimestre2.OtroMultiHIlo;

import java.io.*;
import java.net.Socket;

public class ThreadCliente extends Thread {

    private static final int BUFFER_SIZE = 8192;
    private Socket cliente = null;
    private DataOutputStream dos = null;
    private DataInputStream dis = null;
    private boolean parar = false;

    //Constructor, aquí pasamos el socket obtenido en la clase Servidor como resultado del método accept()
    public ThreadCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        // Obtenemos los flujos
        try {
            dos = new DataOutputStream(this.cliente.getOutputStream());
            dis = new DataInputStream(this.cliente.getInputStream());
            // Creamos un buffer de 8KB
            byte[] data = new byte[BUFFER_SIZE];

            while (!parar) {
                // Leemos el fichero que el servidor debe mandar
                String strFichero = dis.readUTF();
                System.out.println(
                        "El cliente: " + this.cliente.getLocalAddress() + " ha solicitado el fichero: " + strFichero);

                // Obtenemos las propiedades del fichero a obtener
                File fFichero = new File(strFichero);//"C:\\Users\\usuario\\Desktop\\Servidor\\" + strFichero);

                // Comprobamos si el fichero existe
                if (fFichero.exists()) {
                    long fileSize = fFichero.length();
                    int bytesLeidos;

                    //Enviamos el tamaño del fichero
                    dos.writeLong(fileSize);

                    DataInputStream disFichero = new DataInputStream(new FileInputStream(fFichero));

                    while ((bytesLeidos = disFichero.read(data, 0, BUFFER_SIZE)) > 0) {
                        //Enviamos los bytes que hemos leido
                        dos.write(data, 0, bytesLeidos);
                    }
                    System.out.println("Fichero enviado correctamente");
                    //Cerramos el flujo de lectura del fichero
                    disFichero.close();
                } else {
                    //El fichero no existe, enviamos -1 para informar al cliente
                    dos.writeLong(-1);
                }

            }

        } catch (IOException e) {
            System.out.println("Conexion con cliente: " + cliente.getRemoteSocketAddress() + " cerrada");
        } finally {
            parar();
        }

        System.out.println("Thread finalizado");

    }

    public void parar() {
        parar = true;

        try {
            if (dos != null) {
                dos.close();
            }

            if (dis != null) {
                dis.close();
            }

            if (cliente != null) {
                cliente.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
