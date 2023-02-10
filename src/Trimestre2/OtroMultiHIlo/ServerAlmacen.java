package Trimestre2.OtroMultiHIlo;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerAlmacen {
    private final ServerSocket ss;
    private int stock;
    private volatile boolean cancel = false;

    /* */
    private ServerAlmacen(int stock) throws IOException {
        this.stock = stock;
        ss = new ServerSocket(9090, 2, InetAddress.getByName("localhost"));
    }

    /* */
    public static void main(String[] args) throws IOException {
        new ServerAlmacen(123).open();
    }

    /* */
    private void open() throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String local;
        Thread client = new Thread() {
            public void run() {
                boolean stop = false;
                int req;
                try {
                    while (!cancel) {
                        Socket cs = ss.accept();
                        final ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
                        final ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
                        while (!stop) {
                            String cmd = is.readUTF();
                            switch (cmd) {
                                case "estado":
                                    os.writeInt(stock);
                                    break;
                                case "salida":
                                    req = is.readInt();
                                    os.writeInt(changeStock(-req));
                                    break;
                                case "cerrar":
                                    stop = true;
                                    os.writeInt(0);
                                    cs.close();
                                    break;
                                default:
                                    os.writeInt(-1);
                            }
                        }
                    }
                } catch (IOException ex) {
                    if (!cancel) {
                        Logger.getLogger(ServerAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };

        System.out.println("Server accepting requests on port 9090");
        client.start();
        while (!cancel) {
            local = cin.readLine();
            switch (local) {
                case "estado":
                    System.out.printf("Stock: %d\n", stock);
                    break;
                case "cerrar":
                    cancel = true;
                    client.interrupt();
                    break;
                default:
                    System.out.println("Don't grok!");
            }
        }
        System.exit(0);
    }

    /* */
    private synchronized int changeStock(int amount) {
        if ((stock + amount) < 0) {
            return -1;
        }
        stock += amount;
        return stock;
    }
}