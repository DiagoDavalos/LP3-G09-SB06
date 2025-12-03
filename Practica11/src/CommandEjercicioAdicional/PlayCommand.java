package CommandEjercicioAdicional;

public class PlayCommand implements Command {
    private AudioSystem audio;

    public PlayCommand(AudioSystem audio) { this.audio = audio; }

    @Override
    public void execute() { audio.play(); }
}
