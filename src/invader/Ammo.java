package invader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ammo {
	
	
	private int posX;
	private int posY;
	private int size;
	private Rectangle ammoBox;
	
	public Ammo() {
		size = 20;
		posY = randomY();
		posX = randomX();
		ammoBox = new Rectangle();
		ammoBox.setBounds(getPosX(), getPosY(), size, size);
	}
	
	public int getPosY() {
		return posY;
	}

	public int getPosX() {
		return posX;
	}

	public int randomY() {
		double randomD = Math.random();
		double randomDo = randomD*(300)+ size;
		int randomI = (int) randomDo;
		randomI *= -1;
		return randomI;
	
	}public int randomX() {
		double randomD = Math.random();
		double randomDo = randomD*(600-size)+1;
		int randomI = (int) randomDo;
		return randomI;
	}
	
	public void render(Graphics g) {
		posY++;
		g.setColor(Color.GREEN);
		g.fillRect(getPosX(), getPosY(), size, size);
		ammoBox.setBounds(getPosX(), getPosY(), size, size);
		}
	
	public Rectangle getRectangle() {
		return ammoBox;
	}

}
