/*
 * 
 * 
 * 
 */
package modele;

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

    @Override
    public String toString() {
	String ret = "Map {";
	for(int[] x : tabTuiles) {
	    ret += "\n\t";
	    for(int y : x) {
		ret += y;
	    }
	}
	return ret + "\n}";
    }

}
