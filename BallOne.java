package collectionsDEMO7;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallOne extends JPanel {
	private int delay = 10;
// Create a timer with the specified delay in milliseconds
	private Timer timer = new Timer(delay, new TimerListener());
	private int x = 0;
	private int y = 0; // Current ball position

	private int dx = 2; // Increment on ball's x-coordinate
	private int dy = 2; // Increment on ball's y-coordinate
	private int radius = 5; // Ball radius

	public BallOne() {
		timer.start();
	}

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();         //calls for the paintComponent method
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);    //draw the panel itself
		g.setColor(Color.blue);     //the color of the ball
// Check boundaries
		if (x < 0 || x > getWidth())
			dx *= -1;
		if (y < 0 || y > getHeight())
			dy *= -1;
// Adjust ball position
		x += dx;         //change of coordinates
		y += dy;
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);     //grawing the ball
	}

	public void suspend() {
		timer.stop(); // Suspend timer
	}

	public void resume() {
		timer.start(); // Resume timer
	}

	public void setDelay(int delay) {    //this is how we can adjust the speed
		this.delay = delay;
		timer.setDelay(delay);
	}
}