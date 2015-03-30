/*
 * 
 * 
 * 
 */
package vue;

import controleur.Controleur;
import java.util.Observable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * vJeu.java
 * 
 */
public class vJeu extends Vue {
    
    private HUD hud;
    private VBox vb;

    public vJeu(Controleur controleur, double width, double height) {
	super(controleur, new VBox(), width, height);
	init();
	scene.getStylesheets().add("style/style.css");
	hud = new HUD(this);
	add(hud);
    }

    private void init() {
	vb = (VBox) scene.getRoot();
    }

    @Override
    public void update(Observable o, Object arg) {
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

}
