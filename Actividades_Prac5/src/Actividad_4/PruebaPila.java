package Actividad_4;

public class PruebaPila {
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);

        pila1.push(10);
        pila1.push(20);
        pila1.push(30);

        pila2.push(10);
        pila2.push(20);
        pila2.push(30);

        System.out.println("¿pila1 y pila2 son iguales? " + pila1.esIgual(pila2));

        pila2.pop();
        pila2.push(40);

        System.out.println("¿pila1 y pila2 son iguales después del cambio? " + pila1.esIgual(pila2));

        Pila<String> pila3 = new Pila<>();
        Pila<String> pila4 = new Pila<>();
        System.out.println("¿pila3 y pila4 (vacías) son iguales? " + pila3.esIgual(pila4));
    }
}
