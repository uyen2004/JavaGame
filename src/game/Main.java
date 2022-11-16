package game;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	final static int SCREEN_WIDTH = 500;
	final static int SCREEN_HEIGHT = 500;
	static GameHandler gamehandler;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		gamehandler = new GameHandler();
		panel.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + " " + y);
			}
		});
		panel.setSize(new Dimension(400, 400));
		panel.add(gamehandler);
		JFrame frame = new JFrame();
		frame.addKeyListener(gamehandler);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setVisible(true);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

}
