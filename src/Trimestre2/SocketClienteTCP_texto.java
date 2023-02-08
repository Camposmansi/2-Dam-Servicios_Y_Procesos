package Trimestre2;

import java.io.*;
import java.net.Socket;

public class SocketClienteTCP_texto {

    private static String serverIP;
    private static int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    //Atributos necesarios para intercambiar mensajes de texto
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketClienteTCP_texto(String serverIP, int serverPort) {
        super();
        SocketClienteTCP_texto.serverIP = serverIP;
        SocketClienteTCP_texto.serverPort = serverPort;
    }

    public static void main(String[] args) {
        serverIP = "localhost";
        serverPort = 1026;

        SocketClienteTCP_texto servidor = new SocketClienteTCP_texto(serverIP, serverPort);

        try {
            servidor.start();
            servidor.abrirCanalesDeTexto();
            servidor.escribirMensajeDeTexto("Mensaje enviado por el CLIENTE");

            System.out.println("Mensaje del servidor: " + servidor.leerMensajeDeTexto());
            servidor.cerrarCanalesDeTexto();
            servidor.stop();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    public void start() throws IOException {
        System.out.println("(CLIENTE) Conectando a la conexion...");
        socket = new Socket(serverIP, serverPort);
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(CLIENTE) Conexion establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(CLIENTE) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(CLIENTE) Conexiones cerradas.");
    }

    public void abrirCanalesDeTexto() {
        System.out.println("(Cliente) Abrimos canales de texto...");

        //canales de lectura
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        //canales de escritura
        pw = new PrintWriter(os);
        System.out.println("(Cliente) Canales de texto abiertos...");
    }

    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("(Cliente) Cerramos canales de texto...");

        //canales de lectura
        br.close();
        isr.close();

        //canales de escritura
        pw.close();
        System.out.println("(Cliente) Canales de texto cerrados...");
    }

    public String leerMensajeDeTexto() throws IOException {
        System.out.println("(Cliente) leyendo Mensaje...");
        String msg = br.readLine();
        System.out.println("(Cliente) Mensaje leido.");
        return msg;
    }

    public void escribirMensajeDeTexto(String mensaje) {
        System.out.println("(Cliente) Enviando Mensaje...");
        pw.println(mensaje);
        pw.flush();
        System.out.println("(Cliente) Mensaje enviado...");
    }
}
