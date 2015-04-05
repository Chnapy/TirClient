/*
 * 
 * 
 * 
 */
package controleur;

import javafx.scene.Node;
import javafx.stage.Screen;

/**
 * General.java
 *
 */
public class General {

    public static final double RESOLUTION_WIDTH = (int) Screen.getPrimary().getVisualBounds().getWidth();
    public static final double RESOLUTION_HEIGHT = (int) Screen.getPrimary().getVisualBounds().getHeight();

    public static final double RATIO_X = RESOLUTION_WIDTH / 1920; // On part sur une base de 1920 de largeur
    public static final double RATIO_Y = RESOLUTION_HEIGHT / 1040; // On part sur une base de 1040 de longueur (1080 - la barre des taches)

    public static final double WINDOW_WIDTH = 1422 * RATIO_X;
    public static final double WINDOW_HEIGHT = 800 * RATIO_Y;

    public static double getLastX(Node node) {
	double width = node.getBoundsInLocal().getWidth();
	if (width == 0) {
	    System.err.println("Width = 0 : " + node);
	}
	return WINDOW_WIDTH - width;
    }

    public static double getLastY(Node node) {
	double height = node.getBoundsInLocal().getHeight();
	if (height == 0) {
	    System.err.println("Height = 0 : " + node);
	}
	return WINDOW_HEIGHT - height;
    }

    public static double getMidX(Node node) {
	double width = node.getBoundsInLocal().getWidth();
	if (width == 0) {
	    System.err.println("Width = 0 : " + node);
	}
	return WINDOW_WIDTH / 2 - width / 2;
    }

}
