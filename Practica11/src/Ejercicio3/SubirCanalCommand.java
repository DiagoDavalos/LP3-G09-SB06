package Ejercicio3;

public class SubirCanalCommand implements Command {

    private TV tv;

    public SubirCanalCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.subirCanal();
    }
}
