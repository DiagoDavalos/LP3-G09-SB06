package Actividades;

//Fig. 12.41: MarcoBorderLayout.java
//BorderLayout que contiene cinco botones.
//Implementado por: Diago y DIego
//Modificación solicitada: Se añadió el nombre de los integrantes en el título.

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoBorderLayout extends JFrame implements ActionListener
{
 private final JButton botones[];  
 private static final String nombres[] = {
     "Ocultar Norte", 
     "Ocultar Sur", 
     "Ocultar Este",
     "Ocultar Oeste", 
     "Ocultar Centro"
 };

 private final BorderLayout esquema;

 public MarcoBorderLayout()
 {
     // Título personalizado según la actividad
     super("Demostración de BorderLayout - Integrantes Grubo6: Diago y Diego");

     esquema = new BorderLayout(5, 5); 
     setLayout(esquema);

     botones = new JButton[nombres.length];

     // crear botones y registrar eventos
     for (int i = 0; i < nombres.length; i++)
     {
         botones[i] = new JButton(nombres[i]);
         botones[i].addActionListener(this);
     }

     add(botones[0], BorderLayout.NORTH);
     add(botones[1], BorderLayout.SOUTH);
     add(botones[2], BorderLayout.EAST);
     add(botones[3], BorderLayout.WEST);
     add(botones[4], BorderLayout.CENTER);
 }

 @Override
 public void actionPerformed(ActionEvent evento)
 {
     for (JButton boton : botones)
     {
         if (evento.getSource() == boton)
             boton.setVisible(false); 
         else
             boton.setVisible(true); 
     }

     esquema.layoutContainer(getContentPane());
 }
}
