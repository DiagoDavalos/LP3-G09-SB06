package Actividad;

public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("💬 Enviando notificación por Slack: " + mensaje);
    }
}
