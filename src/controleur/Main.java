package controleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Richard
 */
public class Main extends Application {
    
    public static void main(String[] args) {
	Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
	new cMain().lancer();
//	new cLancement().lancer();
    }

}
