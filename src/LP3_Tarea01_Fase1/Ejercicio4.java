package LP3_Tarea01_Fase1;

import java.util.Scanner;

public class Ejercicio4 {

    public static double menor(double a, double b, double c) {
        double menor = a;

        if (b < menor)
        {
            menor = b;
        }
        if (c < menor) 
        {
            menor = c;
        }
        return menor;
    }
    public static void main(String[] args) {
        Scanner variable = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double x = variable.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double y = variable.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double z = variable.nextDouble();

        double resultado = menor(x, y, z);
        System.out.println("El menor es: " + resultado);
    }
}
