package EstrategyEjercicioAdicional;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class ShuffleMode implements PlaybackMode {
    @Override
    public void play(String[] playlist) {
        System.out.println("Reproduciendo en modo ALEATORIO:");
        List<String> songs = Arrays.asList(playlist);
        Collections.shuffle(songs);
        for (String song : songs) {
            System.out.println(" " + song);
        }
    }
    @Override
    public String getName() 
    {
    	return "Aleatorio";
    	}
}
