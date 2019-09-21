package application;

import java.util.Random;

import javafx.scene.paint.Color;

public class Shape {

	public int x;
	public int y;
	public Block[][][] shapemap;
	public int current_state = 0;

	public Shape() {

		x = 3;

		Color c;

		Random random = new Random();
		int i = random.nextInt(7);

		if (i == 0) {
			//3 long with a extrussion
			c = Color.BLUE;
			shapemap = new Block[4][3][3];
			// 0
			// *
			//***
			//
			shapemap[0][0][1] = new Block(c);
			shapemap[0][1][0] = new Block(c);
			shapemap[0][1][1] = new Block(c);
			shapemap[0][1][2] = new Block(c);
			// 1
			// *
			//**
			// *
			shapemap[1][0][1] = new Block(c);
			shapemap[1][1][1] = new Block(c);
			shapemap[1][1][2] = new Block(c);
			shapemap[1][2][1] = new Block(c);
			// 2
			//
			//***
			// *
			shapemap[2][1][0] = new Block(c);
			shapemap[2][1][1] = new Block(c);
			shapemap[2][1][2] = new Block(c);
			shapemap[2][2][1] = new Block(c);
			// 3
			// *
			//**
			// *
			shapemap[3][0][1] = new Block(c);
			shapemap[3][1][0] = new Block(c);
			shapemap[3][1][1] = new Block(c);
			shapemap[3][2][1] = new Block(c);
		} else if (i == 1) {
			//squere
			c = Color.YELLOW;
			shapemap = new Block[1][2][2];
			shapemap[0][0][0] = new Block(c);
			shapemap[0][0][1] = new Block(c);
			shapemap[0][1][0] = new Block(c);
			shapemap[0][1][1] = new Block(c);
		} else if (i == 2) {
			//4 long
			c = Color.ORANGE;
			
			shapemap = new Block[2][4][4];
			
			shapemap[0][3][0] = new Block(c);
			shapemap[0][3][1] = new Block(c);
			shapemap[0][3][2] = new Block(c);
			shapemap[0][3][3] = new Block(c);

			shapemap[1][0][3] = new Block(c);
			shapemap[1][1][3] = new Block(c);
			shapemap[1][2][3] = new Block(c);
			shapemap[1][3][3] = new Block(c);
			
		} else if (i == 3) {
			
			//the L
			shapemap = new Block[4][3][3];
			c = Color.WHITE;
			//0
			shapemap[0][0][1] = new Block(c);
			shapemap[0][1][1] = new Block(c);
			shapemap[0][2][1] = new Block(c);
			shapemap[0][2][2] = new Block(c);
			
			//1
			shapemap[1][0][2] = new Block(c);
			shapemap[1][1][0] = new Block(c);
			shapemap[1][1][1] = new Block(c);
			shapemap[1][1][2] = new Block(c);
			
			//2
			shapemap[2][0][0] = new Block(c);
			shapemap[2][0][1] = new Block(c);
			shapemap[2][1][1] = new Block(c);
			shapemap[2][2][1] = new Block(c);
			
			
			//3
			shapemap[3][1][0] = new Block(c);
			shapemap[3][1][1] = new Block(c);
			shapemap[3][1][2] = new Block(c);
			shapemap[3][2][0] = new Block(c);

			
			
		} else if (i == 4) {
			//other L
			shapemap = new Block[4][3][3];
			c = Color.CYAN;
			//0
			shapemap[0][0][1] = new Block(c);
			shapemap[0][1][1] = new Block(c);
			shapemap[0][2][0] = new Block(c);
			shapemap[0][2][1] = new Block(c);
			
			//1
			shapemap[1][1][0] = new Block(c);
			shapemap[1][1][1] = new Block(c);
			shapemap[1][1][2] = new Block(c);
			shapemap[1][2][2] = new Block(c);
			
			//2
			shapemap[2][0][1] = new Block(c);
			shapemap[2][0][2] = new Block(c);
			shapemap[2][1][1] = new Block(c);
			shapemap[2][2][1] = new Block(c);
			
			
			//3
			shapemap[3][0][0] = new Block(c);
			shapemap[3][1][0] = new Block(c);
			shapemap[3][1][1] = new Block(c);
			shapemap[3][1][2] = new Block(c);

			
		} else if (i == 5) {
			//diagonal left
			shapemap = new Block[2][3][3];
			c = Color.GREEN;
			
			//0
			shapemap[0][1][0] = new Block(c);
			shapemap[0][1][1] = new Block(c);
			shapemap[0][2][1] = new Block(c);
			shapemap[0][2][2] = new Block(c);
			
			//1
			shapemap[1][0][1] = new Block(c);
			shapemap[1][1][0] = new Block(c);
			shapemap[1][1][1] = new Block(c);
			shapemap[1][2][0] = new Block(c);
			
		} else if (i == 6) {
			//diagonal right
			shapemap = new Block[2][3][3];
			c = Color.PURPLE;
			
			//0
			shapemap[0][1][1] = new Block(c);
			shapemap[0][1][2] = new Block(c);
			shapemap[0][2][0] = new Block(c);
			shapemap[0][2][1] = new Block(c);
			
			//1
			shapemap[1][0][0] = new Block(c);
			shapemap[1][1][0] = new Block(c);
			shapemap[1][1][1] = new Block(c);
			shapemap[1][2][1] = new Block(c);
		}
		y = -shapemap[current_state].length;

	}

	public boolean checkCollisionBounds() {

		for (int i = 0; i < shapemap[current_state].length; i++) {
			for (int n = 0; n < shapemap[current_state][i].length; n++) {
				if (shapemap[current_state][i][n] != null && this.y+i>=0) {

					if (this.y + i >= Game.getGame().map.length) {
						return true;
					}

					if (this.x + n >= Game.getGame().map[0].length) {
						return true;
					} else if (this.x + n < 0) {
						return true;
					}

					if (Game.getGame().map[this.y + i][this.x + n] != null) {
						return true;
					}

				}
			}
		}

		return false;
	}

	public void rotate(boolean dir) {

		if (dir) {
			if (current_state == shapemap.length - 1) {
				current_state = 0;
			} else {
				current_state++;
			}
		} else {
			if (current_state == 0) {
				current_state = shapemap.length - 1;
			} else {
				current_state--;
			}

		}

		if (checkCollisionBounds()) {
			x++;
			if (checkCollisionBounds()) {
				x--;
				x--;
				if (checkCollisionBounds()) {
					x++;
					y++;
					if (checkCollisionBounds()) {
						y--;
						y--;
						if (checkCollisionBounds()) {

							rotate(!dir);
						}

					}
				}
			}
		}

		// old rotation method
		/*
		 * Block [][] newShapeMap = new Block[shapemap.length][shapemap[0].length];
		 * 
		 * if(dir) {
		 * 
		 * 
		 * for(int i = 0;i<newShapeMap.length;i++) { for(int n =
		 * 0;n<newShapeMap[0].length;n++) { newShapeMap[i][n] =
		 * this.shapemap[n][shapemap.length-i-1]; } }
		 * 
		 * 
		 * } this.shapemap = newShapeMap;
		 */
	}

	// no longer used
	/*
	 * public boolean shift(int dir) { boolean possible = true; if(dir==0) {
	 * //shifting down for(int i = 0;i<shapemap[shapemap.length-1].length;i++) {
	 * if(shapemap[shapemap.length-1][i]!=null) { possible = false; } } if(possible)
	 * { for(int i = shapemap.length-2; i>=0;i--) { for(int n =
	 * 0;n<shapemap[i].length;n++) { if(shapemap[i][n]!=null) {
	 * 
	 * shapemap[i+1][n] = shapemap[i][n]; shapemap[i][n] = null; } } } }
	 * 
	 * }else if(dir==1) { //shifting left for(int i = 0;i<shapemap.length;i++) {
	 * if(shapemap[i][0]!=null) { possible = false; } } if(possible) { for(int i =
	 * 0; i<shapemap.length;i++) { for(int n = 1;n<shapemap[i].length;n++) {
	 * if(shapemap[i][n]!=null) {
	 * 
	 * shapemap[i][n-1] = shapemap[i][n]; shapemap[i][n] = null; } } } }
	 * 
	 * }else if(dir==2) { //shifting right for(int i = 0;i<shapemap.length;i++) {
	 * if(shapemap[i][shapemap.length-1]!=null) { possible = false; } } if(possible)
	 * { for(int i = 0; i<shapemap.length;i++) { for(int n =
	 * shapemap[i].length-2;n>=0;n--) { if(shapemap[i][n]!=null) {
	 * 
	 * shapemap[i][n+1] = shapemap[i][n]; shapemap[i][n] = null; } } } }
	 * 
	 * }else { possible = false; }
	 * 
	 * return possible; }
	 */
}
