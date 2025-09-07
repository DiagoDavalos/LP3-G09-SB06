package Actividad;

public class RecepcionistaIm implements Recepcionista {
    private String nombre;

    public RecepcionistaIm(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void atenderCliente() {
        System.out.println("El recepcionista " + nombre + " está atendiendo al cliente.");
    }
}
