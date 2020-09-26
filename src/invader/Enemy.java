package invader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	private int posX;
	private int posY;
	private int strength;
	private int size;
	private Rectangle enemy;
	
	public Enemy() {
		strength = 1;
		size = 20;
		posY = randomY();
		posX = randomX();
		enemy = new Rectangle();
		enemy.setBounds(getPosX(), getPosY(), size, size);
	}
	
	public int randomX() {
		double randomD = Math.random();
		double randomDo = randomD*(600-size)+1;
		int randomI = (int) randomDo;
		return randomI;
	}
	
	public int randomY() {
		double randomD = Math.random();
		double randomDo = randomD*(300)+ size;
		int randomI = (int) randomDo;
		randomI *= -1;
		return randomI;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public Rectangle getRectangle() {
		return this.enemy;
	}
	
	public void incrementStrenght() {
		if(strength < 5) {
			strength++;
		}
	}
	
	public void damage() {
		strength--;
	}
	
	public int getStrength() {
		return strength;
	}
	
	
	
	public void render(Graphics g) {
		posY++;
		g.setColor(Color.RED);
		if(this.strength > 1) {
			g.setColor(Color.MAGENTA);
			if(this.strength > 3) {
				g.setColor(Color.CYAN);
			}
			posY++;
		}
		g.fillRect(posX, posY, size, size);
		enemy.setBounds(posX, posY, size, size);
		if(getPosY() > 600) {
			this.posX = randomX();
			this.posY = randomY();
			enemy.setBounds(posX, posY, size, size);//funker ikke 
			incrementStrenght();
		}
	}

}
