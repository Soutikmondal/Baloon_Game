package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MyGUI extends JFrame implements ActionListener {

	static DrawPanel drawPanel = new DrawPanel();

	public MyGUI() {
		setTitle("My GUI");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Timer t = new Timer(10, this);
		t.start();
	}

	private void initComponents() {
		add(drawPanel);
	}

	public static void main(String[] args) {

		MyGUI gui = new MyGUI();
		gui.setVisible(true);
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int min = 1000;

			int max = drawPanel.getWidth() - 50;
			int randomNum = (int) (Math.random() * (max - min + 1)) + min;
			drawPanel.displayBuffer.add(new Circle(randomNum, 10, 20));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		drawPanel.repaint();

	}

}
