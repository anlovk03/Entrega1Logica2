//Lista circular

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase interna para la animación del círculo rebotando
public class AnimacionCirculo extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int xDir = 3;
    private int yDir = 3;
    private final int DIAMETRO = 100; // Incrementar el diámetro del círculo a 100
    private Timer timer;

    public AnimacionCirculo() {
        timer = new Timer(10, this); // Crear un temporizador que se ejecuta cada 10 ms
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.pink);
        g.fillOval(x, y, DIAMETRO, DIAMETRO); // Dibuja un círculo 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += xDir;
        y += yDir;
        if (x < 0 || x + DIAMETRO > getWidth()) {
            xDir = -xDir; // Cambiar la dirección horizontal cuando choque con el borde
        }
        if (y < 0 || y + DIAMETRO > getHeight()) {
            yDir = -yDir; // Cambiar la dirección vertical cuando choque con el borde
        }
        repaint(); // Volver a pintar el componente
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación de Círculo Rebotando");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        AnimacionCirculo animacion = new AnimacionCirculo();
        frame.add(animacion);
        frame.setVisible(true);
    }
}
