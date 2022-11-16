package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameHandler extends JPanel implements KeyListener, Runnable {
	private Bullet bullet;
	private static SpaceShip spaceship = new SpaceShip();
	private static Obstacle obstacle = new Obstacle();
	private BufferedImage img;
	private boolean shot = false;

	public GameHandler() {
		this.initGame();
	}

	public void initGame() {
		this.initSpaceShip();
	}

	public void initSpaceShip() {
		spaceship.setX((Main.SCREEN_WIDTH) / 2);
		spaceship.setY(420);
		try {
			img = ImageIO.read(new File("C:\\Users\\uyen\\eclipse-workspace\\JavaGame\\src\\game\\spaceship.png"));
			spaceship.setImg(img);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		spaceship.paint(g);
		obstacle.paint(g);
		if (shot) {
			bullet.paint(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int spaceshipX = spaceship.getX();
		int spaceshipY = spaceship.getY();
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			spaceshipY -= 5;
			spaceship.setY(spaceshipY);
			moveHandlerVertical(spaceship);
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			spaceshipY += 5;
			spaceship.setY(spaceshipY);
			moveHandlerVertical(spaceship);
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			spaceshipX -= 5;
			spaceship.setX(spaceshipX);
			moveHandlerHorizontal(spaceship);
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			spaceshipX += 5;
			spaceship.setX(spaceshipX);
			moveHandlerHorizontal(spaceship);
			repaint();
			break;
		case KeyEvent.VK_SPACE:
			if (bullet == null) {
				spaceship.setIsShooting(true);
				if (spaceship.getIsShooting()) {
					bullet = new Bullet(spaceship.getX() + (spaceship.getHeight() / 2), spaceship.getY());
//					spaceship.setIsShooting(true);
					System.out.println(bullet.getY());
					shot = true;
				}
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			spaceship.setIsShooting(false);
			if (bullet.getY() < 0) {
				bullet = null;
				shot = false;
			}
		}

	}

	public void moveHandlerHorizontal(SpaceShip spaceship) {
		if (spaceship.getX() == 0) {
			spaceship.setX(Main.SCREEN_WIDTH);
		} else if (spaceship.getX() == Main.SCREEN_WIDTH) {
			spaceship.setX(0);
		}
	}

	public void moveHandlerVertical(SpaceShip spaceship) {
		if (spaceship.getY() < 0) {
			spaceship.setY(0);
		} else if (spaceship.getY() > 420) {
			spaceship.setY(420);
		}
	}

	public void shoot() {
		if (shot) {
			bullet.move(1);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				shoot();
				Thread.sleep(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
