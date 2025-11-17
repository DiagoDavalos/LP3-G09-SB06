package Actividades;

//Fig. 12.43: MarcoGridLayout.java
//GridLayout que contiene seis botones.
//Implementado por: Eduardo y [Compañero]
//Modificación: Se agregó el nombre de los integrantes en el título.

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoGridLayout extends JFrame implements ActionListener
{
 private final JButton[] botones; 
 private static final String[] nombres =
     { "uno", "dos", "tres", "cuatro", "cinco", "seis" };

 private boolean alternar = true;
 private Container contenedor; 
 private GridLayout cuadricula1;  
 private GridLayout cuadricula2;  

 public MarcoGridLayout()
 {
     // Título personalizado como pide la actividad
     super("Demostración de GridLayout - Integrantes: Diago y Diego");

     cuadricula1 = new GridLayout(2, 3, 5, 5);  
     cuadricula2 = new GridLayout(3, 2);       

     contenedor = getContentPane();
     setLayout(cuadricula1);

     botones = new JButton[nombres.length];

     for (int i = 0; i < nombres.length; i++)
     {
         botones[i] = new JButton(nombres[i]);
         botones[i].addActionListener(this);   
         add(botones[i]);  
     }
 }

 @Override
 public void actionPerformed(ActionEvent evento)
 {
     if (alternar)
         contenedor.setLayout(cuadricula2);
     else
         contenedor.setLayout(cuadricula1);

     alternar = !alternar;
     contenedor.validate(); // redistribuye los componentes
 }
}
