package Actividad_1;

public class PruebaMetodoGenerico {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices inválidos para el arreglo.");
        }
        int cantidad = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidad++;
        }
        System.out.println();
        return cantidad;
    }

    public static void main(String[] args) {
        Integer[] arregloEnteros = {1, 2, 3, 4, 5, 6};
        Double[] arregloDoubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] arregloCaracteres = {'H', 'O', 'L', 'A'};
        System.out.println("Imprimiendo arreglos completos:");
        imprimirArreglo(arregloEnteros);
        imprimirArreglo(arregloDoubles);
        imprimirArreglo(arregloCaracteres);
        System.out.println("\nImprimiendo subrangos:");
        try {
            imprimirArreglo(arregloEnteros, 1, 4);  
            imprimirArreglo(arregloDoubles, 0, 2); 
        } catch (InvalidSubscriptException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}