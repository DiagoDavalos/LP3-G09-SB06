package Actividad;

public class CocineroIm implements Cocinero {
    private String nombre;

    public CocineroIm(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void prepararComida() {
        System.out.println("El cocinero " + nombre + " está preparando comida.");
    }
}
