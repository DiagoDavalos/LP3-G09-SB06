package Practica_ejercicios;

import java.util.ArrayList;

public class Ejercicio4_Contenedor<F, S> {
    private ArrayList<Ejercicio1y2_Par<F, S>> lista;

    public Ejercicio4_Contenedor() {
        lista = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        lista.add(new Ejercicio1y2_Par<>(primero, segundo));
    }

    public Ejercicio1y2_Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public ArrayList<Ejercicio1y2_Par<F, S>> obtenerTodosLosPares() {
        return lista;
    }

    public void mostrarPares() {
        for (Ejercicio1y2_Par<F, S> par : lista) {
            System.out.println(par);
        }
    }
 


public static void main(String[] args) {

        System.out.println("Probando Contenedor:");
        Ejercicio4_Contenedor<String, Integer> contenedor = new Ejercicio4_Contenedor<>();
        contenedor.agregarPar("A", 1);
        contenedor.agregarPar("B", 2);
        contenedor.agregarPar("C", 3);

        contenedor.mostrarPares();
    }
}
