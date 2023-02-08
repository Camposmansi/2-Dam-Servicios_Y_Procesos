package Trimestre2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUDPServer {
    public static void main(String[] args) {
        try {
            System.out.println("(SERVIDOR) Creando el socket...");
            DatagramSocket socket = new DatagramSocket(1026);

            System.out.println("(SERVIDOR) Recibiendo datagrama...");
            byte[] bufferLectura = new byte[64];
            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramaEntrada);
            System.out.println("(SERVIDOR) Mensaje recibido: " + new String(bufferLectura));

            System.out.println("(SERVIDOR) Enviando datagrama...");
            byte[] mensajeEnviado = "Mensaje enviado desde el servidor".getBytes();
            DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado,
                    mensajeEnviado.length,
                    datagramaEntrada.getAddress(),
                    datagramaEntrada.getPort()); //con el getAddress y el getPort para
            // que el servidor sepa la direccion del cliente y el puerto
            socket.send(datagramaSalida);

            System.out.println("(SERVIDOR) Cerrando SOCKET...");
            socket.close();
            System.out.println("(SERVIDOR) SOCKET cerrado.");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
