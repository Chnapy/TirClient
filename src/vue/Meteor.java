/*
 * 
 * 
 * 
 */
package vue;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;

/**
 * Meteor.java
 *
 */
public class Meteor extends ImageView implements Runnable {

    private static final String prepath = "assets/tuiles/meteor/";
    private static final String[] images = {
	"meteorBrown_big1.png",
	"meteorBrown_big2.png",
	"meteorBrown_big3.png",
	"meteorBrown_big4.png",
	"meteorGrey_big1.png",
	"meteorGrey_big2.png",
	"meteorGrey_big3.png",
	"meteorGrey_big4.png"
    };
    private Thread th;
    private boolean run;

    public Meteor() {
	super(prepath + images[(int) (Math.random() * images.length)]);
	th = new Thread(this);
	th.start();
    }
    
    public void stop() {
	run = false;
    }

    @Override
    public void run() {
	run = true;
	try {
	    while (run) {
		this.setRotate(this.getRotate() + 1);
		sleep(100);
	    }
	} catch (InterruptedException ex) {
	    Logger.getLogger(Meteor.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
