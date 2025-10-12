package practica6_Actividades;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class SelectorArchivo extends JFrame {

    private JTextArea areaTexto;
    private JButton botonAbrir;

    public SelectorArchivo() {
        super("Actividad 7: Uso de JFileChooser");

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        botonAbrir = new JButton("Abrir archivo");
        botonAbrir.addActionListener(e -> abrirArchivo());


        add(scroll, BorderLayout.CENTER);
        add(botonAbrir, BorderLayout.SOUTH);
    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showOpenDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
                areaTexto.setText(""); 
                String linea;
                while ((linea = br.readLine()) != null) {
                    areaTexto.append(linea + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Error al leer el archivo: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SelectorArchivo ventana = new SelectorArchivo();
            ventana.setVisible(true);
        });
    }
}
