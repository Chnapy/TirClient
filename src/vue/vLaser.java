/*
 * 
 * 
 * 
 */
package vue;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * vLaser.java
 *
 */
public class vLaser extends ImageView {

    private static final String prepathL = "assets/lasers/";
    private static final String[] lasers = {
	"laserBlue04.png",
	"laserGreen08.png",
	"laserBlue04.png", //TODO : Orange
	"laserRed04.png"
    };
    private static final int temps = 500;
    private final TranslateTransition transition;

    public vLaser(int id) {
	super(prepathL + lasers[id % lasers.length]);
	transition = new TranslateTransition(new Duration(temps), this);
    }

    public int[] lancer(double x, double y, double width, double height, double mx, double my) {
	double dx = x + width - mx;
	double dy = y + height - my;
	double tan = dy / dx;
	double angle = Math.atan(tan) * 180 / Math.PI + 90;
	if (dx < 0) {
	    angle += 180;
	} else if (dy < 0) {
	    angle += 360;
	}
	angle += 180;
	angle %= 360;
	transition.setFromX(x + width);
	transition.setFromY(y + height);
	System.out.println(angle);
	if (angle < 45 || angle > 315) {
	    tire(0, x + width, -2000);
	    return new int[]{0, -1};
	} else if (angle > 45 && angle < 135) {
	    tire(90, 2000, y + height);
	    return new int[]{1, 0};
	} else if (angle > 135 && angle < 225) {
	    tire(180, x + width, 2000);
	    return new int[]{0, 1};
	} else {
	    tire(270, -2000, y + height);
	    return new int[]{-1, 0};
	}
    }

    private void tire(int rotate, double x, double y) {

	this.setRotate(rotate);
	transition.setToX(x);
	transition.setToY(y);
	transition.play();
    }
    
    public void lancerAutrement(double x, double y, double width, double height, double mx, double my) {
	
	transition.setFromX(x + width);
	transition.setFromY(y + height);
	
	if (mx == 1) {
	    tire(90, 2000, y + height);
	} else if (mx == -1) {
	    tire(270, -2000, y + height);
	} else if (my == 1) {
	    tire(180, x + width, 2000);
	} else if (my == -1) {
	    tire(0, x + width, -2000);
	}
    }

    public TranslateTransition getTransition() {
	return transition;
    }

}
