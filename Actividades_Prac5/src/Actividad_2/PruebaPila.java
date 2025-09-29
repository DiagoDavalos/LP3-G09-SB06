package Actividad_2;

public class PruebaPila {
    public static void main(String[] args) {
        Pila<Integer> pilaEnteros = new Pila<>(5);
        System.out.println("Pila de enteros:");
        try {
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println("¿Contiene 20? " + pilaEnteros.contains(20));
            System.out.println("Sacando: " + pilaEnteros.pop());
            System.out.println("Sacando: " + pilaEnteros.pop());
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }

        Pila<Double> pilaDoubles = new Pila<>(3);
        System.out.println("\nPila de doubles:");
        try {
            pilaDoubles.push(1.1);
            pilaDoubles.push(2.2);
            pilaDoubles.push(3.3);
            System.out.println("¿Contiene 2.2? " + pilaDoubles.contains(2.2));
            System.out.println("Sacando: " + pilaDoubles.pop());
            System.out.println("Sacando: " + pilaDoubles.pop());
            System.out.println("Sacando: " + pilaDoubles.pop());
            System.out.println("Sacando: " + pilaDoubles.pop()); 
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
