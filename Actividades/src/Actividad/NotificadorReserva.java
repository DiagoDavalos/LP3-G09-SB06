package Actividad;

public class NotificadorReserva {
    private CanalNotificacion canal;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificar(String mensaje) {
        canal.enviar(mensaje);
    }

    public CanalNotificacion getCanal() {
        return canal;
    }

    public void setCanal(CanalNotificacion canal) {
        this.canal = canal;
    }
}
