package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SpaceShip extends Position {

	private BufferedImage img;
	private boolean isShooting = false;

	public SpaceShip() {

	}

//	public SpaceShip(Bullet bullet) {
//		this.bullet = bullet;
//	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void paint(Graphics g) {
		// System.out.println(this.getX() + " " + this.getY() + " " + this.getHeight() +
		// " " + this.getWidth());
		// TODO Auto-generated method stub
		Graphics2D graphic2d = (Graphics2D) g;
		graphic2d.setColor(Color.GREEN);
		// graphic2d.fillRect(this.getX(), this.getY(), this.getHeight(),
		// this.getWidth());
		graphic2d.drawImage(img, this.getX(), this.getY(), this.getHeight(), this.getWidth(), null);
	}

	public boolean getIsShooting() {
		return isShooting;
	}

	public void setIsShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

}
