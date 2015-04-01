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

    private int[][] tabTuiles;

    public Map(final int[][] tab) {
	tabTuiles = tab;
    }

    public int getTuile(int x, int y) {
	return tabTuiles[x][y];
    }

    public boolean isLibre(int x, int y) {
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
		if (tabTuiles[i][j] == Joueur.ID) {
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
