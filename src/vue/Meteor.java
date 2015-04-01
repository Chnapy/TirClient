/*
 * 
 * 
 * 
 */
package vue;

import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Meteor.java
 *
 */
public class Meteor extends ImageView {

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
    private final RotateTransition rotationAnimation;

    public Meteor() {
	super(prepath + images[(int) (Math.random() * images.length)]);
	rotationAnimation = new RotateTransition(new Duration(10000), this);
	rotationAnimation.setByAngle(360f);
        rotationAnimation.setCycleCount(10);
	rotationAnimation.play();
	
    }
    
    public void stop() {
	rotationAnimation.stop();
    }

}
