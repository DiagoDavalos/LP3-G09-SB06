package Ejercicio3;

public class TV {

    private boolean encendida = false;
    private int volumen = 10;
    private int canal = 1;

    public void encenderApagar() {
        encendida = !encendida;
        System.out.println("TV " + (encendida ? "Encendida" : "Apagada"));
    }

    public void subirVolumen() {
        volumen++;
        System.out.println("Volumen: " + volumen);
    }

    public void bajarVolumen() {
        if (volumen > 0) volumen--;
        System.out.println("Volumen: " + volumen);
    }

    public void subirCanal() {
        canal++;
        System.out.println("Canal: " + canal);
    }

    public void bajarCanal() {
        if (canal > 1) canal--;
        System.out.println("Canal: " + canal);
    }
}
