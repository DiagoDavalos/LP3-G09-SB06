package Ejercicios;

public class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void recibirNotificacion(Notificacion n) {
        System.out.println("[" + nombre + "] recibió: " + n.getMensaje());
    }

    public String getNombre() {
        return nombre;
    }
}
