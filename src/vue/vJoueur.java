/*
 * 
 * 
 * 
 */
package vue;

import static java.lang.Thread.sleep;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * vJoueur.java
 *
 */
public class vJoueur extends ImageView implements Runnable {

    private static final String prepathP = "assets/player/";
    private static final String prepathL = "assets/lasers/";
    private static final String[] joueurs = {
	"playerShip1_blue.png",
	"playerShip1_green.png",
	"playerShip1_orange.png",
	"playerShip1_red.png",
	"playerShip2_blue.png",
	"playerShip2_green.png",
	"playerShip2_orange.png",
	"playerShip2_red.png",
	"playerShip3_blue.png",
	"playerShip3_green.png",
	"playerShip3_orange.png",
	"playerShip3_red.png"
    };
    private static final String[] lasers = {
	"laserBlue04.png",
	"laserGreen04.png",
	"laserBlue04.png", //TODO : Orange
	"laserRed04.png"
    };
    private static final int temps = 500;
    private final TranslateTransition transition;

    public final int ID;
    public final Thread th;
    private boolean run;
    public int move;

    public vJoueur(int id) {
	super(prepathP + joueurs[id % joueurs.length]);
	ID = id;
	th = new Thread(this);
	transition = new TranslateTransition(new Duration(temps), this);
	th.start();
    }

    public void stop() {
	run = false;
    }

    public void toTop() {
	this.setRotate(0);
	transition.setFromY(getY());
	transition.setToY(getY() - (int) vJeu.modHeight);
	transition.play();
	//todo
    }

    public void toBottom() {
	this.setRotate(180);
	try {
	    for (int i = 0; i < (int) vJeu.modHeight; i++) {
		this.setLayoutY(getLayoutY() + 1);
		sleep(temps / (int) vJeu.modHeight);
	    }
	} catch (InterruptedException e) {

	}
    }

    public void toLeft() {
	this.setRotate(270);
	try {
	    for (int i = 0; i < (int) vJeu.modWidth; i++) {
		this.setLayoutX(getLayoutX() - 1);
		sleep(temps / (int) vJeu.modWidth);
	    }
	} catch (InterruptedException e) {

	}
    }

    public void toRight() {
	this.setRotate(90);
	try {
	    for (int i = 0; i < (int) vJeu.modWidth; i++) {
		this.setLayoutX(getLayoutX() + 1);
		sleep(temps / (int) vJeu.modWidth);
	    }
	} catch (InterruptedException e) {

	}
    }

    @Override
    public void run() {
	move = 0;
	run = true;
	while (run) {
	    switch (move) {
		case 1:
		    move = 0;
		    toLeft();
		    break;
		case 2:
		    move = 0;
		    toRight();
		    break;
		case 3:
		    move = 0;
		    toTop();
		    break;
		case 4:
		    move = 0;
		    toBottom();
		    break;
		default:
		    break;
	    }
	}
    }

}
