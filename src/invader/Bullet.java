package invader;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	Rectangle bullet;
	
	private int width = 4;
	private int height = 8;
	private int posX;
	private int posY;
	
	public Bullet(Protector protector) {
		bullet = new Rectangle();
		posX = protector.getPosX()+protector.getSize()/2;
		posY = protector.getPosY()-height;
		bullet.setBounds(posX, posY, width, height);
	}
	
	public int getPosY() {
		return posY;
	}
	
	public Rectangle getRectangle() {
		return this.bullet;
	}

	public void render(Graphics g) {
		posY -= 1;
		g.fillRect(posX, posY, width, height);
		bullet.setBounds(posX,posY,width,height);
	}
}
