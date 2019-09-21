package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/Screen.fxml"));
		
			Scene scene = new Scene(root);
		
			//setting the program to close when the stage is closed
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

				@Override
				public void handle(WindowEvent arg0) {
					System.exit(0);
				}
			
			});
			
			
			EventHandler handlerpush = new EventHandler<KeyEvent>(){
				
				public void handle(KeyEvent e) {
					
					if(e.getCode()==KeyCode.R) {
						Game.getGame().currentShape.rotate(true);
					}else if(e.getCode()==KeyCode.E) {
						Game.getGame().currentShape.rotate(false);
					}
					else if(e.getCode()==KeyCode.DOWN) {
						Game.getGame().faller.time = 100;
					}else {
						Game.getGame().compileActionPressed(e);
					}
					
				}
			};
			EventHandler handlerrelease = new EventHandler<KeyEvent>(){
				
				public void handle(KeyEvent e) {
					if(e.getCode()==KeyCode.DOWN) {
						Game.getGame().faller.time = 1000;
					}
				}
			};
			scene.addEventFilter(KeyEvent.KEY_PRESSED, handlerpush);
			scene.addEventFilter(KeyEvent.KEY_RELEASED, handlerrelease);
			
		
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
