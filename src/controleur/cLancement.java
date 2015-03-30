/*
 * 
 * 
 * 
 */

package controleur;

import static controleur.General.WINDOW_HEIGHT;
import static controleur.General.WINDOW_WIDTH;
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
	vue = new vJeu(this, WINDOW_WIDTH, WINDOW_HEIGHT);
	vue.show();
	vue.getStage().setOnCloseRequest((event) -> {
	    mConnexion.deconnexion();
	});
    }

}
