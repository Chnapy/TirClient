/*
 * 
 * 
 * 
 */
package vue;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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

    public vJoueur getJoueur(int id) {
	vJoueur j = null;
	for (Node jr : this.getChildren()) {
	    j = (vJoueur) jr;
	    if (j.ID == id) {
		return j;
	    }
	}
	return null;
    }

    public void move(int id, int x, int y) {
	vJoueur j = getJoueur(id);
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

    public int[] tirer(double mx, double my) {
	vLaser laser = new vLaser(joueur.ID);
	this.getChildren().add(laser);
	laser.getTransition().setOnFinished((ActionEvent event) -> {
	    this.getChildren().remove(laser);
	});
	int[] ret = laser.lancer(joueur.getX() + joueur.getTranslateX(), joueur.getY() + joueur.getTranslateY(), joueur.getFitWidth() / 2, joueur.getFitHeight() / 2, mx, my);
	joueur.setRotate(laser.getRotate());
	return ret;
    }

    public void tirer(int id, double mx, double my) {
	vJoueur jr = getJoueur(id);
	vLaser laser = new vLaser(id);
	this.getChildren().add(laser);
	laser.getTransition().setOnFinished((ActionEvent event) -> {
	    this.getChildren().remove(laser);
	});
	laser.lancerAutrement(jr.getX() + jr.getTranslateX(), jr.getY() + jr.getTranslateY(), jr.getFitWidth() / 2, jr.getFitHeight() / 2, mx, my);
	jr.setRotate(laser.getRotate());
    }

}
