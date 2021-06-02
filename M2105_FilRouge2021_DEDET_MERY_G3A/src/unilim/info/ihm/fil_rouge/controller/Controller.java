package unilim.info.ihm.fil_rouge.controller;

import java.io.File;
import java.util.Optional;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;
import unilim.info.ihm.fil_rouge.Main;
import unilim.info.ihm.fil_rouge.view.Carte;
import unilim.info.ihm.fil_rouge.view.CartePaire;

public class Controller implements EventHandler<MouseEvent> {

	static Carte premiereCarte;
	private Carte deuxiemeCarte;
	private static String oldImg;
	private static String urlImage = "";
	private static boolean noSpam = true;
	private static int nbPairesTrouvees = 0;
	AudioClip source = new AudioClip(new File("musiques/son_retourner_carte.wav").toURI().toString());
	private Timeline cacherCartes = new Timeline(
            new KeyFrame(Duration.seconds(1), sec->{
				premiereCarte.getCard().setFill(new ImagePattern(premiereCarte.getImgDos()));
        		deuxiemeCarte.getCard().setFill(new ImagePattern(deuxiemeCarte.getImgDos()));
				source.play();
				noSpam = true;
            }));
	private Timeline disparaitreCartes = new Timeline(
            new KeyFrame(Duration.seconds(1), sec->{
				deuxiemeCarte.setVisible(false);
				premiereCarte.setVisible(false);
				source.play();
				}));
	Stage primaryStage;


	public Controller(Carte card) {
		this.deuxiemeCarte = card;
	}

	// TODO Méthode handle

	@Override
	public void handle(MouseEvent event) {
		Node selected = (Node) event.getTarget();
		if (!(selected instanceof Pane || noSpam==false)) {
			if (urlImage.equals("") && noSpam==true) {
				premiereCarte = deuxiemeCarte;
				oldImg = deuxiemeCarte.getImgFace().toString();
				premiereCarte.getCard().setFill(new ImagePattern(premiereCarte.getImgFace()));
				source.play();
				urlImage = "autre";
			} else {
				if (premiereCarte != deuxiemeCarte) {
					noSpam = false;
					deuxiemeCarte.getCard().setFill(new ImagePattern(deuxiemeCarte.getImgFace()));
					source.play();
				    cacherCartes.playFromStart();
					if (oldImg.equals(deuxiemeCarte.getImgFace().toString())) {
						disparaitreCartes.playFromStart();
						nbPairesTrouvees = nbPairesTrouvees + 1;
						if(nbPairesTrouvees==CartePaire.getX()) {
							dialogueFin();
						}
					}					
				}
				urlImage = "";
			}
		}
	}
	
	public void dialogueFin() {
		Alert victoire = new Alert(AlertType.INFORMATION);
		victoire.setTitle("Fin de la partie !");
		victoire.setHeaderText("Félicitations ! Vous avez retrouvé toutes les paires de cartes !");
		victoire.setContentText("Que souhaitez-vous faire ?");
		ButtonType boutonQuitter = new ButtonType("Quitter");
		ButtonType boutonRejouer = new ButtonType("Relancer");
		victoire.getButtonTypes().setAll(boutonQuitter,boutonRejouer);
        Optional<ButtonType> option = victoire.showAndWait();
		if(option.get()==boutonQuitter) {
			Platform.exit();
		}
		if(option.get()==boutonRejouer) {
			Main.getMediaPlayer().stop();
			Main.getPrimaryStage().close();
			Platform.runLater(() -> new Main().start(new Stage()));
		}
	}
}