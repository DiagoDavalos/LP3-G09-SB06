package CommandEjercicioAdicional;

import java.util.Scanner;

import EstrategyEjercicioAdicional.PlaybackMode;
import EstrategyEjercicioAdicional.NormalMode;
import EstrategyEjercicioAdicional.RepeatSongMode;
import EstrategyEjercicioAdicional.ShuffleMode;
import EstrategyEjercicioAdicional.MusicPlayer;


public class MainMusicApp {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // Playlist
        String[] playlist = { "Song A", "Song B", "Song C", "Song D" };

        // Strategy objects
        MusicPlayer player = new MusicPlayer();

        // Command objects
        AudioSystem audio = new AudioSystem();
        RemoteControl remote = new RemoteControl();

        Command play = new PlayCommand(audio);
        Command pause = new PauseCommand(audio);
        Command next = new NextCommand(audio);
        Command prev = new PreviousCommand(audio);
        Command volUp = new VolumeUpCommand(audio);
        Command volDown = new VolumeDownCommand(audio);

        int opt;
        do {
            System.out.println("\n=== REPRODUCTOR DE MÚSICA ===");
            System.out.println("1. Reproducir Playlist");
            System.out.println("2. Seleccionar Modo de Reproducción");
            System.out.println("3. Controles (Play, Pause, Volumen, etc.)");
            System.out.println("0. Salir");
            System.out.print("Elige: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    player.playPlaylist(playlist);
                    break;

                case 2:
                    System.out.println("\nMODOS:");
                    System.out.println("1. Normal");
                    System.out.println("2. Repetir Canción");
                    System.out.println("3. Aleatorio");
                    System.out.print("Elige modo: ");
                    int m = sc.nextInt();

                    if (m == 1) player.setMode(new NormalMode());
                    if (m == 2) player.setMode(new RepeatSongMode());
                    if (m == 3) player.setMode(new ShuffleMode());

                    System.out.println("Modo cambiado.");
                    break;

                case 3:
                    System.out.println("\nCONTROLES:");
                    System.out.println("1. Play");
                    System.out.println("2. Pause");
                    System.out.println("3. Siguiente");
                    System.out.println("4. Anterior");
                    System.out.println("5. Volumen +");
                    System.out.println("6. Volumen -");
                    int c = sc.nextInt();

                    switch (c) {
                        case 1: remote.setCommand(play); break;
                        case 2: remote.setCommand(pause); break;
                        case 3: remote.setCommand(next); break;
                        case 4: remote.setCommand(prev); break;
                        case 5: remote.setCommand(volUp); break;
                        case 6: remote.setCommand(volDown); break;
                    }

                    remote.pressButton();
                    break;
            }

        } while (opt != 0);

        sc.close();
    }
}
