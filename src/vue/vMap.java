/*
 * 
 * 
 * 
 */
package vue;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import modele.Map;

/**
 * vMap.java
 *
 */
public class vMap extends GridPane {

    private static final String lienBack = "assets/background/purple.png";
    private static final String prepath = "assets/tuiles/";
    private static final String[] images = {
	"tuile-1.png"
    };
    private ArrayList<Meteor> meteors;

    public vMap(int[][] map) {
	meteors = new ArrayList<>();
	this.setHgap(0);
	this.setVgap(0);
	this.setBackground(new Background(
		new BackgroundImage(new Image(lienBack), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)
	));

	for (int i = 0; i < Map.MAP_WIDTH; i++) {
	    for (int j = 0; j < Map.MAP_HEIGHT; j++) {
		ImageView im;
		switch (map[i][j]) {
		    case -1:
			im = new ImageView(prepath + images[0]);
			break;
		    case 1:
			im = new Meteor();
			meteors.add((Meteor) im);
			break;
		    default:
			im = new ImageView();
			break;
		}
		im.setFitWidth(vJeu.modWidth);
		im.setFitHeight(vJeu.modWidth);
		this.add(im, i, j);
		GridPane.setHalignment(im, HPos.CENTER);
		GridPane.setValignment(im, VPos.CENTER);
	    }
	}
    }
    
    public void stop() {
	meteors.stream().forEach((m) -> {
	    m.stop();
	});
    }

}
