package Actividad;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
    double calcularPenalidad(Reserva reserva);
}
