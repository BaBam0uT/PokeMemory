package unilim.info.ihm.fil_rouge;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import unilim.info.ihm.fil_rouge.view.MenuPane;
import unilim.info.ihm.fil_rouge.view.RootPane;

public class Main extends Application {
	
	// TODO Déclaration des composants 
	static Stage primaryStage;
	Scene sceneMenu;
	static RootPane root = new RootPane();
	static Scene sceneJeu = new Scene(root,1930,1010);
	MenuPane menu = new MenuPane();
	static Media h = new Media(new File("musiques/son_menu.wav").toURI().toString());
	static MediaPlayer mediaPlayer	= new MediaPlayer(h);

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			Scene SceneMenu = new Scene(menu,1930,1010);

			primaryStage.setScene(SceneMenu);
			primaryStage.setTitle("Pokemon Trading Card Memory Game !");
			mediaPlayer.setVolume(0.05);
			mediaPlayer.setCycleCount(10);
			mediaPlayer.play();
			mediaPlayer.setOnEndOfMedia(new Runnable() {
		        @Override
		        public void run() {
		            mediaPlayer.seek(Duration.ZERO);
		            mediaPlayer.play();
		        }
		    }); 
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pokeball.jpg")));			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getSceneJeu() {
		return sceneJeu;
	}

	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	
}
