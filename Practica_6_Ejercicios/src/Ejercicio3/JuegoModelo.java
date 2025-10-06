package Ejercicio3;

public class JuegoModelo {
    private Jugador jugador;
    private Enemigo enemigo;

    public void crearJugador(String nombre) {
        jugador = new Jugador(nombre, 1, 100, 20); 
    }

    public void crearEnemigo(String nombre) {
        enemigo = new Enemigo(nombre, 1, 80, 15);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void ataqueJugador() {
        enemigo.recibirDano(jugador.getDano());
    }

    public void ataqueEnemigo() {
        jugador.recibirDano(enemigo.getDano());
    }

    public boolean juegoTerminado() {
        return !jugador.estaVivo() || !enemigo.estaVivo();
    }

    public String obtenerGanador() {
        if (jugador.estaVivo() && !enemigo.estaVivo()) return "jugador ha ganado";
        else if (!jugador.estaVivo() && enemigo.estaVivo()) return "El enemigo ha ganado.";
        else return "Ambos han caído al mismo tiempo.";
    }
}

