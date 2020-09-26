package invader;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Protector {
	
	private int posX;
	private int posY;
	private int size;
	private int speed;
	private int magazinSize;
	private int killCount;
	
	
	private Rectangle rect = new Rectangle();
	private List<Bullet> magazin = new ArrayList<>();
	
	public Protector() {
		speed = 5;
		size = 20;
		magazinSize = 5;
		killCount = 0;
		posX = 300-size;
		posY = 600-60;
		rect.setSize(size, size);
		rect.setBounds(posX, posY, size, size);
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getMagazinSize() {
		return this.magazinSize;
	}
	
	public void giveAmmo() {
		this.magazinSize++;
	}

	public void moveLeft(boolean left) {
		if(left) {
			if(posX > 0) {
			this.posX -= speed;
			this.rect.x -= speed;
			}
		}
	}
	
	public void moveRight(boolean right) {
		if(right) {
			if(posX < 600-size) {
			this.posX += speed;
			this.rect.x += speed;
			}
		}
	}
	
	public void render(Graphics g) {
		List<Bullet> remove = new ArrayList<>();
		g.fillRect(getPosX(), getPosY(), getSize(), getSize());
		rect.setBounds(posX, posY, size, size);
		for(Bullet b: magazin) {
			b.render(g);
			if(b.getPosY() < 0) {
				remove.add(b);
				magazinSize--;
			}
		}
		for(Bullet b: remove) {
			magazin.remove(b);
		}
		
	}
	
	public void shoot() {
		if(magazin.size() < magazinSize) {
			magazin.add(new Bullet(this));
		}
		
	}
	
	public List<Bullet> getMagazin() {
		return magazin;
	}
	
	public void removeBullet(Bullet b) {
		magazin.remove(b);
	}
	
	public Rectangle getRectangle() {
		return this.rect;
	}
	
	public int getKillCount() {
		return killCount;
	}
	
	public void kill() {
		killCount++;
	}
	
}
