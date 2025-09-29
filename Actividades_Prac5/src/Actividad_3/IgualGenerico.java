package Actividad_3;

public class IgualGenerico {

    public static <T> boolean esIgualA(T a, T b) {
        if (a == b) { 
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b); 
    }

    public static void main(String[] args) {
        System.out.println("Comparando enteros:");
        System.out.println("¿10 y 10 son iguales? " + esIgualA(10, 10));
        System.out.println("¿10 y 20 son iguales? " + esIgualA(10, 20));

        System.out.println("\nComparando doubles:");
        System.out.println("¿3.14 y 3.14 son iguales? " + esIgualA(3.14, 3.14));
        System.out.println("¿3.14 y 2.71 son iguales? " + esIgualA(3.14, 2.71));

        System.out.println("\nComparando cadenas:");
        System.out.println("¿'Hola' y 'Hola' son iguales? " + esIgualA("Hola", "Hola"));
        System.out.println("¿'Hola' y 'Adiós' son iguales? " + esIgualA("Hola", "Adiós"));

        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();
        System.out.println("\nComparando objetos:");
        System.out.println("¿obj1 y obj2 son iguales? " + esIgualA(obj1, obj2));
        System.out.println("¿obj1 y obj3 son iguales? " + esIgualA(obj1, obj3));

        System.out.println("\nComparando con null:");
        System.out.println("¿null y null son iguales? " + esIgualA(null, null));
        System.out.println("¿null y 'texto' son iguales? " + esIgualA(null, "texto"));
    }
}
