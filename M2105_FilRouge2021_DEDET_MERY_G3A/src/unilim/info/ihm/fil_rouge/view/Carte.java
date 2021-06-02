package unilim.info.ihm.fil_rouge.view;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import unilim.info.ihm.fil_rouge.controller.Controller;

public class Carte extends Pane {
	
	Rectangle card;
	String urlDosCarte = new File("images/carte_dos.png").toURI().toString();
	Image imgDos;
	Image imgFace;
	
	public Carte(Image image) {
		imgDos = new Image(urlDosCarte);
		this.imgFace = image;
		card = new Rectangle(200, 250);
		card.setFill(new ImagePattern(imgDos));
        
		getChildren().addAll(card);	
		
		this.setOnMouseClicked(new Controller(this));

	}

	public void hideImg() {
		this.card.setVisible(false);
	}
	
	public void setImgFace(Image imgFace) {
		this.imgFace = imgFace;
	}

	public Rectangle getCard() {
		return card;
	}

	public String getUrlDosCarte() {
		return urlDosCarte;
	}

	public Image getImgDos() {
		return imgDos;
	}

	public Image getImgFace() {
		return imgFace;
	}
	
}
