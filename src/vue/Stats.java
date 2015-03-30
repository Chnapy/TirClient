/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Stats.java
 *
 */
public class Stats extends VBox {

    private static final Image vieImage = new Image("/assets/hud/stats/coeur.png");
    private static final Image puissanceImage = new Image("/assets/hud/stats/puissance.png");
    private static final Image munitionImage = new Image("/assets/hud/stats/munition.png");
    
    private static final double SPACING = 2;

    private HBox vies;
    private HBox puissances;
    private HBox munitions;

    public Stats() {
	vies = new HBox();
	puissances = new HBox();
	munitions = new HBox();
	getChildren().addAll(vies, puissances, munitions);
	
	vies.setSpacing(SPACING);
	puissances.setSpacing(SPACING);
	munitions.setSpacing(SPACING);
	
	addVies(10);
	addPuissances(10);
	addMunitions(10);
    }

    private ImageView getImage(Image image) {
	ImageView stat = new ImageView(image);
	stat.setFitWidth(32 * General.RATIO_X);
	stat.setPreserveRatio(true);
	stat.setSmooth(true);
	return stat;
    }

    public void addVies(int n) {
	for (int i = 0; i < n; i++) {
	    ImageView vie = new ImageView(vieImage);
	    vies.getChildren().add(getImage(vieImage));
	}
    }

    public void delVies(int n) {
	for (int i = 0; i < n; i++) {
	    vies.getChildren().remove(vies.getChildren().size() - 1);
	}
    }

    public void addPuissances(int n) {
	for (int i = 0; i < n; i++) {
	    puissances.getChildren().add(getImage(puissanceImage));
	}
    }

    public void delPuissances(int n) {
	for (int i = 0; i < n; i++) {
	    puissances.getChildren().remove(puissances.getChildren().size() - 1);
	}
    }

    public void addMunitions(int n) {
	for (int i = 0; i < n; i++) {
	    munitions.getChildren().add(getImage(munitionImage));
	}
    }

    public void delMunitions(int n) {
	for (int i = 0; i < n; i++) {
	    munitions.getChildren().remove(munitions.getChildren().size() - 1);
	}
    }

}
