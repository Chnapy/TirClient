/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import java.awt.Point;
import javafx.animation.TranslateTransition;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import modele.Joueur;
import modele.Map;

/**
 * vJoueur.java
 *
 */
public class vJoueur extends ImageView {

    public static final String prepathP = "assets/player/";
    public static final String[] joueurs = {
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
    private static final int temps = 300;
    private final TranslateTransition transition;
    public final Point position;
    public final String pseudo;

    public final int ID;

    public vJoueur(final int id, final String pseudo, int x, int y) {
	super(prepathP + joueurs[id % joueurs.length]);
	this.setFitWidth(General.WINDOW_WIDTH / Map.MAP_WIDTH);
	this.setPreserveRatio(true);
	ID = id;
	if (pseudo != null) {
	    this.pseudo = pseudo;
	} else {
	    this.pseudo = "J" + id;
	}
	transition = new TranslateTransition(new Duration(temps), this);
	transition.setOnFinished((event) -> {
	    transition.setByX(0);
	    transition.setByY(0);
	});
	position = new Point(x, y);
	setOnMouseEntered((event) -> {
	    setCursor(Cursor.HAND);
	});
	setOnMouseExited((event) -> {
	    setCursor(Cursor.DEFAULT);
	});
    }

    public void toTop() {
	position.y--;
	this.setRotate(0);
	transition.stop();
	transition.setByY(-vJeu.modHeight);
	transition.play();
    }

    public void toBottom() {
	position.y++;
	this.setRotate(180);
	transition.stop();
	transition.setByY(vJeu.modHeight);
	transition.play();
    }

    public void toLeft() {
	position.x--;
	this.setRotate(270);
	transition.stop();
	transition.setByX(-vJeu.modWidth);
	transition.play();
    }

    public void toRight() {
	position.x++;
	this.setRotate(90);
	transition.stop();
	transition.setByX(vJeu.modWidth);
	transition.play();
    }

    public TranslateTransition getTransition() {
	return transition;
    }

    public void reinitialiser() {
	System.out.println("MI " + Joueur.position.x + " " + Joueur.position.y);
	transition.stop();
	setX(0);
	setY(0);
	setTranslateX(Joueur.position.x * vJeu.modWidth);
	setTranslateY(Joueur.position.y * vJeu.modHeight);
	position.x = Joueur.position.x;
	position.y = Joueur.position.y;
    }

}
