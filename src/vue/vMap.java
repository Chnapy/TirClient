/*
 * 
 * 
 * 
 */
package vue;

import controleur.General;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * vMap.java
 *
 */
public class vMap extends GridPane {

    private static final String prepath = "assets/tuiles/";
    private static final String[] images = {
	"tuile0.png"
    };
    private ArrayList<Meteor> meteors;

    public vMap(int[][] map) {
	meteors = new ArrayList<>();
	this.setHgap(0);
	this.setVgap(0);

	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map[0].length; j++) {
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
		this.add(im, i, j);
		im.setFitWidth(General.WINDOW_WIDTH / map.length);
		im.setPreserveRatio(true);
	    }
	}
    }
    
    public void stop() {
	meteors.stream().forEach((m) -> {
	    m.stop();
	});
    }

}