package Trimestre2.Ejemplos2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _03_SocketServidorTCP {
    private final ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public _03_SocketServidorTCP(int puerto) throws IOException {
        this.serverSocket = new ServerSocket(puerto);
    }

    public static void main(String[] args) {
        int puerto = 1026;
        try {
            _03_SocketServidorTCP servidor = new _03_SocketServidorTCP(puerto);
            servidor.start();
            System.out.println("Mensaje recibido del cliente: " + servidor.is.read());
            System.out.println("Se envia un mensaje al cliente: ");
            servidor.os.write(200);

            servidor.stop();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void start() throws IOException {
        System.err.println("(SERVIDOR) Esperando conexiones....");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(SERVIDOR) Conexion establecida.");
    }

    public void stop() throws IOException {
        System.err.println("(SERVIDOR) Cerrando conexiones....");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(SERVIDOR) Conexiones cerradas.");
    }
}
