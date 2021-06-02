package unilim.info.ihm.fil_rouge.view;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import unilim.info.ihm.fil_rouge.controller.JouerController;
import unilim.info.ihm.fil_rouge.controller.QuitterController;

public class MenuPane extends BorderPane{
	
	private Button jouer;
	private static ComboBox<String> cbDifficulte;
	private Button quitter;	
	private String urlFondMenu = new File("images/fond_menu.jpg").toURI().toString();
	private String urlFondCarteFacile = new File("images/fond_menu_facile.png").toURI().toString();
	private String urlFondCarteMoyen = new File("images/fond_menu_moyen.png").toURI().toString();
	private String urlFondCarteDifficile = new File("images/fond_menu_difficile.png").toURI().toString();
	private String urlFondGauche = new File("images/fond_menu_gauche.jpg").toURI().toString();
	private String urlFondDroite = new File("images/fond_menu_droite.jpg").toURI().toString();
	private StackPane zoneCentre;
	private Carte card;
	
	public MenuPane() {
		Button jouer = new Button("Jouer");
		jouer.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #617BCD; -fx-text-fill: #353131;");
		this.cbDifficulte = new ComboBox<String>();
		cbDifficulte.getItems().addAll("Facile", "Moyen", "Difficile");
		cbDifficulte.setValue("Facile");
		System.out.println(cbDifficulte.getValue());
		cbDifficulte.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #617BCD");
		Button quitter = new Button("Quitter");
		quitter.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #617BCD; -fx-text-fill: #353131;");
		Image imgFond = new Image(urlFondMenu);
		Rectangle zoneImgFond = new Rectangle(730,372);
		Rectangle zoneImgGauche = new Rectangle(500,1010);
		zoneImgGauche.setFill(new ImagePattern(new Image(urlFondGauche)));
		Rectangle zoneImgDroite = new Rectangle(500,1010);
		zoneImgDroite.setFill(new ImagePattern(new Image(urlFondDroite)));
		HBox hboxMenu = new HBox(jouer,cbDifficulte,quitter);
		hboxMenu.setAlignment(Pos.CENTER_RIGHT);
		hboxMenu.setSpacing(100);
		zoneImgFond.setTranslateY(-215);
		zoneImgFond.setTranslateX(-10);
		hboxMenu.setTranslateX(-10);
		hboxMenu.setAlignment(Pos.CENTER);
		hboxMenu.setTranslateY(200);
		this.zoneCentre = new StackPane(zoneImgFond, hboxMenu);
		this.setCenter(zoneCentre);
		this.setLeft(zoneImgGauche);
		this.setRight(zoneImgDroite);
		zoneCentre.setBackground(new Background(new BackgroundImage(imgFond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, new BackgroundSize(870,1010,false,false,false,false))));
		BorderPane.setMargin(zoneCentre, new Insets(0,0,0,30));
		BorderPane.setMargin(hboxMenu, new Insets(0,200,50,0));
		BorderPane.setMargin(zoneImgFond, new Insets(103,0,0,85));
		
		cbDifficulte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (cbDifficulte.getValue().equals("Facile")) {
            		zoneImgFond.setFill(new ImagePattern(new Image(urlFondCarteFacile)));
            	}
            	if (cbDifficulte.getValue().equals("Moyen")) {
            		zoneImgFond.setFill(new ImagePattern(new Image(urlFondCarteMoyen)));
            	}
            	if (cbDifficulte.getValue().equals("Difficile")) {
            		zoneImgFond.setFill(new ImagePattern(new Image(urlFondCarteDifficile)));
            	}
            }});
		
		quitter.setOnMouseClicked(new QuitterController());
		jouer.setOnMouseClicked(new JouerController());
	}
	
	public Button getJouer() {
		return jouer;
	}

	public static ComboBox<String> getCbDifficulte() {
		return cbDifficulte;
	}

	public Button getQuitter() {
		return quitter;
	}

}
