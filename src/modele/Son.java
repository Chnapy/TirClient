/*
 * 
 * 
 * 
 */
package modele;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Son.java
 *
 */
public class Son {

    private static final String prepathM = "/assets/musics/";
    private static final String[] musics = {
	"level1.mp3",
	"level2.mp3",
	"level3.mp3",
	"level4.mp3",
	"level5.mp3",
	"boss.mp3"
    };
    private static final String prepathS = "/assets/sounds/";
    private static final String[] sons = {
	"SHOOT003.mp3",
	"SHOOT007.mp3",
	"SHOOT008.mp3",
	"sws.wav"
    };
    private static Media mediaM;
    private static MediaPlayer mediaPlayerM;
    private static Media mediaS;
    private static MediaPlayer mediaPlayerS;

    public static void jouerSon(int indexTab, double rate) {
	mediaS = new Media(Son.class.getResource(prepathS + sons[indexTab]).toString());
	mediaPlayerS = new MediaPlayer(mediaS);
	mediaPlayerS.setRate(rate);
	mediaPlayerS.play();
    }

    public static void jouerSon(int indexTab) {
	mediaS = new Media(Son.class.getResource(prepathS + sons[indexTab]).toString());
	mediaPlayerS = new MediaPlayer(mediaS);
	mediaPlayerS.play();
    }

    public static void jouerMusic(int indexTab) {
	mediaM = new Media(Son.class.getResource(prepathM + musics[indexTab]).toString());
	mediaPlayerM = new MediaPlayer(mediaM);
	mediaPlayerM.setCycleCount(MediaPlayer.INDEFINITE);
	mediaPlayerM.setVolume(0.8);
	mediaPlayerM.play();
    }

    public static void stop() {
	if (mediaPlayerS != null) {
	    mediaPlayerS.stop();
	}
	if (mediaPlayerM != null) {
	    mediaPlayerM.stop();
	}
	System.err.println("Sons et musiques stoppées");
    }
}
