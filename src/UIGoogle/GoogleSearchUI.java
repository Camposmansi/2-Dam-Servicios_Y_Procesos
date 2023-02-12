package UIGoogle;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GoogleSearchUI {

    public static void main(String[] args) {
        // Crear una nueva ventana
        JFrame frame = new JFrame("Google Search");
        // Configurar la operación por defecto cuando se cierre la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un nuevo panel
        JPanel panel = new JPanel();
        // Establecer el layout del panel como GridBagLayout
        panel.setLayout(new GridBagLayout());

        // Crear una nueva instancia de GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        // Establecer el espaciado entre los elementos
        gbc.insets = new Insets(5, 5, 5, 5);

        // Añadimos la Clase Logo googleLogo
        GoogleLogo googleLogo = new GoogleLogo();
        // Configurar el relleno CENTRAL para el campo de googleLogo
        gbc.fill = GridBagConstraints.CENTER; // También puede ser con .NONE
        gbc.gridx = 0;                        // Establecer la posición x en la rejilla
        gbc.gridy = 0;                        // Establecer la posición y en la rejilla
        gbc.gridwidth = 4;                    // Establecer la anchura en la rejilla
        // Agregar el Logo al panel
        panel.add(googleLogo, gbc);

        // Crear un campo de texto para la búsqueda
        JTextField searchField = new JTextField(20);
        // Configurar el relleno como HORIZONTAL para el campo de texto para la búsqueda
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        panel.add(searchField, gbc);

        // Crear un botón de Buscar con Google
        JButton btnBuscar = new JButton("Buscar con Google");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(btnBuscar, gbc);

        // Crear un botón de Voy a tener suerte
        JButton btnTenerSuerte = new JButton("Voy a tener suerte");
        // Configurar el relleno como ninguno para el botón
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(btnTenerSuerte, gbc);

        // Crear un campo de texto para Ofrecido por Google
        JLabel lblGoogle = new JLabel("Ofrecido por Google en: ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(lblGoogle, gbc);

        // Crear un campo de texto para Catalan
        JLabel lblCatalan = new JLabel("català");
        lblCatalan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Establecer el modo del Cursor cuando se pase por encima
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        lblCatalan.setForeground(Color.BLUE); // Establecer el color de fondo
        panel.add(lblCatalan, gbc);

        // Crear un campo de texto para Gallego
        JLabel lblGalego = new JLabel("galego");
        lblGalego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        lblGalego.setForeground(Color.BLUE);
        panel.add(lblGalego, gbc);

        // Crear un campo de texto para Euskadi
        JLabel lblEuskara = new JLabel("euskara");
        lblEuskara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        lblEuskara.setForeground(Color.BLUE);
        panel.add(lblEuskara, gbc);

        // Agregar el panel a la ventana
        frame.add(panel);
        // Establecer el Icono
        Image icon = new ImageIcon(Objects.requireNonNull(GoogleSearchUI.class.getResource("favicon.png"))).getImage();
        frame.setIconImage(icon);
        // Maximizar la Ventana
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Establecer el tamaño de la ventana
        frame.setSize(800, 600); // es solo por si se minimiza la ventana
        // Hacer que la ventana sea visible
        frame.setVisible(true);
    }
}


