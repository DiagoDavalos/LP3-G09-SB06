package practica07_Ejercicios;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class Ejercicio4 {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto");
        int opcion = fileChooser.showOpenDialog(null);
        if (opcion != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo. Saliendo...");
            return;
        }
        File archivo = fileChooser.getSelectedFile();
        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("El archivo no existe o no es válido.");
            return;
        }

        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> conteoPalabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.replace("\n", "").length();
                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ]", "").toLowerCase();

                    if (!palabra.isEmpty()) {
                        totalPalabras++;
                        conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
            double promedio = totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;

            System.out.println("\n=== RESULTADOS DEL ARCHIVO ===");
            System.out.println("Archivo: " + archivo.getName());
            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de caracteres: " + totalCaracteres);
            System.out.printf("Promedio de palabras por línea: %.2f\n", promedio);

            System.out.println("\n--- Palabras más frecuentes ---");

            if (conteoPalabras.isEmpty()) {
                System.out.println("No se encontraron palabras.");
            } else {
                List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(conteoPalabras.entrySet());
                listaOrdenada.sort((a, b) -> b.getValue() - a.getValue());

                int limite = Math.min(5, listaOrdenada.size()); // mostrar top 5
                for (int i = 0; i < limite; i++) {
                    System.out.println(listaOrdenada.get(i).getKey() + " -> " + listaOrdenada.get(i).getValue());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
