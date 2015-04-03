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

    public static boolean canMove(boolean horizontal, boolean gauche) {

	if (horizontal) {
	    if (gauche) {
		if (position.x == 0) {
		    return false;
		}
	    } else {
		if (position.x == Map.MAP_WIDTH - 1) {
		    return false;
		}
	    }
	} else {
	    if (gauche) {
		if (position.y == 0) {
		    return false;
		}
	    } else {
		if (position.y == Map.MAP_HEIGHT - 1) {
		    return false;
		}
	    }
	}
	return true;

    }

    public static boolean move(boolean horizontal, boolean gauche) {

	if (horizontal) {
	    if (gauche) {
		position.x--;
	    } else {
		position.x++;
	    }
	} else {
	    if (gauche) {
		position.y--;
	    } else {
		position.y++;
	    }
	}
	System.out.println(position.x + " " + position.y);
	return true;
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
