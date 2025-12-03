package CommandEjercicioAdicional;

public class VolumeUpCommand implements Command {
    private AudioSystem audio;

    public VolumeUpCommand(AudioSystem audio) { this.audio = audio; }

    @Override
    public void execute() { audio.volumeUp(); }
}
