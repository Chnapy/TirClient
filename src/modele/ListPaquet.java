/*
 * 
 * 
 * 
 */
package modele;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ListPaquet.java
 *
 */
public class ListPaquet extends ArrayList<Paquet> {

    public ListPaquet() {
    }

    /**
     *
     * @param commande
     * @return
     * @throws java.util.concurrent.TimeoutException
     */
    public Paquet waitPaquet(String commande) throws TimeoutException {
	Paquet ret;
	for (Iterator<Paquet> ite = this.iterator(); ite.hasNext();) {
	    ret = ite.next();
	    if (ret.getCommande().equals(commande)) {
		ite.remove();
		return ret;
	    }
	}
	try {
	    sleep(100);  //Permet d'eviter un StackOverflowException
	} catch (InterruptedException ex) {
	    Logger.getLogger(ListPaquet.class.getName()).log(Level.SEVERE, null, ex);
	}
	return waitPaquet(commande, 0);
    }

    private Paquet waitPaquet(String commande, int iterations) throws TimeoutException {
	System.out.print(".");
	Paquet ret;
	for (Iterator<Paquet> ite = this.iterator(); ite.hasNext();) {
	    ret = ite.next();
	    if (ret.getCommande().equals(commande)) {
		ite.remove();
		return ret;
	    }
	}
	if (iterations > 1000) {
	    throw new TimeoutException("Attente trop longue : " + commande);
	}
	try {
	    sleep(100);  //Permet d'eviter un StackOverflowException
	} catch (InterruptedException ex) {
	    Logger.getLogger(ListPaquet.class.getName()).log(Level.SEVERE, null, ex);
	}
	return waitPaquet(commande, iterations + 1);
    }

}
