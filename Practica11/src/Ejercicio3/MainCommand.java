package Ejercicio3;


public class MainCommand {

    public static void main(String[] args) {

        TV tv = new TV();
        ControlRemoto control = new ControlRemoto();

        Command encender = new EncenderApagarCommand(tv);
        Command subirVol = new SubirVolumenCommand(tv);
        Command bajarVol = new BajarVolumenCommand(tv);
        Command subirCanal = new SubirCanalCommand(tv);
        Command bajarCanal = new BajarCanalCommand(tv);

        control.setCommand(encender); control.presionarBoton();
        control.setCommand(subirVol); control.presionarBoton();
        control.setCommand(bajarVol); control.presionarBoton();
        control.setCommand(subirCanal); control.presionarBoton();
        control.setCommand(bajarCanal); control.presionarBoton();
    }
}
