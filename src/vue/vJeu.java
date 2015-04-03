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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import modele.Map;

/**
 * vJeu.java
 *
 */
public class vJeu extends Vue {

    private static final String lienBack = "assets/background/purple.png";
    public static double modWidth;
    public static double modHeight;

    private final vMap map;
    private final vJoueurs joueurs;
    private final HUD hud;
    private final Pane vb;

    public vJeu(Controleur controleur, int[][] tabMap, double width, double height) {
	super(controleur, new Pane(), width, height);
	modWidth = General.WINDOW_WIDTH / Map.MAP_WIDTH;
	modHeight = modWidth;
	vb = (Pane) scene.getRoot();
	vb.setBackground(new Background(
		new BackgroundImage(new Image(lienBack), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)
	));
	scene.getStylesheets().add("style/style.css");
	map = new vMap(tabMap);
	joueurs = new vJoueurs(tabMap);
	hud = new HUD(this);
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
	joueurs.stop();
	map.stop();
    }

    public vJoueurs getJoueurs() {
	return joueurs;
    }

}
