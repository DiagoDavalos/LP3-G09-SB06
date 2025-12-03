package Ejercicio3;

public class SubirVolumenCommand implements Command {

    private TV tv;

    public SubirVolumenCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.subirVolumen();
    }
}
