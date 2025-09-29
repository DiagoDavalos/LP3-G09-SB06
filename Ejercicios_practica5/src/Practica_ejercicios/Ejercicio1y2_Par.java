package Practica_ejercicios;

public class Ejercicio1y2_Par<F, S> {
    private F primero;
    private S segundo;

    public Ejercicio1y2_Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }
 
    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    // Ejercicio 2: comparar dos pares
    public boolean esIgual(Ejercicio1y2_Par<F, S> otroPar) {
        return this.primero.equals(otroPar.primero) &&
               this.segundo.equals(otroPar.segundo);
    }
}
