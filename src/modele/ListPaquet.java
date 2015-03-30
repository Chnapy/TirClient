/*
 * 
 * 
 * 
 */
package modele;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ListPaquet.java
 *
 */
public class ListPaquet extends ArrayList<Paquet> {

    public ListPaquet() {
	super();
    }

    /**
     *
     * @param commande
     * @return
     */
    public Paquet getPaquet(String commande) {
	for (Paquet paquet : this) {
	    if (paquet.getCommande().equals(commande)) {
		return paquet;
	    }
	}
	return null;
    }

    public Paquet waitPaquet(String commande) throws Exception {
	Paquet ret = getPaquet(commande);
	if (ret == null) {
	    try {
		sleep(20);  //Permet d'eviter un StackOverflowException
	    } catch (InterruptedException ex) {
		Logger.getLogger(ListPaquet.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    return waitPaquet(commande, 0);
	}
	return ret;
    }

    private Paquet waitPaquet(String commande, int iterations) throws Exception {
	Paquet ret = getPaquet(commande);
	if (ret == null) {
	    if (iterations > 1000) {
		throw new Exception("Attente trop longue : " + commande);
	    }
	    try {
		sleep(20);  //Permet d'eviter un StackOverflowException
	    } catch (InterruptedException ex) {
		Logger.getLogger(ListPaquet.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    return waitPaquet(commande, iterations + 1);
	}
	return ret;
    }

}
