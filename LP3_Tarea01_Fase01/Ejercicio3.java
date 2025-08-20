package PrimeroT1.LP3_Tarea01_Fase01;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] frecuencia = new int[6];

        // 20 000 lanzamientos
        for (int i = 0; i < 20000; i++) {
            int lanzamiento = rand.nextInt(6) + 1; // genera un número entre 1 y 6

            // aumentar la frecuencia según la cara
            frecuencia[lanzamiento - 1]++;
        }

        // Mostrar resultados
        for (int i = 0; i < 6; i++) {
            System.out.println("Cara " + (i+1) + ": " + frecuencia[i] + " veces");
        }
    }
}
