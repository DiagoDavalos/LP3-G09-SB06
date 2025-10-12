package practica07_Ejercicios;
import java.io.*;
import java.util.*;
class Personaje2 {
    String nombre;
    int vida, ataque, defensa, alcance;

    public Personaje2(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public String formatoArchivo() {
        return nombre + ";" + vida + ";" + ataque + ";" + defensa + ";" + alcance;
    }

    @Override
    public String toString() {
        return nombre + " (Vida=" + vida + ", Ataque=" + ataque + ", Defensa=" + defensa + ", Alcance=" + alcance + ")";
    }
}
class GestorPersonajes2 {
    ArrayList<Personaje2> lista = new ArrayList<>();
    String ruta = "C:/archivos/personajes.txt";

    public GestorPersonajes2() {
        cargarArchivo();
        if (lista.isEmpty()) {
            cargarAleatorios();
        }
    }

    private void cargarArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                if (p.length == 5)
                    lista.add(new Personaje2(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]),
                            Integer.parseInt(p[3]), Integer.parseInt(p[4])));
            }
        } catch (IOException e) {
            System.out.println("(No se encontró archivo, se crearán personajes aleatorios)");
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Personaje2 p : lista)
                pw.println(p.formatoArchivo());
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void listar() {
        System.out.println("\n--- PERSONAJES ---");
        for (Personaje2 p : lista)
            System.out.println(p);
    }

    private void cargarAleatorios() {
        lista.add(new Personaje2("Caballero", 4, 2, 4, 2));
        lista.add(new Personaje2("Guerrero", 2, 4, 2, 4));
        lista.add(new Personaje2("Arquero", 2, 4, 1, 8));
        guardarArchivo();
    }

    public void filtrarPor(String atributo) {
        Comparator<Personaje2> comp = switch (atributo.toLowerCase()) {
            case "vida" -> Comparator.comparingInt(p -> p.vida);
            case "ataque" -> Comparator.comparingInt(p -> p.ataque);
            case "defensa" -> Comparator.comparingInt(p -> p.defensa);
            case "alcance" -> Comparator.comparingInt(p -> p.alcance);
            default -> null;
        };

        if (comp == null) {
            System.out.println("Atributo no válido.");
            return;
        }

        lista.sort(comp.reversed());
        listar();
    }

    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        for (Personaje2 p : lista) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida" -> p.vida = nuevoValor;
                    case "ataque" -> p.ataque = nuevoValor;
                    case "defensa" -> p.defensa = nuevoValor;
                    case "alcance" -> p.alcance = nuevoValor;
                    default -> {
                        System.out.println("Atributo no válido.");
                        return;
                    }
                }
                guardarArchivo();
                System.out.println("Atributo actualizado correctamente.");
                return;
            }
        }
        System.out.println(" Personaje no encontrado.");
    }

    public void mostrarEstadisticas() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes.");
            return;
        }

        double totalVida = 0, totalAtaque = 0, totalDefensa = 0, totalAlcance = 0;
        for (Personaje2 p : lista) {
            totalVida += p.vida;
            totalAtaque += p.ataque;
            totalDefensa += p.defensa;
            totalAlcance += p.alcance;
        }

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Total de personajes: " + lista.size());
        System.out.printf("Promedio Vida: %.2f\n", totalVida / lista.size());
        System.out.printf("Promedio Ataque: %.2f\n", totalAtaque / lista.size());
        System.out.printf("Promedio Defensa: %.2f\n", totalDefensa / lista.size());
        System.out.printf("Promedio Alcance: %.2f\n", totalAlcance / lista.size());
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorPersonajes2 gestor = new GestorPersonajes2();
        int opcion;

        do {
            System.out.println("\n=== MENÚ EJERCICIO 2 ===");
            System.out.println("1. Listar personajes");
            System.out.println("2. Filtrar por atributo");
            System.out.println("3. Actualizar un atributo");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestor.listar();
                case 2 -> {
                    System.out.print("Atributo (vida/ataque/defensa/alcance): ");
                    String at = sc.nextLine();
                    gestor.filtrarPor(at);
                }
                case 3 -> {
                    System.out.print("Nombre del personaje: ");
                    String nombre = sc.nextLine();
                    System.out.print("Atributo a cambiar: ");
                    String atributo = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int nuevo = sc.nextInt();
                    gestor.actualizarAtributo(nombre, atributo, nuevo);
                }
                case 4 -> gestor.mostrarEstadisticas();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
