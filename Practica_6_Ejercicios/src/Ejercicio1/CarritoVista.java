package Ejercicio1;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner;

    public CarritoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("1. Agregar producto al catálogo");
        System.out.println("2. Ver productos disponibles");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento y calcular envío");
        System.out.println("7. Realizar compra");
        System.out.println("8. Ver historial de compras");
        System.out.println("9. Salir");
    }

    public int leerOpcion() {
        System.out.print("Selecciona una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public double leerNumero(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
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
