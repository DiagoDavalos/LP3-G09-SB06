package Actividades;

//Fig. 12.20: PruebaBotonOpcion.java
//Prueba de MarcoBotonOpcion.
//Grupo 6 – Implementado por: Diago y Diego

import javax.swing.JFrame;

public class PruebaBotonOpcion
{
 public static void main(String[] args)
 {
     MarcoBotonOpcion marco = new MarcoBotonOpcion();
     marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marco.setSize(300, 120);
     marco.setVisible(true);
 }
}
