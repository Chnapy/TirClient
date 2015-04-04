/*
 * 
 * 
 * 
 */
package vue;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import modele.Joueur;

/**
 * vJoueurs.java
 *
 */
public class vJoueurs extends Pane {

    private vJoueur joueur;

    public vJoueurs(int[][] map) {
	joueur = null;
	applyMap(map);
    }

    private void applyMap(final int[][] map) {

	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map[0].length; j++) {
		if (map[i][j] >= 2) {
		    vJoueur jr = add(map[i][j] - 2, i, j);
		    if (joueur == null && map[i][j] - 2 == Joueur.ID) {
			joueur = jr;
		    }
		}
	    }
	}
    }

    public void stop() {

    }

    public void move(int id, int x, int y) {
	vJoueur j = null;
	for (Node jr : this.getChildren()) {
	    j = (vJoueur) jr;
	    if (j.ID == id) {
		break;
	    }
	}
	System.out.println("POS: x" + j.position.x + " y" + j.position.y + " SOP: x" + x + " y" + y);
	if (j.position.x > x) {
	    j.toLeft();
	} else if (j.position.x < x) {
	    j.toRight();
	} else if (j.position.y > y) {
	    j.toTop();
	} else if (j.position.y < y) {
	    j.toBottom();
	}
    }

    public void moveJoueur(final int x, final int y) {
	if (Joueur.position.x == x && Joueur.position.y == y) {
	    joueur.reinitialiser();
	} else if (Joueur.position.x > x) {
	    joueur.toLeft();
	} else if (Joueur.position.x < x) {
	    joueur.toRight();
	} else if (Joueur.position.y > y) {
	    joueur.toTop();
	} else if (Joueur.position.y < y) {
	    joueur.toBottom();
	}
    }

    public vJoueur getJoueur() {
	return joueur;
    }

    public TranslateTransition getJTransition() {
	return joueur.getTransition();
    }

    public vJoueur add(int id, int x, int y) {
	vJoueur jr = new vJoueur(id, x, y);
	this.getChildren().add(jr);
	jr.setX(x * vJeu.modWidth);
	jr.setY(y * vJeu.modHeight);
	jr.setFitWidth(vJeu.modWidth);
	jr.setPreserveRatio(true);
	return jr;
    }

}
