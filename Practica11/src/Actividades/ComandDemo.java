package Actividades;

import java.util.Stack;

//Command interface
interface Command {
 void execute();
 default void undo() { } // opcional
}

//Receiver
class Television {
 private boolean power = false;
 private int volume = 10;
 private int channel = 1;

 public void powerToggle() {
     power = !power;
     System.out.println("Televisor " + (power ? "encendido" : "apagado"));
 }
 public void volumeUp() { volume++; System.out.println("Volumen: " + volume); }
 public void volumeDown() { volume = Math.max(0, volume-1); System.out.println("Volumen: " + volume); }
 public void channelUp() { channel++; System.out.println("Canal: " + channel); }
 public void channelDown() { channel = Math.max(1, channel-1); System.out.println("Canal: " + channel); }
 public void setChannel(int ch) { channel = Math.max(1, ch); System.out.println("Canal: " + channel); }
}

//Concrete commands
class PowerCommand implements Command {
 private Television tv;
 public PowerCommand(Television tv) { this.tv = tv; }
 public void execute() { tv.powerToggle(); }
}

class VolumeUpCommand implements Command {
 private Television tv;
 public VolumeUpCommand(Television tv) { this.tv = tv; }
 public void execute() { tv.volumeUp(); }
}

class VolumeDownCommand implements Command {
 private Television tv;
 public VolumeDownCommand(Television tv) { this.tv = tv; }
 public void execute() { tv.volumeDown(); }
}

class ChannelUpCommand implements Command {
 private Television tv;
 public ChannelUpCommand(Television tv) { this.tv = tv; }
 public void execute() { tv.channelUp(); }
}

class SetChannelCommand implements Command {
 private Television tv;
 private int channel;
 public SetChannelCommand(Television tv, int ch) { this.tv = tv; this.channel = ch; }
 public void execute() { tv.setChannel(channel); }
}

//Invoker
class RemoteControl {
 private Command slot;
 private Stack<Command> history = new Stack<>();
 public void setCommand(Command c) { this.slot = c; }
 public void pressButton() {
     if (slot == null) return;
     slot.execute();
     history.push(slot);
 }
 public void pressUndo() {
     if (!history.isEmpty()) {
         Command last = history.pop();
         last.undo(); // aquí los comandos no implementan undo; se puede extender
         System.out.println("Undo (si aplica) ejecutado.");
     } else {
         System.out.println("Historial vacío.");
     }
 }
}

public class ComandDemo {
 public static void main(String[] args) {
     Television tv = new Television();
     RemoteControl remote = new RemoteControl();

     remote.setCommand(new PowerCommand(tv)); remote.pressButton();
     remote.setCommand(new VolumeUpCommand(tv)); remote.pressButton();
     remote.setCommand(new VolumeUpCommand(tv)); remote.pressButton();
     remote.setCommand(new ChannelUpCommand(tv)); remote.pressButton();
     remote.setCommand(new SetChannelCommand(tv, 5)); remote.pressButton();
     remote.pressUndo(); // muestra mecanismo, pero undo no implementado por comandos
 }
}
