/*
 * 
 * 
 * 
 */
package vue;

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

    private void applyMap(int[][] map) {

	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map[0].length; j++) {
		if (map[i][j] >= 2) {
		    vJoueur jr = new vJoueur(map[i][j]);
		    this.getChildren().add(jr);
		    jr.setLayoutX(i * vJeu.modWidth);
		    jr.setLayoutY(j * vJeu.modHeight);
		    jr.setFitWidth(vJeu.modWidth);
		    jr.setPreserveRatio(true);
		    if (joueur == null && map[i][j]-2 == Joueur.ID) {
			joueur = jr;
		    }
		}
	    }
	}
    }

    public void stop() {
	
    }

    public void move(int id, boolean horizontal, boolean gauche) {
	vJoueur j = null;
	for (Node jr : this.getChildren()) {
	    j = (vJoueur) jr;
	    if (j.ID == id) {
		break;
	    }
	}

	if (j != null) {
	    if (horizontal) {
		if (gauche) {
		    j.toLeft();
		} else {
		    j.toRight();
		}
	    } else {
		if (gauche) {
		    j.toTop();
		} else {
		    j.toBottom();
		}
	    }
	}
    }

    public boolean moveJoueur(boolean horizontal, boolean gauche) {
	if (horizontal) {
	    if (gauche) {
		return joueur.toLeft();
	    } else {
		return joueur.toRight();
	    }
	} else {
	    if (gauche) {
		return joueur.toTop();
	    } else {
		return joueur.toBottom();
	    }
	}
    }

    public vJoueur getJoueur() {
	return joueur;
    }

}
