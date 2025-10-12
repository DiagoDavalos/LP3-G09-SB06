package practica6_Actividades;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class InfoArchivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== ACTIVIDAD 1: Información de Archivos y Directorios ===");
        System.out.print("Ingrese la ruta del archivo o directorio: ");
        String ruta = sc.nextLine();

        Path path = Paths.get(ruta);
        if (Files.exists(path)) {
            System.out.println("\n--- Información del recurso ---");
            System.out.println("Nombre: " + path.getFileName());
            System.out.println("Ruta absoluta: " + path.toAbsolutePath());
            System.out.println("¿Es directorio? " + Files.isDirectory(path));
            System.out.println("¿Es archivo? " + Files.isRegularFile(path));
            System.out.println("¿Ruta absoluta? " + path.isAbsolute());

            try {
                FileTime ultimaModificacion = Files.getLastModifiedTime(path);
                System.out.println("Última modificación: " + ultimaModificacion);
                System.out.println("Tamaño (bytes): " + Files.size(path));
            } catch (IOException e) {
                System.out.println("Error al obtener información del archivo.");
            }

            if (Files.isDirectory(path)) {
                System.out.println("\nContenido del directorio:");
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                    for (Path archivo : stream) {
                        System.out.println(" - " + archivo.getFileName());
                    }
                } catch (IOException e) {
                    System.out.println("Error al listar contenido del directorio.");
                }
            }
        } else {
            System.out.println("La ruta especificada no existe.");
        }

        sc.close();
    }
}
