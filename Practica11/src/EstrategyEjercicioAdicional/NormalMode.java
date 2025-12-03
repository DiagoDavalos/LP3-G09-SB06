package EstrategyEjercicioAdicional;

public class NormalMode implements PlaybackMode {
    @Override
    public void play(String[] playlist) {
        System.out.println("Reproduciendo en modo NORMAL:");
        for (String song : playlist) {
            System.out.println("play" + song);
        }
    }
    @Override
    public String getName() 
    { 
    	return "Normal"; 
    }
}
