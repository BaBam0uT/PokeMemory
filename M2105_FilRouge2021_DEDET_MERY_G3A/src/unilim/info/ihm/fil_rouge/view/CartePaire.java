package unilim.info.ihm.fil_rouge.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class CartePaire extends StackPane {
	private static int x;
	private static int y;
	
	private ArrayList<Carte> cardPair;
	private Image[] puzz;
	public static String[] urls;
	private Carte tile;
	private String urlPair1 = new File("images/carte_pikachu.jpg").toURI().toString();
	private String urlPair2 = new File("images/carte_dracaufeu.jpg").toURI().toString();
	private String urlPair3 = new File("images/carte_tortank.jpg").toURI().toString();
	private String urlPair4 = new File("images/carte_florizarre.jpg").toURI().toString();
	private String urlPair5 = new File("images/carte_evoli.jpg").toURI().toString();
	private String urlPair6 = new File("images/carte_mew.jpg").toURI().toString();
	private String urlPair7 = new File("images/carte_rayquaza.png").toURI().toString();
	private String urlPair8 = new File("images/carte_lucario.png").toURI().toString();
	private String urlPair9 = new File("images/carte_ho-oh.jpg").toURI().toString();
	private String urlPair10 = new File("images/carte_lugia.jpg").toURI().toString();
	private String urlPair11 = new File("images/carte_ronflex.jpg").toURI().toString();
	private String urlPair12 = new File("images/carte_ectoplasma.jpg").toURI().toString();
	private String urlPair13 = new File("images/carte_leviator.png").toURI().toString();
	private String urlPair14 = new File("images/carte_alakazam.png").toURI().toString();
	private String urlPair15 = new File("images/carte_dracolosse.png").toURI().toString();

	public CartePaire() {
		x = this.difficultNombrePaires();
		y = this.difficultNombreParLigne();
		ArrayList<Carte> cardPair = new ArrayList<>();
		Image[] puzz = new Image[x];
		String[] urls = { urlPair1, urlPair2, urlPair3, urlPair4, urlPair5, urlPair6, urlPair7, urlPair8, urlPair9, urlPair10, urlPair11, urlPair12, urlPair13, urlPair14, urlPair15};
		for(int i = 0 ; i< puzz.length;i++) {
	    	puzz[i]= new Image(urls[i]);

	    	}

		for (int i1 = 0; i1 < x; i1++) {

	    	cardPair.add(new Carte(puzz[i1]));
	    	cardPair.add(new Carte(puzz[i1]));
		}

		Collections.shuffle(cardPair);

		for (int i11 = 0; i11 < cardPair.size(); i11++) {

	    	Carte tile = cardPair.get(i11);

			if (RootPane.getDifficulte().equals("Facile")) {
				tile.setTranslateX(250 * (i11 % y));
				tile.setTranslateY(290 * (i11 / y));
			}
			
			if (RootPane.getDifficulte().equals("Moyen")) {
				tile.getCard().setHeight(190);
				tile.getCard().setWidth(175);
		    	tile.setTranslateX(200 * (i11 % y));
		    	tile.setTranslateY(210 * (i11 / y));
			}
			
			if (RootPane.getDifficulte().equals("Difficile")) {
				tile.getCard().setHeight(150);
				tile.getCard().setWidth(145);
		    	tile.setTranslateX(165 * (i11 % y));
		    	tile.setTranslateY(170 * (i11 / y));
			}
	    	getChildren().add(tile);
		}
	}
	
	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		CartePaire.x = x;
	}

	public int difficultNombrePaires() {
		int x = 0;
		if (RootPane.getDifficulte().equals("Facile")) {
			x = 6;
		}
		if (RootPane.getDifficulte().equals("Moyen")) {
			x = 10;
		}
		if (RootPane.getDifficulte().equals("Difficile")) {
			x = 15;
		}
		return x;
	}
	
	public int difficultNombreParLigne() {
		int y = 0;
		if (RootPane.getDifficulte().equals("Facile")) {
			y = 4;
		}
		if (RootPane.getDifficulte().equals("Moyen")) {
			y = 5;
		}
		if (RootPane.getDifficulte().equals("Difficile")) {
			y = 6;
		}
		return y;
	}
	
	public Image[] getPuzz() {
		return puzz;
	}
	
	public ArrayList<Carte> getCardPair() {
		return cardPair;
	}
	
	public Carte getTile() {
		return tile;
	}

	public String getUrlPair1() {
		return urlPair1;
	}

	public String getUrlPair2() {
		return urlPair2;
	}

	public String getUrlPair3() {
		return urlPair3;
	}

	public String getUrlPair4() {
		return urlPair4;
	}

	public String getUrlPair5() {
		return urlPair5;
	}

	public String getUrlPair6() {
		return urlPair6;
	}
}
