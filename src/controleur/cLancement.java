/*
 * 
 * 
 * 
 */
package controleur;

import static controleur.General.WINDOW_HEIGHT;
import static controleur.General.WINDOW_WIDTH;
import javafx.scene.input.KeyEvent;
import modele.Joueur;
import modele.mConnexion;
import modele.mJeu;
import vue.vJeu;
import vue.vJoueurs;

/**
 * cLancement.java
 *
 */
public class cLancement extends Controleur {

    private vJeu vue;
    private vJoueurs joueurs;

    @Override
    public void lancer() {
	mJeu.demandeMap();
	vue = new vJeu(this, mJeu.getMap().getTab(), WINDOW_WIDTH, WINDOW_HEIGHT);
	joueurs = vue.getJoueurs();
	vue.show();
	vue.getStage().setOnCloseRequest((event) -> {
	    mConnexion.deconnexion();
	    vue.stop();
	});
	vue.getStage().getScene().setOnKeyPressed((KeyEvent event) -> {
	    actionJoueur(event.getText());
	});
    }

    public void actionJoueur(String keytext) {
	boolean horizontal;
	boolean gauche;
	switch (keytext.toLowerCase()) {
	    case "q":
		horizontal = true;
		gauche = true;
		break;
	    case "d":
		horizontal = true;
		gauche = false;
		break;
	    case "z":
		horizontal = false;
		gauche = true;
		break;
	    case "s":
		horizontal = false;
		gauche = false;
		break;
	    default:
		return;
	}
	if (Joueur.canMove(horizontal, gauche) && joueurs.moveJoueur(horizontal, gauche))  {
	    mConnexion.envoiPos(horizontal, gauche);
	    Joueur.move(horizontal, gauche);
	}
    }

}
