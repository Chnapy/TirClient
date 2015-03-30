/*
 * 
 * 
 * 
 */
package controleur;

import modele.mConnexion;
import vue.Erreur;
import vue.vConnexion;

/**
 * cMain.java
 *
 */
public class cMain extends Controleur {

    private vConnexion vue;

    @Override
    public void lancer() {
	this.vue = new vConnexion(this);
	this.vue.show();

	mConnexion.init();

	vue.getStage().setOnCloseRequest((event) -> {
	    mConnexion.deconnexion();
	});
    }

    public void connexion(String pseudo, String servIp, int servPort) {

	if (!verifInput(pseudo, servIp, servPort)) {
	    return;
	}

	vue.load(0);
	if (!mConnexion.connecter(servIp, servPort)) {
	    vue.deload();
	    return;
	}

	vue.load(1);

	if (!mConnexion.envoiPseudo(pseudo)) {
	    vue.deload();
	    return;
	}

	vue.load(2);
	if (!mConnexion.confirmPseudo(pseudo)) {
	    vue.deload();
	    return;
	}

	new cLancement().lancer();
	vue.getStage().close();
    }

    private boolean verifInput(String pseudo, String servIp, int servPort) {
	String erreurs = new String();

	if (pseudo.isEmpty() || pseudo.length() > 30) {
	    erreurs += "Entrez un pseudo valide (<30 caractères)\n";
	}

	if (servIp.length() < 8 || servIp.length() > 16) {
	    erreurs += "Entrez une IP valide\n";
	}

	if (servPort <= 0) {
	    erreurs += "Entrez un port valide\n";
	}

	if (!erreurs.isEmpty()) {
	    Erreur.afficher(erreurs);
	    return false;
	}

	return true;
    }

}
