package application;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class Controller {
	
	@FXML
	public Canvas canvas;
	@FXML
	public Label points;
	public void initialize() {
		Game.newGame(this);
		Game.getGame().start();
	}
}
