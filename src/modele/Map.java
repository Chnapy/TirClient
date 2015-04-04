/*
 * 
 * 
 * 
 */
package modele;

import java.awt.Point;

/**
 * Map.java
 *
 */
public class Map {

    public static int MAP_WIDTH;
    public static int MAP_HEIGHT;

    private final int[][] tabTuiles;

    public Map(final int[][] tab) {
	tabTuiles = tab;
	MAP_WIDTH = tab.length;
	MAP_HEIGHT = tab[0].length;
    }

    public int getTuile(int x, int y) {
	try {
	    return tabTuiles[x][y];
	} catch (ArrayIndexOutOfBoundsException e) {
	    return -1;
	}
    }
    
    public void setTuile(int x, int y, int valeur) {
	tabTuiles[x][y] = valeur;
    }

    public boolean isLibre(int x, int y) {
	if(getTuile(x, y) != 0)
	    System.out.println("CASE : " + getTuile(x, y));
	return getTuile(x, y) == 0;
    }

    public boolean isObstacle(int x, int y) {
	return getTuile(x, y) == 1;
    }

    public boolean isJoueur(int x, int y) {
	return getTuile(x, y) > 1;
    }

    public Point getPosJoueur() {
	for (int i = 0; i < tabTuiles.length; i++) {
	    for (int j = 0; j < tabTuiles[0].length; j++) {
		if (tabTuiles[i][j] - 2 == Joueur.ID) {
		    return new Point(i, j);
		}
	    }
	}
	return null;
    }

    @Override
    public String toString() {
	String ret = "Map {";
	for (int[] x : tabTuiles) {
	    ret += "\n\t";
	    for (int y : x) {
		ret += y;
	    }
	}
	return ret + "\n}";
    }

    public int[][] getTab() {
	return tabTuiles;
    }

}
