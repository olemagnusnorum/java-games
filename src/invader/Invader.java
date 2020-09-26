package invader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Invader implements ActionListener, KeyListener,SaveLoad {
	
	public static Invader invader;
	
	private int width = 600;
	private int height = 600;
	
	public Renderer renderer;
	public Protector protector;
	public List<Enemy> enemies = new ArrayList<>();
	public List<Ammo> ammo = new ArrayList<>();
	public boolean right = false ,left = false, gameOver = false, hardcore = false;
	
	public Invader() {
		Timer timer = new Timer(15, this);
		renderer = new Renderer();
		protector = new Protector();
		for(int i = 0; i < 30; i++) {
			enemies.add(new Enemy());
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame();
		frame.setLocation(dim.width/2-width,dim.height/2-height);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("INVADER");
		frame.add(renderer);
		frame.addKeyListener(this);
		timer.start();
		
	}


	public void render(Graphics g)  {
		if(!gameOver) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			//g.setColor(Color.YELLOW);
			//g.setFont(new Font("Arial",10,20)); holder seg hvit en stud for en eller annen gurnn
			//g.drawString(protector.getMagazinSize()+"", 560, 560);
			g.setColor(Color.WHITE);
			protector.render(g);
			for(Enemy e: enemies) {
				e.render(g);
			}
			List<Ammo> remove = ammo.stream().filter(a -> a.getPosY() > 600).collect(Collectors.toList());
			remove.forEach(a -> ammo.remove(a));
			ammo.forEach(a -> a.render(g));
			
		}else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",1,50));
			g.drawString("GAME OVER", 150, 300);
			g.setFont(new Font("Arial",10,25));
			g.drawString("Your Score: "+protector.getKillCount(), 170, 360);
			int highScore;
			int prevHighScore = -1;
			prevHighScore = load("highscore.txt");
			
			if(prevHighScore < protector.getKillCount()) {
				highScore = protector.getKillCount();
			}else {
				highScore = prevHighScore;
			}
			g.drawString("High Score: "+highScore, 170, 400);
			save("highscore.txt", highScore);
			
		}
		
		
	}
	
	public void update() {
		protector.moveRight(right);
		protector.moveLeft(left);
		createAmmo();
		checkHit();
		getAmmo();
		gameOver();
		hardcore();
	}

	private void createAmmo() {
		double num;
		num = Math.random();
		if(num > 0.01) {
			if(ammo.size() < 1) {
				ammo.add(new Ammo());
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.update();
		renderer.repaint();
	}

	
	public static void main(String[] args) {
		Thread music = new Thread(new Music());
		invader = new Invader();
		music.start();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			left = true;
		}
		if(id == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(id == KeyEvent.VK_SPACE) {
			protector.shoot();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			left = false;
		}
		if(id == KeyEvent.VK_RIGHT) {
			right = false;
		}
		
	}
	
	public void checkHit() {
		List<Ammo> removeAmmo = new ArrayList<>();
		List<Enemy> removeEnemy = new ArrayList<>();
		List<Bullet> removeBullet = new ArrayList<>();
		for(Enemy e: enemies) {
			for(Bullet b: protector.getMagazin()) {
				if(e.getRectangle().intersects(b.getRectangle())) {
					e.damage();
					if(e.getStrength() <= 0) {
						removeEnemy.add(e);
						protector.kill();
					}
					removeBullet.add(b);
				}
			}
		}
		for(Enemy e: removeEnemy) {
			enemies.remove(e);
			enemies.add(new Enemy());
		}
		for(Bullet b: removeBullet) {
			protector.removeBullet(b);
		}
		
		for(Ammo a: ammo) {
			for(Bullet e: protector.getMagazin()) {
				if(e.getRectangle().intersects(a.getRectangle())) {
					removeAmmo.add(a);
				}
			}
		}
		removeAmmo.forEach(a -> ammo.remove(a));
	}
	
	public void gameOver() {
		for(Enemy e: enemies) {
			if(protector.getRectangle().intersects(e.getRectangle())) {
				gameOver = true;
			}
		}
	}
	public void getAmmo() {
		List<Ammo> remove = new ArrayList<>();
		for(Ammo a: ammo) {
			if(protector.getRectangle().intersects(a.getRectangle())) {
				protector.giveAmmo();
				remove.add(a);
				System.out.println("hei");
			}
		}
		remove.forEach(a -> ammo.remove(a));
	}
	
	public void hardcore() {
		if(!hardcore) {
			if(protector.getKillCount() > 30) {
				for(int i = 0; i < 50; i++) {
					enemies.add(new Enemy());
					hardcore = true;
				}
			}
		}
	}
}
