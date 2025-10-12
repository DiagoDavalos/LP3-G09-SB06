package practica6_Actividades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo = "C:/archivos/datos.txt";


        System.out.println("=== ACTIVIDAD 2: Uso de try-with-resources ===");
        System.out.println("Escriba líneas de texto. Para finalizar, escriba 'salir'.");
        try (FileWriter fw = new FileWriter(rutaArchivo, true); 
             PrintWriter pw = new PrintWriter(fw)) {

            while (true) {
                System.out.print("> ");
                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("salir")) {
                    break;
                }

                pw.println(linea);
            }

            System.out.println("\nLas líneas fueron guardadas correctamente en " + rutaArchivo);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        sc.close();
    }
}