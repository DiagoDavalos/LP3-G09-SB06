package CommandEjercicioAdicional;

public class VolumeDownCommand implements Command {
    private AudioSystem audio;

    public VolumeDownCommand(AudioSystem audio) { this.audio = audio; }

    @Override
    public void execute() { audio.volumeDown(); }
}
