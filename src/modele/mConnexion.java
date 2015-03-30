/*
 * 
 * 
 * 
 */
package modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.Erreur;

/**
 * mConnexion.java Static
 */
public class mConnexion {

    private static Socket socketClient;
    private static PrintWriter sout;
    private static InputReader inputReader;

    public static void init() {
	socketClient = null;
    }

    public static boolean connecter(String servIp, int servPort) {

	System.out.println("--- Connexion au serveur ---");

	try {
	    socketClient = new Socket(servIp, servPort);

	    inputReader = new InputReader(
		    new BufferedReader(new InputStreamReader(socketClient.getInputStream()))
	    );
	    inputReader.start();
	    sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())));
	    System.out.println("-Socket, reader, writer OK");
	} catch (IOException ex) {
	    Erreur.afficher("Connexion au serveur impossible. Vérifiez l'IP et le port. "
		    + "Le serveur peut aussi être éteint, contactez son administrateur.\n"
		    + "Message d'erreur : " + ex.toString());
	    return false;
	}

	return true;
    }

    public static boolean envoiPseudo(String pseudo) {

	System.out.println("--- Demande pseudo ---");

	sout.println("pseudo:" + pseudo);
	sout.flush();
	System.out.println("-Demande envoyée");
	return true;
    }

    public static boolean confirmPseudo(String pseudo) {

	System.out.println("-Attente ID...");

	Paquet paqId = null;
	try {
	    paqId = InputReader.listPaquet.waitPaquet("id");
	} catch (Exception ex) {
	    Erreur.afficher("Attente de reception paquet trop long", "Attente du paquet 'id' trop long");
	    return false;
	}

	if (paqId.getFirstMessage().equals("false")) {
	    Erreur.afficher("Pseudo déjà utilisé. Veuillez en choisir un autre.");
	    return false;
	}
	Joueur.pseudo = pseudo;
	Joueur.ID = paqId.getFirstMessageToInt();
	System.out.println("-ID accordé : " + Joueur.ID);
	System.out.println(Joueur.tostring());

	return true;
    }

    public static void deconnexion() {
	System.out.println("--- Déconnexion du serveur ---");
	if (socketClient != null && socketClient.isConnected()) {
	    try {
		System.out.print("-SocketClient...");
		socketClient.close();
		System.out.println("OK !");
		System.out.print("-InputReader...");
		inputReader.stop();
		System.out.println("OK !");
		System.out.print("-OutputWriter...");
		sout.close();
		System.out.println("OK !");
	    } catch (IOException ex) {
		Logger.getLogger(mConnexion.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	System.out.println("-Vous êtes déconnecté");
    }

}
