package Ejercicios;

import javax.swing.*;
import java.awt.*;

public class GraficoLineas extends JFrame {
    private JTextField[] campos = new JTextField[7];
    private int[] temperaturas = new int[7];
    private JPanel panelGrafico;

    public GraficoLineas() {
        setTitle("Gráfico de Temperaturas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(2, 7));

        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        for (int i = 0; i < 7; i++) {
            JLabel label = new JLabel(dias[i], SwingConstants.CENTER);
            panelEntrada.add(label);
        }
        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField("0");
            panelEntrada.add(campos[i]);
        }
        add(panelEntrada, BorderLayout.NORTH);

        JButton boton = new JButton("Mostrar Gráfico");
        add(boton, BorderLayout.SOUTH);
        panelGrafico = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               
                int xInicial = 50;
                int separacion = 60;
                for (int i = 0; i < 6; i++) {
                    int x1 = xInicial + i * separacion;
                    int y1 = getHeight() - temperaturas[i] - 50;
                    int x2 = xInicial + (i + 1) * separacion;
                    int y2 = getHeight() - temperaturas[i + 1] - 50;
                    g.drawLine(x1, y1, x2, y2);
                    g.fillOval(x1 - 3, y1 - 3, 6, 6);
                }
                int xFinal = xInicial + 6 * separacion;
                int yFinal = getHeight() - temperaturas[6] - 50;
                g.fillOval(xFinal - 3, yFinal - 3, 6, 6);
            }
        };
        panelGrafico.setBackground(Color.WHITE);
        add(panelGrafico, BorderLayout.CENTER);
        boton.addActionListener(e -> {
            for (int i = 0; i < 7; i++) {
                try {
                    temperaturas[i] = Integer.parseInt(campos[i].getText());
                } catch (NumberFormatException ex) {
                    temperaturas[i] = 0;
                }
            }
            panelGrafico.repaint();
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new GraficoLineas();
    }
}
