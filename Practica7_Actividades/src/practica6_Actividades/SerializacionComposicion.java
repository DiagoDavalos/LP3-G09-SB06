package practica6_Actividades;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Departamento implements Serializable {
    private String nombre;
    private String codigo;

    public Departamento(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    @Override
    public String toString() {
        return "Departamento: " + nombre + " (Código: " + codigo + ")";
    }}
class Empleado implements Serializable {
    private String nombre;
    private double sueldo;
    private Departamento departamento;
    public Empleado(String nombre, double sueldo, Departamento departamento) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }
    @Override
    public String toString() {
        return "Empleado: " + nombre + " | Sueldo: " + sueldo + " | " + departamento;
    }}
public class SerializacionComposicion {
    public static void main(String[] args) {
        String rutaArchivo = "C:/archivos/empleados.dat";
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> lista = new ArrayList<>();
        System.out.println("=== ACTIVIDAD 6: Serialización con Composición ===");
        System.out.print("¿Cuántos empleados desea registrar?: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEmpleado #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Sueldo: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.print("Departamento: ");
            String depNombre = sc.nextLine();
            System.out.print("Código del departamento: ");
            String depCodigo = sc.nextLine();
            Departamento dep = new Departamento(depNombre, depCodigo);
            Empleado emp = new Empleado(nombre, sueldo, dep);
            lista.add(emp);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(lista);
            System.out.println("\nEmpleados guardados correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            ArrayList<Empleado> leidos = (ArrayList<Empleado>) ois.readObject();
            System.out.println("\n--- Empleados leídos desde el archivo ---");
            for (Empleado e : leidos) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        sc.close(); }}