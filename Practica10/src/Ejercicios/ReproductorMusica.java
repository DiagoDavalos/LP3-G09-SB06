package Ejercicios;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMusica extends JFrame {

    private Clip clip;
    private long posicionPausa = 0; 

    public ReproductorMusica() {
        setTitle("Reproductor de Música");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        add(btnReproducir);
        add(btnPausar);
        add(btnReanudar);

        try {
            File archivo = new File("musica.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando audio.");
            e.printStackTrace();
        }

        btnReproducir.addActionListener(e -> {
            if (clip != null) {
                clip.stop();
                clip.setFramePosition(0); 
                clip.start();
            }
        });

        btnPausar.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                posicionPausa = clip.getMicrosecondPosition();
                clip.stop();
            }
        });

        btnReanudar.addActionListener(e -> {
            if (clip != null) {
                clip.setMicrosecondPosition(posicionPausa);
                clip.start();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ReproductorMusica();
    }
}
