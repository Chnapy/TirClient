/*
 * 
 * 
 * 
 */
package controleur;

import static controleur.General.WINDOW_HEIGHT;
import static controleur.General.WINDOW_WIDTH;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.input.KeyEvent;
import modele.InputReader;
import modele.Joueur;
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
    private boolean canMoveTranslate;
    private boolean run;

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
		if (canMove && canMoveTranslate) {
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
	    canMoveTranslate = true;
	});
	run = true;

	new Thread(() -> {
	    while (run) {
		Paquet paq = InputReader.listPaquet.waitPaquet("nc");
		System.out.println("Nouveau joueur connecté ! " + paq.getFirstMessage());
		Platform.runLater(() -> {
		    joueurs.add(Integer.parseInt(paq.getFirstMessage()), Integer.parseInt(paq.getMessage(1)), Integer.parseInt(paq.getMessage(2)));
		});
	    }
	}).start();

	new Thread(() -> {
	    while (run) {
		Paquet paq = InputReader.listPaquet.waitPaquet("move2");
		System.out.println("move2 : x" + Integer.parseInt(paq.getMessage(1)) + " y" + Integer.parseInt(paq.getMessage(2)));
		Platform.runLater(() -> {
		    joueurs.move(Integer.parseInt(paq.getFirstMessage()), Integer.parseInt(paq.getMessage(1)), Integer.parseInt(paq.getMessage(2)));
		});
	    }
	}).start();

	canMove = true;
	canMoveTranslate = true;
    }

    public void actionJoueur(final String keytext) throws Exception {
	canMove = false;
	canMoveTranslate = false;
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
	    Paquet paq = InputReader.listPaquet.waitPaquet("move");
	    if (canMove(paq, x, y)) {
		System.out.println("Move recu !");
		mJeu.getMap().setTuile(Joueur.position.x, Joueur.position.y, 0);
		mJeu.getMap().setTuile(x, y, Joueur.ID + 2);
		Joueur.move(x, y);
	    } else {
		System.out.println("Mouvement impossible : " + x + " " + y);
		System.out.println(Joueur.position.x + " " + Joueur.position.y);
		joueurs.moveJoueur(Joueur.position.x, Joueur.position.y);
		canMoveTranslate = true;
	    }
	} else {
	    canMoveTranslate = true;
	}
	canMove = true;
    }

    private boolean canMove(Paquet paquet, int x, int y) {
	return Integer.parseInt(paquet.getFirstMessage()) == x && Integer.parseInt(paquet.getMessage(1)) == y;
    }

    public static boolean joueurCanMove(int x, int y) {
	return mJeu.getMap().isLibre(x, y);
    }

}
