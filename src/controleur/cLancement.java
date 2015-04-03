/*
 * 
 * 
 * 
 */
package controleur;

import static controleur.General.WINDOW_HEIGHT;
import static controleur.General.WINDOW_WIDTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyEvent;
import modele.InputReader;
import modele.Joueur;
import modele.Map;
import modele.Paquet;
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
    private boolean canMove;

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
	    try {
		if (canMove) {
		    actionJoueur(event.getText());
		}
	    } catch (Exception ex) {
		Logger.getLogger(cLancement.class.getName()).log(Level.SEVERE, null, ex);
	    }
	});
	TranslateTransition transition = joueurs.getJTransition();
	transition.setOnFinished((event) -> {
	    transition.setByX(0);
	    transition.setByY(0);
//	    canMove = true;
	});
	canMove = true;
    }

    public void actionJoueur(final String keytext) throws Exception {
	canMove = false;
	int x = Joueur.position.x;
	int y = Joueur.position.y;
	switch (keytext.toLowerCase()) {
	    case "q":
		x--;
		break;
	    case "d":
		x++;
		break;
	    case "z":
		y--;
		break;
	    case "s":
		y++;
		break;
	    default:
		return;
	}
	if (cLancement.joueurCanMove(x, y)) {
	    joueurs.moveJoueur(x, y);
	    mConnexion.envoiPos(x, y);
	    System.out.println("Attente move...");
	    if (canMove(InputReader.listPaquet.waitPaquet("move"), x, y)) {
		System.out.println("Move recu !");
		Joueur.move(x, y);
	    } else {
		System.out.println("Mouvement impossible : " + x + " " + y);
		joueurs.moveJoueur(Joueur.position.x, Joueur.position.x);
	    }
	}
	canMove = true;
    }

    private boolean canMove(final Paquet paquet, final int x, final int y) {
	return Integer.parseInt(paquet.getFirstMessage()) == x && Integer.parseInt(paquet.getMessage(1)) == y;
    }

    public static boolean joueurCanMove(final int x, final int y) {
	return x >= 0 && x < Map.MAP_WIDTH
		&& y >= 0 && y < Map.MAP_HEIGHT
		&& (Math.abs(x - Joueur.position.x) + Math.abs(y - Joueur.position.y) == 1);
    }

}
