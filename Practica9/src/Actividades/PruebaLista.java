package Actividades;

//Fig. 12.24: PruebaLista.java
//Selección de colores de un objeto JList.
//Grupo 6 – Implementado por: Diago y Diego

import javax.swing.JFrame;

public class PruebaLista
{
 public static void main(String[] args)
 {
     MarcoLista marcoLista = new MarcoLista();
     marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoLista.setSize(350, 150);
     marcoLista.setVisible(true);
 }
}
