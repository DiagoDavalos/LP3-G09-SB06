package Actividad;

public class CalculadoraPrecio {
    public double calcularPrecio(Habitacion habitacion, String temporada, double descuento) {
        double precio = habitacion.getPrecioBase();

        if ("alta".equalsIgnoreCase(temporada)) {
            precio *= 1.2; 
        } else if ("baja".equalsIgnoreCase(temporada)) {
            precio *= 0.8; 
        }

        return precio - (precio * descuento);
    }
}
