/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Richard
 */
public abstract class Vue extends Observable implements Observer {

    protected final Controleur controleur;

    protected final Stage stage;
    protected final Scene scene;

    public Vue(Controleur controleur, Parent root, double width, double height) {
	this.controleur = controleur;
	this.scene = new Scene(root, width, height);
	this.stage = new Stage();
	stage.setScene(scene);
    }
    
    public void show() {
	stage.show();
    }
    
    public void close() {
	stage.close();
    }

    public abstract boolean found(Node node);

    public abstract void add(Node... node);

    public abstract void del(Node... node);

    public Stage getStage() {
	return stage;
    }
    
    public void update(Object obj) {
	setChanged();
	notifyObservers(obj);
    }

}
