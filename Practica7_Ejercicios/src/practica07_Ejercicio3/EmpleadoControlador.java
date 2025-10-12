package practica07_Ejercicio3;
import java.io.*;
import java.util.ArrayList;
public class EmpleadoControlador {
    private ArrayList<Empleado> lista = new ArrayList<>();
    private String ruta = "C:/archivos/empleados.txt";

    public EmpleadoControlador() {
        leerEmpleados();
    }
    public void leerEmpleados() {
        lista.clear();
        File archivo = new File(ruta);
        if (!archivo.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    int num = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    double sueldo = Double.parseDouble(datos[2]);
                    lista.add(new Empleado(num, nombre, sueldo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Empleado e : lista) {
                pw.println(e.formatoArchivo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void listar() {
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado e : lista) {
                System.out.println(e);
            }
        }
    }

    public void agregarEmpleado(Empleado nuevo) {
        for (Empleado e : lista) {
            if (e.getNumero() == nuevo.getNumero()) {
                System.out.println(" Ya existe un empleado con ese número.");
                return;
            }
        }
        lista.add(nuevo);
        guardarArchivo();
        System.out.println(" Empleado agregado correctamente.");
    }

    public void buscarEmpleado(int numero) {
        for (Empleado e : lista) {
            if (e.getNumero() == numero) {
                System.out.println(" Empleado encontrado:");
                System.out.println(e);
                return;
            }
        }
        System.out.println(" No se encontró ningún empleado con ese número.");
    }
    public void eliminarEmpleado(int numero) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumero() == numero) {
                lista.remove(i);
                guardarArchivo();
                System.out.println(" Empleado eliminado correctamente.");
                return;
            }
        }
        System.out.println(" No se encontró ningún empleado con ese número.");
    }
}
