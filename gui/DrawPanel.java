package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel implements MouseListener,ActionListener {
	 private int bulletX = -10; 
	    private int gunY; 
		private int bulletY;
	    private boolean fire = false; 
public  int getBullety(){
return bulletY;
}
		public int getBulletx(){
			return bulletX;
		}

	List<DisplayObject> displayBuffer = new ArrayList<DisplayObject>();
	
	public DrawPanel() {
		 gunY = 500; 
		setBackground(Color.WHITE);
		addMouseListener(this);
	     setFocusable(true);

	        Timer timer = new Timer(10, this);
	        timer.start();

	        addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                switch (e.getKeyCode()) {
	                    case KeyEvent.VK_SPACE:
	                        if (!fire) { // Prevent multiple simultaneous shots
	                            bulletX = 120; // X position aligned with the gun's barrel
	                            fire = true;
	                        }
	                        break;
	                    case KeyEvent.VK_UP:
	                        gunY = Math.max(gunY - 5, 0); // Move up, prevent going off-screen
	                        break;
	                    case KeyEvent.VK_DOWN:
	                        gunY = Math.min(gunY + 5, getHeight() - 30); // Move down, prevent going off-screen
	                        break;
	                }
	                repaint();
	            }
	        });
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		   // Draw the gun
        g.setColor(Color.BLACK);
        g.fillRect(20, gunY, 100, 20); // Gun body
        g.fillRect(20, gunY, 20, 50); // Gun barrel

        // If firing is true, draw the bullet
        if (fire) {
            g.setColor(Color.RED);
			this.bulletY=gunY + 8;
            g.fillOval(bulletX,bulletY, 10, 4);
        }
		for(DisplayObject ob : displayBuffer) {
			ob.draw(g);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if (fire) {
	            bulletX += 15; // Speed of the bullet
	            if (bulletX > getWidth()) {
	                fire = false; // Stop the bullet once it goes off screen
	            }
	            repaint();
	        }
	    }

}
