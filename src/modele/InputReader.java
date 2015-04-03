/*
 * 
 * 
 * 
 */
package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InputReader.java
 *
 */
public class InputReader implements Runnable {

    private final Thread thread;
    private final BufferedReader input;
    public static final ListPaquet listPaquet = new ListPaquet();
    private boolean run;

    public InputReader(BufferedReader in) {
	thread = new Thread(this);
	input = in;
    }

    @Override
    public void run() {
	run = true;
	String reception;
	try {
	    while (run) {
		reception = input.readLine();
		if (!reception.isEmpty()) {
		    System.out.println("R : " + reception);
		    listPaquet.add(new Paquet(reception));
		}
	    }
	} catch (IOException ex) {
	    if (run) {
		Logger.getLogger(mConnexion.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	System.err.println("InputReader stoppé.");
    }

    public void start() {
	thread.start();
    }

    public void stop() {
	run = false;
	try {
	    input.close();
	} catch (IOException ex) {
	    Logger.getLogger(InputReader.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
