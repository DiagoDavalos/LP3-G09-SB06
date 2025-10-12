package practica6_Actividades;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.*;

public class MostrarArchivoGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           new MostrarArchivoGUI().mostrarVentana();
        });
    }

    public void mostrarVentana() {
        JFrame frame = new JFrame("Actividad 4: Visualizar archivo en JTextArea");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        frame.add(scroll);
        frame.setVisible(true);

        String rutaArchivo = "C:/archivos/datos.txt"; 

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }

        } catch (IOException e) {
            areaTexto.setText("Error al leer el archivo: " + e.getMessage());
        }
    }
}