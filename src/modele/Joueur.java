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

    public static Point position = new Point();

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
