package Actividad;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false; 
    }

    @Override
    public double calcularPenalidad(Reserva reserva) {
        return reserva.getCostoTotal(); 
    }
}
