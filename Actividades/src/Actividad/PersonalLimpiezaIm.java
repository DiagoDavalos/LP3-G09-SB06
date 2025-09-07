package Actividad;

public class PersonalLimpiezaIm implements PersonalLimpieza {
    private String nombre;

    public PersonalLimpiezaIm(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void limpiarHabitacion() {
        System.out.println("El personal de limpieza " + nombre + " está limpiando una habitación.");
    }
}
