package Trimestre2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SocketUDPClient {
    public static void main(String[] args) {
        try {
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 1026;


            System.out.println("(CLIENTE) Creando el socket...");
            DatagramSocket socket = new DatagramSocket();

            System.out.println("(CLIENTE) Enviando datagrama...");
            byte[] mensaje = "Mensaje enviado desde el cliente".getBytes();
            DatagramPacket peticion = new DatagramPacket(mensaje,
                    mensaje.length,
                    hostServidor,
                    puertoServidor);
            socket.send(peticion);

            System.out.println("(CLIENTE) Recibiendo datagrama...");
            byte[] bufferLectura = new byte[64];
            DatagramPacket respuesta = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(respuesta);
            System.out.println("(CLIENTE) Mensaje recibido: " + new String(bufferLectura));


            System.out.println("(CLIENTE) Cerrando SOCKET...");
            socket.close();
            System.out.println("(CLIENTE) SOCKET cerrado.");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
