package practica07_Ejercicios;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }
    public String getNombre() {
        return nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return nombre + " - Vida:" + vida + " Ataque:" + ataque + " Defensa:" + defensa + " Alcance:" + alcance;
    }

    public String toFileFormat() {
        return nombre + ";" + vida + ";" + ataque + ";" + defensa + ";" + alcance;
    }
}

class GestorPersonajes {
    private ArrayList<Personaje> lista;
    private String rutaArchivo = "C:/archivos/personajes.txt";

    public GestorPersonajes() {
        lista = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5) {
                    lista.add(new Personaje(
                        datos[0],
                        Integer.parseInt(datos[1]),
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4])
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Personaje p : lista) {
                pw.println(p.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void agregar(Personaje p) {
        for (Personaje existente : lista) {
            if (existente.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println(" El personaje ya existe. No se creará.");
                return;
            }
        }
        lista.add(p);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    public void listar() {
        System.out.println("\n--- LISTA DE PERSONAJES ---");
        for (Personaje p : lista) {
            System.out.println(p);
        }
    }
    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarEnArchivo();
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println(" No se encontró el personaje.");
    }

    public void eliminar(String nombre) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                lista.remove(i);
                guardarEnArchivo();
                System.out.println(" Personaje eliminado correctamente.");
                return;
            }
        }
        System.out.println(" No se encontró el personaje.");
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorPersonajes gestor = new GestorPersonajes();
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE PERSONAJES ===");
            System.out.println("1. Listar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestor.listar();
                case 2 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Vida: ");
                    int v = sc.nextInt();
                    System.out.print("Ataque: ");
                    int a = sc.nextInt();
                    System.out.print("Defensa: ");
                    int d = sc.nextInt();
                    System.out.print("Alcance: ");
                    int al = sc.nextInt();
                    gestor.agregar(new Personaje(n, v, a, d, al));
                }
                case 3 -> {
                    System.out.print("Nombre del personaje a modificar: ");
                    String n = sc.nextLine();
                    System.out.print("Nueva vida: ");
                    int v = sc.nextInt();
                    System.out.print("Nuevo ataque: ");
                    int a = sc.nextInt();
                    System.out.print("Nueva defensa: ");
                    int d = sc.nextInt();
                    System.out.print("Nuevo alcance: ");
                    int al = sc.nextInt();
                    gestor.modificar(n, v, a, d, al);
                }
                case 4 -> {
                    System.out.print("Nombre del personaje a eliminar: ");
                    String n = sc.nextLine();
                    gestor.eliminar(n);
                }
                case 5 -> System.out.println("Saliendo del gestor...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
        sc.close();
    }
}
