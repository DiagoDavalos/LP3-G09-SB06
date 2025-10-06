package Ejercicio3;

import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner;

    public JuegoVista() {
        scanner = new Scanner(System.in);
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("ESTADO ACTUAL");
        System.out.println("Jugador: " + jugador);
        System.out.println("Enemigo: " + enemigo);
    }

    public void mostrarMenu() {
        System.out.println("MENU DE BATALLA");
        System.out.println("1. Atacar");
        System.out.println("2. Ver estado");
        System.out.println("3. Rendirse");
    }

    public int leerOpcion() {
        System.out.print("Selecciona una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
