package unilim.info.ihm.fil_rouge.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import unilim.info.ihm.fil_rouge.Main;
import unilim.info.ihm.fil_rouge.view.RootPane;

public class JouerController implements EventHandler<MouseEvent> {

	private RootPane root;
	
	@Override
	public void handle(MouseEvent event) {
		this.root = new RootPane();
		Main.getPrimaryStage().setScene(new Scene(root,1930,1010));
	}

}
