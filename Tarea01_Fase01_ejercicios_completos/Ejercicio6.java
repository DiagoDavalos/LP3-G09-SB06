package LP3_Tarea01_Fase1;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        Scanner variable = new Scanner(System.in);

        System.out.print("Ingrese las horas: ");
        int horas = variable.nextInt();

        System.out.print("Ingrese los minutos: ");
        int minutos =variable.nextInt();

        System.out.print("Ingrese los segundos: ");
        int segundos = variable.nextInt();

        int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;

        System.out.println("Equivalente en segundos: " + totalSegundos);
    }
}
