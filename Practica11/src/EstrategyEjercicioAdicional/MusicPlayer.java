package EstrategyEjercicioAdicional;

public class MusicPlayer {
    private PlaybackMode mode;

    public void setMode(PlaybackMode mode) {
        this.mode = mode;
    }

    public void playPlaylist(String[] playlist) {
        if (mode == null) {
            System.out.println("No hay modo seleccionado.");
            return;
        }
        System.out.println("\n*** Modo actual: " + mode.getName() + " ***");
        mode.play(playlist);
    }
}
