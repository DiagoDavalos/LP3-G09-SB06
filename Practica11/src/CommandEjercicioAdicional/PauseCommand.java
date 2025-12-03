package CommandEjercicioAdicional;

public class PauseCommand implements Command {
    private AudioSystem audio;

    public PauseCommand(AudioSystem audio)
    {
    	this.audio = audio; 
    }

    @Override
    public void execute() 
    {
    	audio.pause(); 
    	}
}
