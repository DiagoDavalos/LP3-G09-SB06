package Ejercicios;

import javax.swing.*;
import java.awt.*;

public class Appproducto {

    static class Producto {
        private String nombre;
        private double precio;
        private int cantidadStock;
        private String categoria;

        public Producto(String nombre, double precio, int cantidadStock, String categoria) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidadStock = cantidadStock;
            this.categoria = categoria;
        }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public void setPrecio(double precio) { this.precio = precio; }
        public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public String getInfo() {
            return "<html>Nombre: " + nombre +
                   "<br>Precio: " + precio +
                   "<br>Cantidad: " + cantidadStock +
                   "<br>Categoría: " + categoria + "</html>";
        }
    }
    public static void main(String[] args) {

        Producto producto = new Producto("", 0.0, 0, "");

        JFrame frame = new JFrame("Gestión de Producto");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JTextField txtNombre = new JTextField(15);
        JTextField txtPrecio = new JTextField(15);
        JTextField txtStock = new JTextField(15);
        JTextField txtCategoria = new JTextField(15);
        JButton btnActualizar = new JButton("Actualizar Producto");
        JLabel lblInfo = new JLabel("Información del producto");
        btnActualizar.addActionListener(e -> {
            try {
                producto.setNombre(txtNombre.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setCantidadStock(Integer.parseInt(txtStock.getText()));
                producto.setCategoria(txtCategoria.getText());
                lblInfo.setText(producto.getInfo());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: Verifique los datos numéricos.");
            }
        });
        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Precio:"));
        frame.add(txtPrecio);
        frame.add(new JLabel("Stock:"));
        frame.add(txtStock);
        frame.add(new JLabel("Categoría:"));
        frame.add(txtCategoria);
        frame.add(btnActualizar);
        frame.add(lblInfo);
        frame.setVisible(true);
    }
}
