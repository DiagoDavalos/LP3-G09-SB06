package practica8_ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


import java.util.Scanner;

public class Main {
    static final String DB_URL = "jdbc:sqlite:C:/Vamos a practicar/Practica8_Actividad/src/Practica8_Menu.db";
    static final String CLAVE_SEGURA = "1234";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(DB_URL);
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Persona (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "nombre TEXT NOT NULL, " +
                         "edad INTEGER NOT NULL, " +
                         "correo TEXT NOT NULL)";
            stmt.execute(sql);

            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Ingresar persona");
                System.out.println("2. Mostrar personas");
                System.out.println("3. Actualizar persona");
                System.out.println("4. Borrar persona");
                System.out.println("0. Salir");
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1 -> ingresar(con, sc);
                    case 2 -> mostrar(con);
                    case 3 -> actualizar(con, sc);
                    case 4 -> borrar(con, sc);
                    case 0 -> System.out.println(" Saliendo...");
                    default -> System.out.println(" Opción no válida");
                }

            } while (opcion != 0);

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private static void ingresar(Connection con, Scanner sc) throws Exception {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        PreparedStatement ps = con.prepareStatement("INSERT INTO Persona (nombre, edad, correo) VALUES (?, ?, ?)");
        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.setString(3, correo);
        ps.executeUpdate();

        confirmarTransaccion(con, sc, "registro insertado");
    }

    private static void mostrar(Connection con) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Persona");
        System.out.println("\n📋 Lista de Personas:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " +
                               rs.getString("nombre") + " - " +
                               rs.getInt("edad") + " - " +
                               rs.getString("correo"));
        }
        rs.close();
    }

    private static void actualizar(Connection con, Scanner sc) throws Exception {
        System.out.print("Ingrese ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo correo: ");
        String correo = sc.nextLine();

        PreparedStatement ps = con.prepareStatement("UPDATE Persona SET nombre=?, edad=?, correo=? WHERE id=?");
        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.setString(3, correo);
        ps.setInt(4, id);
        ps.executeUpdate();

        confirmarTransaccion(con, sc, "registro actualizado");
    }

    private static void borrar(Connection con, Scanner sc) throws Exception {
        System.out.print("Ingrese ID a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        PreparedStatement ps = con.prepareStatement("DELETE FROM Persona WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        confirmarTransaccion(con, sc, "registro borrado");
    }

    private static void confirmarTransaccion(Connection con, Scanner sc, String operacion) throws Exception {
        System.out.print("Ingrese clave para confirmar cambios: ");
        String clave = sc.nextLine();

        if (clave.equals(CLAVE_SEGURA)) {
            con.commit();
            System.out.println(" Cambios confirmados, " + operacion + ".");
        } else {
            con.rollback();
            System.out.println("Clave incorrecta. Cambios revertidos.");
        }
    }
}
