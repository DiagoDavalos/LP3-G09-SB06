package practica6_Actividades;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class Persona {
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("---------------------------");
    }
}
public class AgendaContactos {
    public static void main(String[] args) {
        String rutaArchivo = "C:/archivos/agenda.txt";
        ArrayList<Persona> agenda = new ArrayList<>();

        System.out.println("=== ACTIVIDAD 5: Agenda de Contactos ===");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    agenda.add(new Persona(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Contactos cargados: " + agenda.size());

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre a buscar: ");
        String nombreBuscado = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Persona p : agenda) {
            if (p.getNombre().toLowerCase().contains(nombreBuscado)) {
                System.out.println("\nContacto encontrado:");
                p.mostrarDatos();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontró ningún contacto con ese nombre.");
        }
        sc.close();
    }
}
