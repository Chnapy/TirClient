/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Chat.java
 * 
 */
public class Chat extends VBox {
    
    public Chat() {
	this.setWidth(200 * General.RATIO_X);
	this.setHeight(250 * General.RATIO_Y);
	this.setAlignment(Pos.CENTER);
    }
    
    /**
     *
     * @param text
     * @param classe (error, nc, mort, general, info)
     */
    public void add(String text, String classe) {
	Label lab = new Label(text);
	lab.getStyleClass().add(classe);
	this.getChildren().add(lab);
    }

}
