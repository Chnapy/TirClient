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
 * vJoueur.java
 *
 */
public class vJoueur extends ImageView {

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
    public int move;

    public vJoueur(final int id) {
	super(prepathP + joueurs[id % joueurs.length]);
	ID = id;
	transition = new TranslateTransition(new Duration(temps), this);
    }

    public void toTop() {
	this.setRotate(0);
	transition.setByY(-vJeu.modHeight);
	transition.play();
    }

    public void toBottom() {
	this.setRotate(180);
	transition.setByY(vJeu.modHeight);
	transition.play();
    }

    public void toLeft() {
	this.setRotate(270);
	transition.setByX(-vJeu.modWidth);
	transition.play();
    }

    public void toRight() {
	this.setRotate(90);
	transition.setByX(vJeu.modWidth);
	transition.play();
    }

    public TranslateTransition getTransition() {
	return transition;
    }

}
