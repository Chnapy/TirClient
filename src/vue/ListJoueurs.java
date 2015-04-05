/*
 * 
 * 
 * 
 */
package vue;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * ListJoueurs.java
 * 
 */
public class ListJoueurs extends VBox {
    
    public ListJoueurs() {
	this.setWidth(100);
	this.setHeight(5);
	this.setAlignment(Pos.BOTTOM_RIGHT);
    }
    
    public void add(String pseudo, Image image) {
	Label lab = new Label(pseudo);
	lab.setAlignment(Pos.CENTER_RIGHT);
	lab.getStyleClass().add("labList");
	ImageView im = new ImageView(image);
	im.setFitWidth(25);
	im.setPreserveRatio(true);
	HBox hb = new HBox(im, lab);
	hb.setAlignment(Pos.BOTTOM_LEFT);
	hb.setMaxWidth(100);
	hb.setMaxHeight(30);
	hb.setMinHeight(30);
	getChildren().add(hb);
	setLayoutY(getLayoutY()-30);
    }

}
