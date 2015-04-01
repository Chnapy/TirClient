/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Options.java
 *
 */
public class Options extends HBox {

    private static final Image fermerImage = new Image("/assets/general/close.png");
    private static final Image deconnecterImage = new Image("/assets/hud/stats/disconnect.png");
    private static final double BUTTONWIDTH = 50 * General.RATIO_X;

    private static int maxwidth;

    public Options(HUD hud) {
	maxwidth = 0;
	getChildren().addAll(getButton(deconnecterImage), getButton(fermerImage));
	setWidth(maxwidth);

	((Button) getChildren().get(1)).setOnAction((event) -> {
	    hud.deconnexion();
	});
    }

    private Button getButton(Image image) {
	ImageView iv = new ImageView(image);
	iv.setFitWidth(20);
	iv.setPreserveRatio(true);
	Button but = new Button(null, iv);
	but.setMinWidth(BUTTONWIDTH);
	but.setMaxWidth(BUTTONWIDTH);
	maxwidth += BUTTONWIDTH;
	but.setId("option" + maxwidth / BUTTONWIDTH);

	return but;
    }

}
