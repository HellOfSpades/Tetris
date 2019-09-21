package application.threads;

import application.Block;
import application.Game;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Updater extends AnimationTimer{

	GraphicsContext g;
	
	public Updater(Canvas canvas){
		g = canvas.getGraphicsContext2D();
		g.setFill(Color.DARKGREY);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void handle(long now) {
		
		//updating the points count
		Game.getGame().controller.points.setText(Game.getGame().points+"");
		
		g.setFill(Color.BLACK);
		g.fillRect(0, 0, Game.getGame().map[0].length*Block.WIDTH+1,Game.getGame().map.length*Block.HEIGHT);
		
		g.setFill(Color.GREY);
		g.fillRect(Game.getGame().map[0].length*Block.WIDTH+20, Game.getGame().map.length*Block.HEIGHT-200, 4*Block.WIDTH,4*Block.HEIGHT);
		
		
		//drawing the current shape
		for(int i = 0;i<Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state].length;i++) {
			for(int n = 0;n<Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i].length;n++) {
				if(Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i][n]!=null) {
					g.setFill(Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i][n].c);
					g.fillRect((Game.getGame().currentShape.x+n)*Block.WIDTH, (Game.getGame().currentShape.y+i)*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
					g.strokeRect((Game.getGame().currentShape.x+n)*Block.WIDTH, (Game.getGame().currentShape.y+i)*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
				}
			}
		}
		//drawing the next shape
		for(int i = 0;i<Game.getGame().nextShape.shapemap[Game.getGame().nextShape.current_state].length;i++) {
			for(int n = 0;n<Game.getGame().nextShape.shapemap[Game.getGame().nextShape.current_state][i].length;n++) {
				if(Game.getGame().nextShape.shapemap[Game.getGame().nextShape.current_state][i][n]!=null) {
					g.setFill(Game.getGame().nextShape.shapemap[Game.getGame().nextShape.current_state][i][n].c);
					g.fillRect((Game.getGame().map[0].length*Block.WIDTH+20)+n*Block.WIDTH, (Game.getGame().map.length*Block.HEIGHT-200)+i*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
					g.strokeRect((Game.getGame().map[0].length*Block.WIDTH+20)+n*Block.WIDTH, (Game.getGame().map.length*Block.HEIGHT-200)+i*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
				}
			}
		}
		//drawing the map
		for(int i = 0;i<Game.getGame().map.length;i++) {
			for(int n = 0;n<Game.getGame().map[i].length;n++) {
				if(Game.getGame().map[i][n]!=null) {
					g.setFill(Game.getGame().map[i][n].c);
					g.fillRect(n*Block.WIDTH, i*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
					g.strokeRect(n*Block.WIDTH, i*Block.HEIGHT, Block.WIDTH, Block.HEIGHT);
				}
			}
		}
		
	}
}

