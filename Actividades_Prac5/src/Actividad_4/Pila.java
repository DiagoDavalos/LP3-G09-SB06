package Actividad_4;
import Actividad_2.ExcepcionPilaLlena;
import Actividad_2.ExcepcionPilaVacia;

public class Pila<E> {
    private final int tamanio;     
    private int superior;          
    private E[] elementos;        
    public Pila() {
        this(10);
    }
    @SuppressWarnings("unchecked")
    public Pila(int tamanio) {
        this.tamanio = tamanio > 0 ? tamanio : 10;
        this.superior = -1;
        this.elementos = (E[]) new Object[this.tamanio];
    }

    public void push(E valor) {
        if (superior == tamanio - 1) {
            throw new ExcepcionPilaLlena("La pila está llena. No se puede insertar: " + valor);
        }
        elementos[++superior] = valor;
    }

    public E pop() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("La pila está vacía. No se puede extraer.");
        }
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return superior + 1;
    }

    public boolean isEmpty() {
        return superior == -1;
    }

    public boolean esIgual(Pila<E> otraPila) {
        if (this.size() != otraPila.size()) {
            return false;
        }
        for (int i = 0; i <= this.superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        return true; 
    }

}