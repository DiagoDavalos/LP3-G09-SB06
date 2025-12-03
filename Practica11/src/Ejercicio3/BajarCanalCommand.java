package Ejercicio3;

public class BajarCanalCommand implements Command {

    private TV tv;

    public BajarCanalCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.bajarCanal();
    }
}
