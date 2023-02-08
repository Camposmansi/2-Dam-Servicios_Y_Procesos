package Trimestre2.Ejemplos2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class _03_SocketClienteTCP {
    private final String serverIP;
    private final int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public _03_SocketClienteTCP(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {
        String serverIP = "localhost";
        int serverPort = 1026;
        _03_SocketClienteTCP servidor = new _03_SocketClienteTCP(serverIP, serverPort);
        try {
            servidor.start();
            servidor.os.write(50);
            System.out.println("Mensaje del servidor: " + servidor.is.read());
            servidor.stop();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void start() throws IOException {
        System.err.println("(CLIENTE) Estableciendo conexion....");
        socket = new Socket(serverIP, serverPort);
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(CLIENTE) Conexion establecida.");
    }

    public void stop() throws IOException {
        System.err.println("(CLIENTE) Cerrando conexiones....");
        is.close();
        os.close();
        socket.close();
        System.out.println("(CLIENTE) Conexiones cerradas.");
    }
}
