package Ejercicio2;

import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("MENÚ DE INVENTARIO ");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }

    public int leerOpcion() {
        System.out.print("Selecciona una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("Inventario actual:");
            for (Producto p : productos) {
                System.out.println("- " + p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
