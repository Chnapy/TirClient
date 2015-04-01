/*
 * 
 * 
 * 
 */
package modele;

import vue.Erreur;

/**
 * mJeu.java
 *
 */
public class mJeu extends Modele {

    private static Map map;

    public static boolean demandeMap() {

	System.out.print("-Attente MAP...");
	Paquet paqMap;
	try {
	    paqMap = InputReader.listPaquet.waitPaquet("map");
	} catch (Exception e) {
	    Erreur.afficher("Attente de reception paquet trop long", "Attente du paquet 'map' trop long");
	    return false;
	}

	map = new Map(recupMap(paqMap));
	System.out.println("recu.");
	return recupPosition();
    }

    private static boolean recupPosition() {
	Joueur.position = map.getPosJoueur();
	return Joueur.position != null;
    }

    private static int[][] recupMap(Paquet paqMap) {

	String[] temp;
	String[] lignes = paqMap.getFirstMessage().split(" ");
	int[][] _map = new int[lignes.length][lignes[0].split("\\.").length];

	for (int i = 0; i < lignes.length; i++) {
	    temp = lignes[i].split("\\.");
	    for (int j = 0; j < temp.length; j++) {
		_map[i][j] = Integer.parseInt(temp[j]);
	    }
	}
	return _map;
    }

    public static Map getMap() {
	return map;
    }

}
