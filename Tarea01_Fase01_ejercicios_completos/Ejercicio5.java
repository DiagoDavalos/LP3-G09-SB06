package LP3_Tarea01_Fase1;

import java.util.Scanner;

public class Ejercicio5 {

    public static double calcularCargo(double horas) {
        double cargo;

        if (horas <= 1) {
            cargo = 3.0;
        } else {
            cargo = 3.0 + (horas - 1) * 0.5;
        }

        if (cargo > 12.0) {
            cargo = 12.0;
        }

        return cargo;
    }

    public static void main(String[] args) {
        Scanner variable = new Scanner(System.in);
        System.out.print("Ingrese el número de horas que estuvo estacionado: ");
        double horas = variable.nextDouble(); 

        double costo = calcularCargo(horas);
        System.out.println("El cargo es: S/ " + costo);
    }
}
