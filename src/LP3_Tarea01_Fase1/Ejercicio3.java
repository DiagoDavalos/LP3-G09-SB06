package LP3_Tarea01_Fase1;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] frecuencia = new int[6];

        for (int i = 0; i < 20000; i++) {
            int lanzamiento = rand.nextInt(6) + 1; 
            frecuencia[lanzamiento - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("Cara " + (i+1) + ": " + frecuencia[i] + " veces");
        }
    }
}
