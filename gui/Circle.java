package gui;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class Circle extends Thread implements DisplayObject {

	int x, y, r;
	int x1, x2;
	int y1, y2;
	boolean flag = true;

	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		start();
	}

	@Override
	public void run() {

		int min = 10;
		int max = 50;
		int randomNum = (int) (Math.random() * (max - min + 1)) + min;

		while (true) {
			int xb = MyGUI.drawPanel.getBulletx();
			int yb = MyGUI.drawPanel.getBullety();

			y++;

			if (flag&&xb <= x1 && xb >= x2 && yb >= y && yb <= y + 80) {
				flag = false;
				SwingUtilities.invokeLater(() -> {
					DrawPanel.incrementScore();
				});
				MyGUI.drawPanel.repaint();

			}
			try {
				Thread.sleep(randomNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		// g.drawOval(50, 100, 100, 100);
		if (flag) {

			g.drawLine(x, y, x + 50, y + 50);
			this.x1 = x + 50;
			this.y1 = y;
			g.drawLine(x, y, x + 30, y);
			g.drawLine(x + 30, y, x - 30, y + 50);
			this.y2 = y + 50;
			this.x2 = x - 30;
			int arcWidth = 80;
			int arcHeight = 50;

			int startAngle = 180;

			int arcAngle = 180;

			g.drawArc(x - 30, y + 24, arcWidth, arcHeight, startAngle, arcAngle);

		}

	}

}
