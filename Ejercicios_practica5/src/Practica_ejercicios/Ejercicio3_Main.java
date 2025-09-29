package Practica_ejercicios;

public class Ejercicio3_Main {
    public static <F, S> void imprimirPar(Ejercicio1y2_Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Ejercicio1y2_Par<String, Integer> par1 = new Ejercicio1y2_Par<>("Edad", 19);
        Ejercicio1y2_Par<Double, Boolean> par2 = new Ejercicio1y2_Par<>(3.14, true);
        Ejercicio1y2_Par<String, String> par3 = new Ejercicio1y2_Par<>("Nombre", "Diago");

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);

        Ejercicio1y2_Par<String, Integer> par4 = new Ejercicio1y2_Par<>("Edad", 19);
        System.out.println("¿par1 es igual a par4? " + par1.esIgual(par4));
    }
}
