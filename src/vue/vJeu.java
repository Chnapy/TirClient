/*
 * 
 * 
 * 
 */
package vue;

import controleur.Controleur;
import controleur.General;
import java.util.Observable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import modele.Map;

/**
 * vJeu.java
 *
 */
public class vJeu extends Vue {

    public static double modWidth;
    public static double modHeight;

    private final vMap map;
    private final vJoueurs joueurs;
    public final HUD hud;
    private final Pane vb;

    public vJeu(Controleur controleur, int[][] tabMap, double width, double height) {
	super(controleur, new Pane(), width, height);
	stage.setTitle("Jeu de tir en réseaux - par R.HADDAD");
	modWidth = General.WINDOW_WIDTH / Map.MAP_WIDTH;
	modHeight = modWidth;
	vb = (Pane) scene.getRoot();
	scene.getStylesheets().add("style/style.css");
	map = new vMap(tabMap);
	hud = new HUD(this);
	joueurs = new vJoueurs(this, tabMap);
	add(map, joueurs, hud);
    }

    @Override
    public void update(Observable o, Object arg) {
	if ((int) arg == -1) {
	    stop();
	}
    }

    @Override
    public boolean found(Node node) {
	return vb.getChildren().contains(node);
    }

    @Override
    public void add(Node... node) {
	vb.getChildren().addAll(node);
    }

    @Override
    public void del(Node... node) {
	vb.getChildren().removeAll(node);
    }

    public void stop() {
	map.stop();
    }

    public vJoueurs getJoueurs() {
	return joueurs;
    }

    public HUD getHud() {
	return hud;
    }

}
