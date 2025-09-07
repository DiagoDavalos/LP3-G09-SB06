package Actividad;

import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime fechaCheckIn;
    private LocalDateTime fechaCheckOut;
    private double costoTotal;
    private Habitacion habitacion;
    private PoliticaCancelacion politica;

    public Reserva(LocalDateTime fechaCheckIn, LocalDateTime fechaCheckOut, double costoTotal, Habitacion habitacion, PoliticaCancelacion politica) {
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.costoTotal = costoTotal;
        this.habitacion = habitacion;
        this.politica = politica;
    }

    public boolean cancelar() {
        if (politica.puedeCancelar(this)) {
            System.out.println("Cancelación permitida sin penalidad.");
            return true;
        } else {
            double penalidad = politica.calcularPenalidad(this);
            System.out.println("Cancelación con penalidad: " + penalidad);
            return false;
        }
    }

    public LocalDateTime getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDateTime fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDateTime getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDateTime fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public PoliticaCancelacion getPolitica() {
        return politica;
    }

    public void setPolitica(PoliticaCancelacion politica) {
        this.politica = politica;
    }

    public boolean seSuperpone(LocalDateTime inicio, LocalDateTime fin) {
        return (inicio.isBefore(fechaCheckOut) && fin.isAfter(fechaCheckIn));
    }
}
