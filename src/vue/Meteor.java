/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import modele.Map;

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
	this.setFitWidth(General.WINDOW_WIDTH / Map.MAP_WIDTH);
	this.setPreserveRatio(true);
	rotationAnimation = new RotateTransition(new Duration(10000), this);
	rotationAnimation.setByAngle(360f);
	rotationAnimation.setCycleCount(RotateTransition.INDEFINITE);
	rotationAnimation.play();

    }

    public void stop() {
	rotationAnimation.stop();
    }

}
