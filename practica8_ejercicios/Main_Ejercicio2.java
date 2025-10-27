package practica8_ejercicios;
import java.util.Scanner;
public class Main_Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor_Ejercicio2 gestor = new Gestor_Ejercicio2(10);

        gestor.agregarPersona(new Persona_Ejercicio2(1, "Diago", 20, "diago@gmail.com"));
        gestor.agregarPersona(new Persona_Ejercicio2(2, "Lucía", 22, "lucia@gmail.com"));
        gestor.agregarPersona(new Persona_Ejercicio2(3, "Pedro", 19, "pedro@gmail.com"));
        gestor.agregarPersona(new Persona_Ejercicio2(4, "Laura", 23, "laura@gmail.com"));

        System.out.println("=== CONSULTA DE PERSONAS (EJERCICIO 2) ===");

        System.out.print("¿Qué campo(s) desea mostrar? (todo, id, nombre, edad, correo): ");
        String campoMostrar = sc.nextLine();

        System.out.print("¿Desea aplicar alguna condición? (sí/no): ");
        String cond = sc.nextLine();
        String campoCond = "", valorCond = "";
        if (cond.equalsIgnoreCase("sí") || cond.equalsIgnoreCase("si")) {
            System.out.print("Campo de condición (nombre, edad, correo): ");
            campoCond = sc.nextLine();
            System.out.print("Valor del campo: ");
            valorCond = sc.nextLine();
        }

        System.out.print("¿Desea ordenar los registros? (sí/no): ");
        String ord = sc.nextLine();
        String ordenCampo = "";
        boolean asc = true;
        if (ord.equalsIgnoreCase("sí") || ord.equalsIgnoreCase("si")) {
            System.out.print("Campo para ordenar (id, nombre, edad): ");
            ordenCampo = sc.nextLine();
            System.out.print("Orden ascendente (true/false): ");
            asc = sc.nextBoolean();
            sc.nextLine();
        }

        System.out.print("¿Desea limitar la cantidad de registros? (0 = sin límite): ");
        int limite = sc.nextInt();

        gestor.consultar(campoMostrar, campoCond, valorCond, ordenCampo, asc, limite);

        sc.close();
    }
}
