/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import javafx.scene.Group;
import modele.mConnexion;

/**
 * HUD.java
 *
 */
public class HUD extends Group {

    private final vJeu vue;

    public final Stats stats;
    public final Chat chat;
    public final ListJoueurs listJoueurs;
    public final Options options;
    public final Temps temps;

    public HUD(vJeu vu) {
	vue = vu;
	stats = new Stats();
	chat = new Chat();
	listJoueurs = new ListJoueurs();
	options = new Options(this);
	temps = new Temps();
	placement();
	getChildren().addAll(stats, chat, listJoueurs, options, temps);
    }

    private void placement() {
	stats.setLayoutX(5);
	stats.setLayoutY(5);

	options.setLayoutX(General.getLastX(options) - 5);
	options.setLayoutY(5);

	chat.setLayoutX(5);
	chat.setLayoutY(General.getLastY(chat));

	listJoueurs.setLayoutX(General.getLastX(listJoueurs));
	listJoueurs.setLayoutY(General.getLastY(listJoueurs));

	temps.setLayoutX(General.getMidX(temps));
	temps.setLayoutY(5);

    }

    public void deconnexion() {
	mConnexion.deconnexion();
	this.vue.close();
	this.vue.stop();
    }

    public Stats getStats() {
	return stats;
    }

}
