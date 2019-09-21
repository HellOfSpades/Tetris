package application.threads;

import application.Block;
import application.Game;
import application.Shape;

public class Falling extends Thread{
	
	public volatile int time = 1000;
	
	public void run() {
		while(true) {
			//moving the shape down
			Game.getGame().currentShape.y++;
			
			if(Game.getGame().currentShape.checkCollisionBounds()) {
				boolean endGame = false;
				//moving the shape back up
				Game.getGame().currentShape.y--;
				//adding the shapes blocks to the maps
				for (int i = 0; i < Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state].length; i++) {
					for (int n = 0; n < Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i].length; n++) {
						if (Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i][n] != null) {
							if(Game.getGame().currentShape.y+i<=0) {
								endGame = true;
							}else {
								Game.getGame().map[Game.getGame().currentShape.y+i][Game.getGame().currentShape.x+n] = 
								Game.getGame().currentShape.shapemap[Game.getGame().currentShape.current_state][i][n];
							}
							
						}
					}
				}
				//making a new shape
				Game.getGame().currentShape = Game.getGame().nextShape;
				Game.getGame().nextShape = new Shape();
				
				//checking if the player lost
				
				for(int i = 0;i<Game.getGame().map[0].length;i++) {
					if(Game.getGame().map[0][i]!=null) {
						endGame = true;
						break;
					}
				}
				if(endGame) {
					
					Game.getGame().map = new Block[20][10];
					Game.getGame().currentShape = Game.getGame().nextShape;
					Game.getGame().nextShape = new Shape();
					Game.getGame().points = 0;
					
					
				}else {
					for(int i = 0;i<Game.getGame().map.length;i++) {
						
						//checking every line for if they are full
						boolean full = true;
						for(int n = 0;n<Game.getGame().map[i].length;n++) {
							if(Game.getGame().map[i][n]==null) {
								full = false;
								break;
							}
						}
						if(full) {
							Game.getGame().points+=100;
							//moving all of the above rows down
							for(int i2 = i-1;i2>0;i2--) {
								for(int n = 0;n < Game.getGame().map[i2].length;n++) {
									System.out.println("worked");
									Game.getGame().map[i2+1][n] = Game.getGame().map[i2][n];
								}
							}
							//nulling out the top row
							for(int n = 0;n<Game.getGame().map[0].length;n++) {
								Game.getGame().map[0][n] = null;
							}
						}
					}
				}
				
				
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
