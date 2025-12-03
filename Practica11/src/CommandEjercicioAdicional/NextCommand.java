package CommandEjercicioAdicional;

public class NextCommand implements Command {
    private AudioSystem audio;

    public NextCommand(AudioSystem audio) { this.audio = audio; }

    @Override
    public void execute() { audio.next(); }
}
