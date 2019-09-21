package application;

import application.threads.Falling;
import application.threads.Updater;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Game {
	
	private static Game game;
	public Controller controller;
	public volatile Block[][] map;
	public volatile Shape currentShape;
	public Shape nextShape;
	public Updater updater;
	public Falling faller;
	public int points;
	
	private Game(Controller controller) {
		this.controller = controller;
		map = new Block[20][10];
		updater = new Updater(controller.canvas);
		faller = new Falling();
		currentShape = new Shape();
		nextShape = new Shape();
		points = 0;
	}
	
	static {
		
	}
	
	public void start() {
		updater.start();
		faller.start();
	}
	
	public static void newGame(Controller controller) {
		game = new Game(controller);
	}
	
	public static Game getGame() {
		return game;
	}
	
	public void compileActionPressed(KeyEvent e) {
		if(e.getCode()==KeyCode.LEFT) {
			currentShape.x--;
			if(Game.getGame().currentShape.checkCollisionBounds()) {
				Game.getGame().currentShape.x++;
			}
		}else if(e.getCode()==KeyCode.RIGHT) {
			
			Game.getGame().currentShape.x++;
			if(Game.getGame().currentShape.checkCollisionBounds()) {
				Game.getGame().currentShape.x--;
			}
			
		}
	}
	
}
