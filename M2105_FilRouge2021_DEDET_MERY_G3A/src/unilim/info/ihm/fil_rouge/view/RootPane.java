package unilim.info.ihm.fil_rouge.view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RootPane extends BorderPane {

	private Button quitter;
	private Carte card;
	private CartePaire grid = new CartePaire();
	private HBox hbox;
	private Label lblDifficulte;
	private Label lblScore;
	private int score = 0;
	private MenuPane menu;
	private static String difficulte = MenuPane.getCbDifficulte().getValue();
	private Rectangle rectGauche;
	private Rectangle rectDroite;
	private Image imgGauche;
	private Image imgDroite;
	private Image imgFond;
	private static Alert victoire;
	private String urldroite = new File("images/fond_droite.jpg").toURI().toString();
	private String urlgauche = new File("images/fond_gauche.jpg").toURI().toString();
	private String urlfond = new File("images/fond_ecran.png").toURI().toString();

	
	public RootPane() {
		Rectangle rectGauche = new Rectangle(400, 900);
		Rectangle rectDroite = new Rectangle(400, 900);
		Image imgGauche = new Image(urlgauche);
		rectGauche.setFill(new ImagePattern(imgGauche));
		rectGauche.setStroke(Color.BLACK);
		Image imgDroite = new Image(urldroite);
		rectDroite.setFill(new ImagePattern(imgDroite));
		rectDroite.setStroke(Color.BLACK);
		Image imgFond = new Image(urlfond);
		this.setBackground(new Background(new BackgroundImage(imgFond, null, null, null, new BackgroundSize(100,100,false,false,true,true))));
		Button quitter = new Button("Quitter");
		quitter.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #425b8a; -fx-text-fill: WHITE;");
		Label lblDifficulte = new Label("Difficulté : " + difficulte);
		lblDifficulte.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #425b8a; -fx-text-fill: WHITE;");
		Label lblScore = new Label("Score : " + score);
		lblScore.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-background-color: #425b8a; -fx-text-fill: WHITE;");
		HBox hbox = new HBox(quitter, lblScore, lblDifficulte);
		BorderPane.setMargin(grid, new Insets(15,50,50,75));
		this.setTop(hbox);
		this.setCenter(grid);
		this.setLeft(rectGauche);
		this.setRight(rectDroite);
		hbox.setSpacing(650);
		BorderPane.setMargin(hbox, new Insets(50,0,50,150));
	}

	public static Alert getVictoire() {
		return victoire;
	}

	public Button getQuitter() {
		return quitter;
	}

	public Carte getCard() {
		return card;
	}
	
	public CartePaire getGrid() {
		return grid;
	}

	public HBox getHbox() {
		return hbox;
	}

	public Label getLblDifficulte() {
		return lblDifficulte;
	}

	public Label getLblScore() {
		return lblScore;
	}

	public Rectangle getRectGauche() {
		return rectGauche;
	}

	public Rectangle getRectDroite() {
		return rectDroite;
	}

	public Image getImgGauche() {
		return imgGauche;
	}

	public Image getImgDroite() {
		return imgDroite;
	}

	public String getUrldroite() {
		return urldroite;
	}

	public String getUrlgauche() {
		return urlgauche;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Image getImgFond() {
		return imgFond;
	}

	public String getUrlfond() {
		return urlfond;
	}
	
	public static String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		RootPane.difficulte = difficulte;
	}
}
