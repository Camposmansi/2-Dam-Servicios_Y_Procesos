package UIGoogle;

import javax.swing.*;
import java.awt.*;

public class GoogleLogo extends JComponent {

    // La fuente para el texto
    private final Font font = new Font("arial,sans-serif", Font.BOLD, 65);
    // Color verde del logo de Google
    Color color1 = new Color(0, 153, 0);
    // Color rojo del logo de Google
    Color color2 = new Color(204, 0, 0);
    // Color amarillo del logo de Google
    Color color3 = new Color(255, 204, 0);
    // Color azul del logo de Google
    Color color4 = new Color(51, 102, 153);
    // La cadena de texto a dibujar
    private final String text = "Google";
    // Un array de colores para cada letra de la cadena de texto
    private final Color[] colors = {color4, color2, color3, color4, color1, color2};

    @Override
    public void paintComponent(Graphics g) {
        // Llama al método paintComponent de la clase padre
        super.paintComponent(g);
        // Obtiene una instancia de Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        // Habilita la antialiasing para mejorar la calidad de los bordes suavizados
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // La posición inicial en x donde se dibujará la primera letra
        int x = 0;
        // Dibuja cada letra en la cadena de texto con un color y fuente específicos
        for (int i = 0; i < text.length(); i++) {
            g2d.setColor(colors[i]);
            g2d.setFont(font);
            g2d.drawString(String.valueOf(text.charAt(i)), x, 50);
            // Avanza la posición en x para la siguiente letra
            x += g2d.getFontMetrics().charWidth(text.charAt(i));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Especifica el tamaño preferido del componente
        return new Dimension(220, 80);
    }
}
