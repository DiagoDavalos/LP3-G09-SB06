package Actividad;

public class GenerarInforme {
    public void generarInforme(Habitacion habitacion) {
        System.out.println("Informe de Habitación:");
        System.out.println("Número: " + habitacion.getNumero());
        System.out.println("Tipo: " + habitacion.getTipo());
        System.out.println("Precio Base: " + habitacion.getPrecioBase());
        System.out.println("Disponible: " + habitacion.isDisponible());
    }
}
