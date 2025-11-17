package Actividades;

//Fig. 12.26: PruebaSeleccionMultiple.java
//Prueba de MarcoSeleccionMultiple.
//Grupo 6 – Implementado por: Diago y Diego

import javax.swing.JFrame;

public class PruebaSeleccionMultiple
{
 public static void main(String[] args)
 {
     MarcoSeleccionMultiple marco = new MarcoSeleccionMultiple();
     marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marco.setSize(350, 140);
     marco.setVisible(true);
 }
}
