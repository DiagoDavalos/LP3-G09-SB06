package Ejercicios;

public class MainObserver {

    public static void main(String[] args) {
        CentroNotificaciones centro = new CentroNotificaciones();

        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Luis");
        Usuario u3 = new Usuario("Maria");

        centro.suscribir(u1);
        centro.suscribir(u2);

        centro.enviarNotificacion("Nueva oferta del 50% en productos.");

        centro.desuscribir(u2);
        centro.suscribir(u3);

        centro.enviarNotificacion("Nuevo producto disponible en la tienda.");
    }
}
