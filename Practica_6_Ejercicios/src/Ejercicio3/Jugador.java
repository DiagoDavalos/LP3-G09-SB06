package Ejercicio3;

public class Jugador {
    private String nombre;
    private int nivel;
    private int salud;
    private int dano;

    public Jugador(String nombre, int nivel, int salud, int dano) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSalud() {
        return salud;
    }

    public int getDano() {
        return dano;
    }

    public void recibirDano(int cantidad) {
        salud -= cantidad;
        if (salud < 0) salud = 0;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    @Override
    public String toString() {
        return nombre + " (Nivel " + nivel + ") - Salud: " + salud + " - Daño: " + dano;
    }
}
