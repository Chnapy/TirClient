/*
 * 
 * 
 * 
 */
package vue;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 * Temps.java
 *
 */
public class Temps extends Label {

    private int sec;
    private boolean run;

    public Temps() {
	super("00:00");
	this.setId("temps");
	sec = 0;
	run = true;
	new Thread(() -> {
	    try {
		while (run) {
		    sleep(1000);
		    sec++;
		    Platform.runLater(() -> {
			setTemps(sec / 60, sec % 60);
		    });
		}
	    } catch (InterruptedException ex) {
		Logger.getLogger(Temps.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();
    }

    public void setTemps(int minutes, int secondes) {
	String s;
	String min;
	if (secondes < 10) {
	    s = "0" + secondes;
	} else {
	    s = "" + secondes;
	}
	if (minutes < 10) {
	    min = "0" + minutes;
	} else {
	    min = "" + minutes;
	}
	setText(min + ":" + s);
    }

    public void stop() {
	run = false;
    }

}
