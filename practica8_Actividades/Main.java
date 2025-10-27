package practica8_Actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Vamos a practicar\\Practica8_Actividad\\src\\NuevaPractica8.db");

            System.out.println(" Conectado correctamente a la base de datos NuevaPractica8.db");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Alumno (" +
                         "id INTEGER PRIMARY KEY, " +
                         "nombre TEXT NOT NULL, " +
                         "edad INTEGER NOT NULL)";
            stmt.execute(sql);
            System.out.println(" Tabla 'Alumno' verificada o creada.");
            String insertSQL = "INSERT INTO Alumno (id, nombre, edad) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertSQL);
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Diago");
            psInsert.setInt(3, 20);
            psInsert.executeUpdate();
            System.out.println(" Registro insertado con éxito.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumno");
            System.out.println("\n Datos actuales en la tabla Alumno:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                                   rs.getString("nombre") + " - " +
                                   rs.getInt("edad"));
            }

            rs.close();
            psInsert.close();
            stmt.close();
            con.close();
            System.out.println("\n Conexión cerrada correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
