package Actividad;

public class EnviadorSms implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("📱 Enviando SMS: " + mensaje);
    }
}
