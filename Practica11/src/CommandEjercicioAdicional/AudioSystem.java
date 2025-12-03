package CommandEjercicioAdicional;

public class AudioSystem {
    private int volume = 50; // 0 - 100

    public void play() { System.out.println(" Reproduciendo canción..."); }
    public void pause() { System.out.println(" Canción pausada."); }
    public void next() { System.out.println(" Siguiente canción."); }
    public void previous() { System.out.println(" Canción anterior."); }

    public void volumeUp() {
        volume = Math.min(100, volume + 10);
        System.out.println(" Volumen: " + volume);
    }

    public void volumeDown() {
        volume = Math.max(0, volume - 10);
        System.out.println(" Volumen: " + volume);
    }
}
