import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemTrayDemo {

    static Image image = Toolkit.getDefaultToolkit().getImage("src/minion.png");

    static TrayIcon trayIcon = new TrayIcon(image, "Tester");

    public static void main(String[] a) throws Exception {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("In here");
                    trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.INFO);
                }
            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("No se pudo agregar TrayIcon.");
            }
        }
    }
}