/*
 * 
 * 
 * 
 */
package vue;

import controleur.Controleur;
import controleur.General;
import controleur.cMain;
import java.util.Observable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * vConnexion.java
 *
 */
public class vConnexion extends Vue {

    private final static double WIDTH = 400 * General.RATIO_X;
    private final static double HEIGHT = 500 * General.RATIO_Y;

    private VBox vb;
    private TitledPane tp;
    private TextField tfPseudo;
    private TextField tfIp;
    private NumberField tfPort;
    private Button bConnexion;
    private VBox vbConnexion;
    private ProgressBar piConnexion;
    private Label lConnexion;

    public vConnexion(Controleur controleur) {
	super(controleur, new VBox(), WIDTH / General.RATIO_X, HEIGHT / General.RATIO_Y);
	init();
	bConnexion.setOnAction((event) -> {
	    ((cMain) controleur).connexion(tfPseudo.getText(), tfIp.getText(), tfPort.getNumber());
	});
    }

    private void init() {
	stage.setTitle("Connexion");
	this.scene.setFill(Color.web("rgb(64,64,128);"));

	vb = (VBox) scene.getRoot();
	vb.setMinSize(WIDTH, HEIGHT);
	vb.setAlignment(Pos.CENTER);
	vb.setSpacing(50 * General.RATIO_X);
	vb.setStyle("-fx-background:transparent;"
		+ "-fx-background-color:transparent;");

	Label titre = new Label("Connexion au serveur");
	titre.setFont(Font.font("sans-serif", FontWeight.EXTRA_LIGHT, 30 * General.RATIO_X));
	titre.setTextFill(Color.web("white", 0.9));
	add(titre);

	tfPseudo = new TextField("Mon pseudo");
	tfPseudo.setPromptText("Mon pseudo");
	tfPseudo.setMaxWidth(WIDTH / 2);
	tfPseudo.setAlignment(Pos.CENTER);
	add(tfPseudo);

	bConnexion = new Button("Je me connecte");
	bConnexion.setDefaultButton(true);
	bConnexion.setMinSize(WIDTH / 2, 40 * General.RATIO_Y);
	bConnexion.setFont(Font.font("Arial", FontWeight.BOLD, 20 * General.RATIO_X));
	bConnexion.setTextFill(Color.web("rgb(64,64,128);"));
	add(bConnexion);

	vbConnexion = new VBox();
	vbConnexion.setMinWidth(WIDTH);
	vbConnexion.setAlignment(Pos.CENTER);

	piConnexion = new ProgressBar();
	piConnexion.setMinSize(WIDTH / 2, 25 * General.RATIO_Y);
	vbConnexion.getChildren().add(piConnexion);

	lConnexion = new Label();
	lConnexion.setFont(Font.font("sans-serif", 12 * General.RATIO_X));
	lConnexion.setTextFill(Color.WHITE);
	vbConnexion.getChildren().add(lConnexion);

	tp = new TitledPane();
	tp.setText("Options");
	tp.setMaxWidth(WIDTH / 2);
	tp.setExpanded(false);
	add(tp);

	GridPane gOptions = new GridPane();
	gOptions.setMaxWidth(WIDTH / 2);
	tp.setContent(gOptions);

	Label lIp = new Label("IP serveur");
	lIp.setMinWidth(WIDTH / 4);
	gOptions.add(lIp, 0, 0);

	tfIp = new TextField("127.0.0.1");
	tfIp.setPromptText("127.0.0.1");
	tfIp.setMaxWidth(WIDTH / 4);
	tfIp.setAlignment(Pos.CENTER);
	gOptions.add(tfIp, 1, 0);

	Label lPort = new Label("Port serveur");
	gOptions.add(lPort, 0, 1);

	tfPort = new NumberField(43666);
	tfPort.setPromptNumber(43666);
	tfPort.setMaxWidth(WIDTH / 4);
	tfPort.setAlignment(Pos.CENTER);
	gOptions.add(tfPort, 1, 1);

    }

    public void load(int stade) {
	
	switch (stade) {
	    case 0:
		tfPseudo.setDisable(true);
		tp.setDisable(true);
		piConnexion.setProgress(0);
		lConnexion.setText("Connexion au serveur...");
		del(bConnexion);
		vb.getChildren().add(2, vbConnexion);
		break;
	    case 1:
		piConnexion.setProgress(0.5);
		lConnexion.setText("Demande du pseudo...");
		break;
	    case 2:
		piConnexion.setProgress(1);
		lConnexion.setText("Confirmation du pseudo et demande de la map...");
		break;
	    default:
		break;
	}
    }

    public void deload() {
	del(vbConnexion);
	vb.getChildren().add(2, bConnexion);
	tfPseudo.setDisable(false);
	tp.setDisable(false);
    }

    @Override
    public void update(Observable o, Object arg) {
    }
    
    @Override
    public boolean found(Node node) {
	return vb.getChildren().contains(node);
    }

    @Override
    public void add(Node... node) {
	vb.getChildren().addAll(node);
    }

    @Override
    public void del(Node... node) {
	vb.getChildren().removeAll(node);
    }

}
