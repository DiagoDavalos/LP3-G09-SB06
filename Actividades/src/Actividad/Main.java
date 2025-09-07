package Actividad;

public class Main {
    public static void main(String[] args) {
        NotificadorReserva notificadorCorreo = new NotificadorReserva(new EnviadorCorreo());
        notificadorCorreo.notificar("Su reserva ha sido confirmada.");

        NotificadorReserva notificadorSMS = new NotificadorReserva(new EnviadorSms());
        notificadorSMS.notificar("Su reserva ha sido cancelada.");

        NotificadorReserva notificadorSlack = new NotificadorReserva(new NotificadorSlack());
        notificadorSlack.notificar("Nueva reserva registrada en el sistema.");
    }
}
