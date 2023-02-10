package Trimestre2.OtroMultiHIlo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        byte[] data = new byte[BUFFER_SIZE];

        DataInputStream dis = null;
        DataOutputStream dos = null;
        Socket socket = null;
        long fileSize = -1;

        try {
            //Nos conectamos con el servidor
            socket = new Socket("localhost", 1234);
            System.out.println("Conectado con: " + socket.getRemoteSocketAddress());

            //Obtenemos los flujos
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            //En este punto ya hemos obtenido los flujos, solicitamos el fichero a recibir
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el fichero que quieres recibir:");
            String strFichero = sc.nextLine();
            strFichero = new String(strFichero.getBytes(), StandardCharsets.UTF_8);

            //Enviamos el nombre del fichero que queremos recibir
            dos.writeUTF(strFichero);

            //Recibimos el tamaño del fichero
            fileSize = dis.readLong();

            //Si fileSize == -1, el fichero no existe. El servidor envía -1 en este caso
            if (fileSize != -1) {
                //Abrimos el fichero para escribir los bytes que recibiremos posteriormente
                DataOutputStream dosFile = new DataOutputStream(new FileOutputStream(new File(strFichero)));//"C:\\Users\\usuario\\Desktop\\Cliente\\" + strFichero)));

                int bytesReceived = 0;

                while (fileSize > 0 && (bytesReceived = dis.read(data, 0, BUFFER_SIZE)) > 0) {
                    //Escribimos en el fichero los bytes recibidos
                    fileSize -= bytesReceived;
                    dosFile.write(data, 0, bytesReceived);
                    System.out.println(bytesReceived);
                }

                System.out.println("Fichero recibido correctamente!!!");
                dosFile.close();
            } else {
                System.out.println("El fichero solicitado no existe");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Conexion con el servidor cerrada");

            if (fileSize != 0) {
                System.out.println("No se he realizado la recepción del fichero correctamente!");
            }
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }

                if (dos != null) {
                    dos.close();
                }

                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
