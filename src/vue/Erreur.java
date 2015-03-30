/*
 * 
 * 
 * 
 */
package vue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Erreur.java
 *
 */
public class Erreur {
    
    private final static Stage stage = new Stage();
    private final static TextArea messArea = new TextArea();
    private final static Button bouton = new Button();
    private final static Group groupe = new Group(messArea, bouton);
    private final static Scene scene = new Scene(groupe);
    
    private static void init() {
	if (stage.getScene() == scene) {
	    return;
	}
	stage.setScene(scene);
	stage.setMinWidth(450);
	stage.setMaxWidth(450);
	stage.setMinHeight(160);
	stage.setMaxHeight(160);
	stage.setAlwaysOnTop(true);
	stage.setResizable(false);
	scene.getStylesheets().add("style/style.css");
	scene.setFill(Color.web("rgb(128,128,128);"));
	
	messArea.setMaxWidth(444);
	messArea.setMinWidth(444);
	messArea.setMinHeight(90);
	messArea.setMaxHeight(90);
	messArea.setFont(Font.font("sans-serif", 15));
	messArea.setEditable(false);
	
	bouton.setLayoutX(175);
	bouton.setLayoutY(100);
	bouton.setMinWidth(100);
	bouton.setDefaultButton(true);
	bouton.setCancelButton(true);
	bouton.setText("OK");
	bouton.setOnAction((event) -> {
	    stage.close();
	});
    }
    
    public static void afficher(String title, String message) {
	init();
	messArea.setText(message);
	stage.setTitle(title);
	stage.show();
	System.err.println(message);
    }
    
    public static void afficher(String message) {
	afficher("ERREUR", message);
    }
    
}
