package Ejercicio3;


public class BajarVolumenCommand implements Command {

    private TV tv;

    public BajarVolumenCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.bajarVolumen();
    }
}
