package aut22_TimerTimerTask;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class alarmaLevantarse extends TimerTask {

    /**
     * Ponemos una imagen de logo
     **/
    static Image image = Toolkit.getDefaultToolkit().getImage(".//src//minion.png");

    static TrayIcon trayIcon = new TrayIcon(image, "Alarma");

    /**
     * Formato utilizado para mostrar la hora actual.
     **/
    private final DateFormat timeFormat = SimpleDateFormat.getTimeInstance();

    public static void main(String[] args) {

        SystemTray systemTray = SystemTray.getSystemTray();

        /** Programar los minutos que ara el delay **/
        int minutos = 30;
        int alarma = (1000 * 60) * minutos;

        /** Programamos el Temporizador **/
        Timer temporizador = new Timer();
        temporizador.schedule(new alarmaLevantarse(), alarma, alarma);

        trayIcon.setImageAutoSize(true); //Damos formato al Logo
        trayIcon.setToolTip("Sistema de Seguridad"); // Mensaje del Icono

        /** Programamos una accion al acer click en el mensaje en nuestro caso, paramos la alarma */
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Parar Alarma");
                //trayIcon.displayMessage("Alarmaaa!", "Mostramos otro mensaje jajaja", TrayIcon.MessageType.INFO);
                systemTray.remove(trayIcon);
                System.exit(0);
            }
        });
        try {
            systemTray.add(trayIcon); // Ejecutamos el programa
        } catch (AWTException e) {
            System.err.println("No se pudo agregar TrayIcon.");
        }
    }

    @Override
    public void run() {
        /** Obtener el systemTray del sistema **/
        if (SystemTray.isSupported()) {
            trayIcon.displayMessage(
                    "Alarma",
                    "Te recuerdo que te tienes que levantar ",// + timeFormat.format(new Date()),
                    TrayIcon.MessageType.WARNING);
        } else System.err.println("SystemTray no es compatible");

        System.out.println("Te recuerdo que te tienes que levantar..." + timeFormat.format(new Date()));
    }
}
