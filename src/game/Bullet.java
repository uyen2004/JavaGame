package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends Position {

	public Bullet(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(3);
		this.setHeight(10);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphic2d = (Graphics2D) g;
		graphic2d.setColor(Color.BLACK);
		graphic2d.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	public void move(double speed) {
		int y = this.getY();
		y -= speed;
		this.setY(y);
	}

}
