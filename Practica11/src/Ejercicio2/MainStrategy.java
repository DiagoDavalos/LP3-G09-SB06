package Ejercicio2;

import java.util.Scanner;

public class MainStrategy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto producto = new Producto("Audífonos", 100);

        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        System.out.println("Ingrese cantidad:");
        int cantidad = sc.nextInt();

        System.out.println("\nSeleccione descuento:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Porcentual (30% por 2 productos)");
        System.out.println("4. Descuento Acumulado (50% a partir de 3 productos)");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1: calc.setEstrategia(new SinDescuento()); break;
            case 2: calc.setEstrategia(new DescuentoFijo()); break;
            case 3: calc.setEstrategia(new DescuentoPorcentual()); break;
            case 4: calc.setEstrategia(new DescuentoPorcentualAcumulado()); break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        double precioFinal = calc.calcular(producto, cantidad);

        System.out.println("\nPrecio final: " + precioFinal);
    }
}
