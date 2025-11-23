package Ejercicios;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class AppSonidos {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Efectos de Sonido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JButton b1 = new JButton("Aplausos");
        b1.setBounds(50, 20, 180, 30);
        b1.addActionListener(e -> reproducir("aplausos.wav"));

        JButton b2 = new JButton("Campana");
        b2.setBounds(50, 60, 180, 30);
        b2.addActionListener(e -> reproducir("campana.wav"));

        JButton b3 = new JButton("Explosión");
        b3.setBounds(50, 100, 180, 30);
        b3.addActionListener(e -> reproducir("explosion.wav"));

        frame.add(b1); frame.add(b2); frame.add(b3);
        frame.setVisible(true);
    }

    public static void reproducir(String ruta){
        try {
            File f = new File(ruta);
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception e){
            System.out.println("No se pudo reproducir: " + ruta);
        }
    }
}
