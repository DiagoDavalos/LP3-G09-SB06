package Ejercicio;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CompraPasaje extends JFrame {

    JTextField txtNombre, txtDni, txtFecha;
    JCheckBox chkAudifonos, chkManta, chkRevistas;
    JRadioButton rbPiso1, rbPiso2;
    JComboBox<String> cboOrigen, cboDestino;
    JList<String> listaCalidad;
    JButton btnMostrar, btnLimpiar;

    public CompraPasaje() {

        setTitle("Compra de Pasajes");
        setSize(450, 500);
        setLayout(new FlowLayout());
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtDni = new JTextField(20);
        add(txtDni);

        add(new JLabel("Fecha de viaje:"));
        txtFecha = new JTextField(15);
        add(txtFecha);

        add(new JLabel("Servicios opcionales:"));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        add(chkAudifonos);
        add(chkManta);
        add(chkRevistas);

        add(new JLabel("Piso del bus:"));
        rbPiso1 = new JRadioButton("1er Piso");
        rbPiso2 = new JRadioButton("2do Piso");

        ButtonGroup grupoPisos = new ButtonGroup();
        grupoPisos.add(rbPiso1);
        grupoPisos.add(rbPiso2);

        add(rbPiso1);
        add(rbPiso2);

        add(new JLabel("Origen:"));
        cboOrigen = new JComboBox<>();
        cboOrigen.addItem("Lima");
        cboOrigen.addItem("Arequipa");
        cboOrigen.addItem("Cusco");
        cboOrigen.addItem("Puno");
        add(cboOrigen);

        add(new JLabel("Destino:"));
        cboDestino = new JComboBox<>();
        cboDestino.addItem("Lima");
        cboDestino.addItem("Arequipa");
        cboDestino.addItem("Cusco");
        cboDestino.addItem("Puno");
        add(cboDestino);


        add(new JLabel("Calidad de servicio:"));
        String[] calidades = {"Económico", "Standard", "VIP"};
        listaCalidad = new JList<>(calidades);
        listaCalidad.setVisibleRowCount(3);
        add(new JScrollPane(listaCalidad));


        btnMostrar = new JButton("Mostrar Datos");
        btnLimpiar = new JButton("Limpiar");
        add(btnMostrar);
        add(btnLimpiar);


        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String servicios = "";
                if (chkAudifonos.isSelected()) servicios += "Audífonos ";
                if (chkManta.isSelected()) servicios += "Manta ";
                if (chkRevistas.isSelected()) servicios += "Revistas ";
                if (servicios.equals("")) servicios = "Ninguno";

                String piso = "No seleccionado";
                if (rbPiso1.isSelected()) piso = "Primer piso";
                if (rbPiso2.isSelected()) piso = "Segundo piso";

                String calidad = listaCalidad.getSelectedValue();
                if (calidad == null) calidad = "No seleccionada";

                String mensaje = "Nombre: " + txtNombre.getText() +
                                 "\nDNI: " + txtDni.getText() +
                                 "\nFecha: " + txtFecha.getText() +
                                 "\nOrigen: " + cboOrigen.getSelectedItem() +
                                 "\nDestino: " + cboDestino.getSelectedItem() +
                                 "\nPiso: " + piso +
                                 "\nServicios: " + servicios +
                                 "\nCalidad: " + calidad;

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtNombre.setText("");
                txtDni.setText("");
                txtFecha.setText("");

                chkAudifonos.setSelected(false);
                chkManta.setSelected(false);
                chkRevistas.setSelected(false);

                rbPiso1.setSelected(false);
                rbPiso2.setSelected(false);

                cboOrigen.setSelectedIndex(0);
                cboDestino.setSelectedIndex(0);

                listaCalidad.clearSelection();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CompraPasaje();
    }
}
