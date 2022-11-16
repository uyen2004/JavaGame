package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Obstacle extends Position {
	private int speed;
	private BufferedImage img;

	public Obstacle() {
		super();
		try {
			img = ImageIO.read(new File("C:\\Users\\uyen\\eclipse-workspace\\JavaGame\\src\\game\\invaders.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		int row = 3;
		int column = (Main.SCREEN_WIDTH) / (this.getWidth() + 5);
		int width = this.getWidth();
		int height = this.getHeight();
		int space = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < row; i++) {
			space = i * 10;
			int y = (i == 0) ? (i * height) : (i * height + space);
			for (int j = 0; j < column; j++) {
				Graphics2D graphic2d = (Graphics2D) g;
				graphic2d.setColor(Color.BLACK);
//				graphic2d.fillOval((j * width + 25), y + space, this.getHeight(), this.getWidth());
				graphic2d.drawImage(img, (j * width + 25), y + space, this.getHeight(), this.getWidth(), null);
			}

		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
