package Actividades;

//Fig. 12.39: MarcoFlowLayout.java
//Implementado por: Eduardo y [Nombre del compañero]
//Modificación: Se cambió el título de la ventana para incluir a los integrantes del grupo.

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFlowLayout extends JFrame
{
 private final JButton botonJButtonIzquierda; 
 private final JButton botonJButtonCentro; 
 private final JButton botonJButtonDerecha;

 private final FlowLayout esquema; 
 private final Container contenedor; 

 public MarcoFlowLayout()
 {
     // AQUÍ COLOCAS TUS NOMBRES — obligatorio según la actividad
     super("Demostración de FlowLayout - Integrantes: Grupo 6 Diago y Diego");

     esquema = new FlowLayout();
     contenedor = getContentPane(); 
     setLayout(esquema);

     // Botón izquierda
     botonJButtonIzquierda = new JButton("Izquierda");
     add(botonJButtonIzquierda);
     botonJButtonIzquierda.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.LEFT);
                 esquema.layoutContainer(contenedor);
             }
         }
     );

     // Botón centro
     botonJButtonCentro = new JButton("Centro");
     add(botonJButtonCentro);
     botonJButtonCentro.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.CENTER);
                 esquema.layoutContainer(contenedor);
             }
         }
     );
     // Botón derecha
     botonJButtonDerecha = new JButton("Derecha");
     add(botonJButtonDerecha);
     botonJButtonDerecha.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.RIGHT);
                 esquema.layoutContainer(contenedor);
             }
         }
     );
 }
}
