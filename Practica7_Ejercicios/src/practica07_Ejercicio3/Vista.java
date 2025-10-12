package practica07_Ejercicio3;
import java.util.Scanner;

public class Vista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoControlador controlador = new EmpleadoControlador();
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE EMPLEADOS ===");
            System.out.println("1. Listar todos");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado por número");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> controlador.listar();
                case 2 -> {
                    System.out.print("Número: ");
                    int num = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Sueldo: ");
                    double s = sc.nextDouble();
                    controlador.agregarEmpleado(new Empleado(num, nom, s));
                }
                case 3 -> {
                    System.out.print("Número a buscar: ");
                    int num = sc.nextInt();
                    controlador.buscarEmpleado(num);
                }
                case 4 -> {
                    System.out.print("Número a eliminar: ");
                    int num = sc.nextInt();
                    controlador.eliminarEmpleado(num);
                }
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
