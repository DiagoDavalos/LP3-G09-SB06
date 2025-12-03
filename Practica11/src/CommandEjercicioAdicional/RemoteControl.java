package CommandEjercicioAdicional;
//invoker
public class RemoteControl {
    private Command button;

    public void setCommand(Command c) { button = c; }
    public void pressButton() { button.execute(); }
}
