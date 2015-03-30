/*
 * 
 * 
 * 
 */
package vue;

import javafx.scene.control.Label;

/**
 * Temps.java
 * 
 */
public class Temps extends Label {
    
    public Temps() {
	super("0:00");
    }
    
    public void setTemps(int minutes, int secondes) {
	setText(minutes + ":" + secondes);
    }
    
}
