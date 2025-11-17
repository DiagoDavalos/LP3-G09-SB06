package Actividades;

//Fig. 12.22: PruebaCuadroCombinado.java
//Prueba de MarcoCuadroCombinado.
//Grupo 6 – Implementado por: Diago y Diego

import javax.swing.JFrame;

public class PruebaCuadroCombinado
{
 public static void main(String[] args)
 {
     MarcoCuadroCombinado marco = new MarcoCuadroCombinado();
     marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marco.setSize(350, 150);
     marco.setVisible(true);
 }
}
