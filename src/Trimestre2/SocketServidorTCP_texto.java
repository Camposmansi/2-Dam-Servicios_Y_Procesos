package Trimestre2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidorTCP_texto {

    private final ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    //Atributos necesarios para intercambiar mensajes de texto
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketServidorTCP_texto(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public static void main(String[] args) {
        try {
            SocketServidorTCP_texto servidor = new SocketServidorTCP_texto(1026);
            servidor.start();
            servidor.abrirCanalesDeTexto();
            servidor.escribirMensajeDeTexto("Mensaje enviado por el SERVIDOR");

            System.out.println("Mensaje recibido del cliente:  " + servidor.leerMensajeDeTexto());
            servidor.cerrarCanalesDeTexto();
            servidor.os.write(200);

            servidor.stop();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    public void start() throws IOException {
        System.out.println("(SERVIDOR) Esperando conexiones...");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(SERVIDOR) Conexion establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(SERVIDOR) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(SERVIDOR) Conexiones cerradas.");
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
