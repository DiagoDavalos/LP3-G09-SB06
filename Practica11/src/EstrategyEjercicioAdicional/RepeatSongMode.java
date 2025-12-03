package EstrategyEjercicioAdicional;

public class RepeatSongMode implements PlaybackMode {
    @Override
    public void play(String[] playlist) {
        System.out.println("Reproduciendo en modo REPETIR CANCIÓN:");
        System.out.println("Repeat " + playlist[0] + " (en bucle)");
    }
    @Override
    public String getName() 
    { 
    	return "Repetir Canción"; 
    	}
}
