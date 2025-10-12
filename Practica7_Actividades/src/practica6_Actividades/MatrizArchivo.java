package practica6_Actividades;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class MatrizArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo = "C:/archivos/matriz.bin";
        System.out.println("=== ACTIVIDAD 3: Escritura y lectura de una matriz ===");
        try {
            System.out.print("Ingrese número de filas: ");
            int filas = sc.nextInt();
            System.out.print("Ingrese número de columnas: ");
            int columnas = sc.nextInt();
            double[][] matriz = new double[filas][columnas];

            System.out.println("\nIngrese los valores de la matriz:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    matriz[i][j] = sc.nextDouble();
                }
            }
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {
                dos.writeInt(filas);      
                dos.writeInt(columnas);   

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        dos.writeDouble(matriz[i][j]);
                    }
                }
            }
            System.out.println("\nMatriz guardada correctamente en: " + rutaArchivo);
            System.out.println("\nLeyendo la matriz guardada...");

            try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaArchivo))) {
                int f = dis.readInt();
                int c = dis.readInt();

                double[][] matrizLeida = new double[f][c];

                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        matrizLeida[i][j] = dis.readDouble();
                    }
                }

                System.out.println("\n--- Matriz leída desde el archivo ---");
                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        System.out.print(matrizLeida[i][j] + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al acceder al archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de entrada: " + e.getMessage());
        }
        sc.close();
    }
}
