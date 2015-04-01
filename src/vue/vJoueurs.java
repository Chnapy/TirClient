/*
 * 
 * 
 * 
 */
package vue;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * vJoueurs.java
 *
 */
public class vJoueurs extends Pane {

    public vJoueurs(int[][] map) {

	applyMap(map);
    }

    private void applyMap(int[][] map) {

	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map[0].length; j++) {
		if (map[i][j] >= 2) {
		    vJoueur joueur = new vJoueur(map[i][j]);
		    this.getChildren().add(joueur);
		    joueur.setLayoutX(i * vJeu.modWidth);
		    joueur.setLayoutY(j * vJeu.modHeight);
		    joueur.setFitWidth(vJeu.modWidth);
		    joueur.setPreserveRatio(true);
		}
	    }
	}
    }

    public void move(int id, boolean horizontal, boolean gauche) {
	vJoueur j = null;
	for (Node joueur : this.getChildren()) {
	    j = (vJoueur) joueur;
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

}
