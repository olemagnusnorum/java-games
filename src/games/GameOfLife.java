package games;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameOfLife implements ActionListener {
	
	public static GameOfLife game;
	
	public Renderer renderer;
	
	public LifeLogic2 logic;
	
	private int lenght = 600;
	private int height = 620;
	
	public GameOfLife() {
		Timer timer = new Timer(100, this);
		JFrame frame = new JFrame();
		renderer = new Renderer();
		logic = new LifeLogic2(60);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-350, dim.height/2-300);
		frame.setSize(lenght, height);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game Of Life");
		frame.setResizable(false);
		frame.add(renderer);
		timer.start();
		
	}
	

	public void render(Graphics g) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < logic.getSize(); i++) {
			y = (lenght/logic.getSize())*i;
			for(int a = 0; a < logic.getSize(); a++) {
				x = (lenght/logic.getSize())*a;
				if(logic.cells[i][a] == 1) {
					g.setColor(Color.white);
				}
				else {
					g.setColor(Color.black);
				}
				g.fillRect(x, y, lenght/logic.getSize(), lenght/logic.getSize());
			}
		}
		
	}

	public void update() {
		logic.simulate();
		System.out.println(logic);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		renderer.repaint();
	}
	

	
	
	public static void main(String[] args) {
		game = new GameOfLife();
	}









	
}
