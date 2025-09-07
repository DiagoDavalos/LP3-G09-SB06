package Actividad;

import java.time.LocalDateTime;
import java.util.List;

public class GestionDisponibbilidadCuarto {
    private List<Reserva> reservas;

    public GestionDisponibbilidadCuarto(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, LocalDateTime inicio, LocalDateTime fin) {
        for (Reserva r : reservas) {
            if (r.getHabitacion().equals(habitacion) && r.seSuperpone(inicio, fin)) {
                return false;
            }
        }
        return true;
    }

    public void marcarReservada(Habitacion habitacion) {
        habitacion.setDisponible(false);
    }

    public void marcarDisponible(Habitacion habitacion) {
        habitacion.setDisponible(true);
    }
}
