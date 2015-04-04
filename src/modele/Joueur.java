/*
 * 
 * 
 * 
 */
package modele;

import java.awt.Point;

/**
 * Joueur.java
 *
 */
public class Joueur {

    public static int ID = -1;
    public static String pseudo = null;
    public static int vie = 10;
    public static int munitions = 10;
    public static int puissance = 10;

    public static Point position = new Point();

    public static void move(int x, int y) {
	position.x = x;
	position.y = y;
    }

    /**
     *
     * @return
     */
    public static String tostring() {
	return "Joueur {"
		+ "\n\tID : " + ID
		+ "\n\tPseudo : " + pseudo
		+ "\n\tPosition : [" + position.x + ':' + position.y + ']'
		+ "\n}";
    }

}
