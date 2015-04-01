/*
 * 
 * 
 * 
 */
package controleur;

import static controleur.General.WINDOW_HEIGHT;
import static controleur.General.WINDOW_WIDTH;
import javafx.scene.input.KeyEvent;
import modele.mConnexion;
import modele.mJeu;
import vue.vJeu;

/**
 * cLancement.java
 *
 */
public class cLancement extends Controleur {

    private vJeu vue;

    @Override
    public void lancer() {
	mJeu.demandeMap();
	vue = new vJeu(this, mJeu.getMap().getTab(), WINDOW_WIDTH, WINDOW_HEIGHT);
	vue.show();
	vue.getStage().setOnCloseRequest((event) -> {
	    mConnexion.deconnexion();
	    vue.stop();
	});
	vue.getStage().getScene().setOnKeyPressed((KeyEvent event) -> {
	    vue.actionJoueur(event.getText());
	});
    }

}
