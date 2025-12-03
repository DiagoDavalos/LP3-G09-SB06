package CommandEjercicioAdicional;

public class PreviousCommand implements Command {
    private AudioSystem audio;

    public PreviousCommand(AudioSystem audio) { this.audio = audio; }

    @Override
    public void execute() { audio.previous(); }
}
