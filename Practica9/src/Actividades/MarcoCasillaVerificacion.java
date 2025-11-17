package Actividades;

//Fig. 12.17: MarcoCasillaVerificacion.java
//Botones JCheckBox y eventos de elementos.
//Grupo 6 – Implementado por: Diago y Diego

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame
{
 private JTextField campoTexto; // muestra el texto en tipos de letra cambiantes
 private JCheckBox negritaJCheckBox; // para seleccionar/deseleccionar negrita
 private JCheckBox cursivaJCheckBox; // para seleccionar/deseleccionar cursiva

 // Constructor: agrega objetos JCheckBox a JFrame
 public MarcoCasillaVerificacion()
 {
     super("Prueba de JCheckBox - Grupo 6: Diago y Diego");
     setLayout(new FlowLayout());

     // establece JTextField y su tipo de letra
     campoTexto = new JTextField(" Observe como cambia el estilo de tipo de letra", 20);
     campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
     add(campoTexto); // agrega campoTexto a JFrame

     negritaJCheckBox = new JCheckBox("Negrita");
     cursivaJCheckBox = new JCheckBox("Cursiva");
     add(negritaJCheckBox); 
     add(cursivaJCheckBox);

     // registra componentes de escucha para objetos JCheckBox
     ManejadorCheckBox manejador = new ManejadorCheckBox();
     negritaJCheckBox.addItemListener(manejador);
     cursivaJCheckBox.addItemListener(manejador);
 }

 // clase interna privada para el manejo de eventos ItemListener
 private class ManejadorCheckBox implements ItemListener
 {
     @Override
     public void itemStateChanged(ItemEvent evento)
     {
         Font tipoletra = null;

         // determina cuáles objetos CheckBox están seleccionados y crea el objeto Font
         if (negritaJCheckBox.isSelected() && cursivaJCheckBox.isSelected())
             tipoletra = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (negritaJCheckBox.isSelected())
             tipoletra = new Font("Serif", Font.BOLD, 14);
         else if (cursivaJCheckBox.isSelected())
             tipoletra = new Font("Serif", Font.ITALIC, 14);
         else
             tipoletra = new Font("Serif", Font.PLAIN, 14);

         campoTexto.setFont(tipoletra);
     }
 }
} // fin de la clase MarcoCasillaVerificacion
