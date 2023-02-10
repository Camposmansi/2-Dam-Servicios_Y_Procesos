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
        gbc.fill = GridBagConstraints.CENTER; // Tambien puede ser con .NONE
        gbc.gridx = 0;                        // Establecer la posición x en la rejilla
        gbc.gridy = 0;                        // Establecer la posición y en la rejilla
        gbc.gridwidth = 4;                    // Establecer la anchura en la rejilla
        panel.add(googleLogo, gbc);

        // Crear un campo de texto para la búsqueda
        JTextField searchField = new JTextField(20);
        // Configurar el relleno horizontal para el campo de texto
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Establecer la posición x en la rejilla
        gbc.gridx = 0;
        // Establecer la posición y en la rejilla
        gbc.gridy = 1;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 4;
        // Establecer el color de fondo para el campo de texto
        //searchField.setBackground(Color.BLUE);
        // Agregar el campo de texto al panel
        panel.add(searchField, gbc);

        // Crear un botón de búsqueda
        JButton btnBuscar = new JButton("Buscar con Google");
        // Configurar el relleno como HORIZONTAL para el botón de búsqueda
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Establecer la posición x en la rejilla
        gbc.gridx = 0;
        // Establecer la posición y en la rejilla
        gbc.gridy = 2;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 1;
        // Agregar el botón de búsqueda al panel
        panel.add(btnBuscar, gbc);

        // Crear un botón de búsqueda
        JButton btnTenerSuerte = new JButton("Voy a tener suerte");
        // Configurar el relleno como ninguno para el botón
        gbc.fill = GridBagConstraints.NONE;
        // Establecer la posición x en la rejilla
        gbc.gridx = 1;
        // Establecer la posición y en la rejilla
        gbc.gridy = 2;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 3;
        // Agregar el botón de búsqueda al panel
        panel.add(btnTenerSuerte, gbc);

        // Crear un campo de texto para la búsqueda
        JLabel lblGoogle = new JLabel("Ofrecido por Google en: ");
        // Configurar el relleno horizontal para el campo de texto
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Establecer la posición x en la rejilla
        gbc.gridx = 0;
        // Establecer la posición y en la rejilla
        gbc.gridy = 3;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 1;
        // Agregar el campo de texto al panel
        panel.add(lblGoogle, gbc);

        // Crear un campo de texto para la búsqueda
        JLabel lblCatalan = new JLabel("català");
        lblCatalan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Configurar el relleno horizontal para el campo de texto
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Establecer la posición x en la rejilla
        gbc.gridx = 1;
        // Establecer la posición y en la rejilla
        gbc.gridy = 3;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 1;
        // Establecer el color de fondo para el campo de texto
        lblCatalan.setForeground(Color.BLUE);
        // Agregar el campo de texto al panel
        panel.add(lblCatalan, gbc);

        // Crear un campo de texto para la búsqueda
        JLabel lblGalego = new JLabel("galego");
        lblGalego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Configurar el relleno horizontal para el campo de texto
        gbc.fill = GridBagConstraints.NONE;
        // Establecer la posición x en la rejilla
        gbc.gridx = 2;
        // Establecer la posición y en la rejilla
        gbc.gridy = 3;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 1;
        // Establecer el color de fondo para el campo de texto
        lblGalego.setForeground(Color.BLUE);
        // Agregar el campo de texto al panel
        panel.add(lblGalego, gbc);

        // Crear un campo de texto para la búsqueda
        JLabel lblEuskara = new JLabel("euskara");
        lblEuskara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Configurar el relleno horizontal para el campo de texto
        gbc.fill = GridBagConstraints.NONE;
        // Establecer la posición x en la rejilla
        gbc.gridx = 3;
        // Establecer la posición y en la rejilla
        gbc.gridy = 3;
        // Establecer la anchura en la rejilla
        gbc.gridwidth = 1;
        // Establecer el color de fondo para el campo de texto
        lblEuskara.setForeground(Color.BLUE);
        // Agregar el campo de texto al panel
        panel.add(lblEuskara, gbc);

        // Agregar el panel a la ventana
        frame.add(panel);
        // Establecer el tamaño de la ventana
        frame.setSize(800, 600);
        // Hacer que la ventana se ajuste al tamaño de los componentes
        //frame.pack();
        // Establecemos el Icono
        Image icon = new ImageIcon(Objects.requireNonNull(GoogleSearchUI.class.getResource("favicon.png"))).getImage();
        frame.setIconImage(icon);
        // Maximizar la Ventana
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Hacer que la ventana sea visible
        frame.setVisible(true);
    }
}


