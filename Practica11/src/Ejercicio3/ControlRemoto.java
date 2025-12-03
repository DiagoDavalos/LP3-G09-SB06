package Ejercicio3;


public class ControlRemoto {

    private Command comando;

    public void setCommand(Command comando) {
        this.comando = comando;
    }

    public void presionarBoton() {
        if (comando != null) comando.ejecutar();
    }
}
