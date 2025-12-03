package Ejercicios;

import java.util.ArrayList;

public class CentroNotificaciones {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void suscribir(Usuario u) {
        usuarios.add(u);
        System.out.println(u.getNombre() + " se ha suscrito al sistema.");
    }

    public void desuscribir(Usuario u) {
        usuarios.remove(u);
        System.out.println(u.getNombre() + " se ha desuscrito del sistema.");
    }

    public void enviarNotificacion(String msg) {
        Notificacion n = new Notificacion(msg);

        System.out.println("\n--- Enviando notificación ---");
        for (Usuario u : usuarios) {
            u.recibirNotificacion(n);
        }
    }
}
