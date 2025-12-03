package Ejercicio3;


public class EncenderApagarCommand implements Command {

    private TV tv;

    public EncenderApagarCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.encenderApagar();
    }
}
