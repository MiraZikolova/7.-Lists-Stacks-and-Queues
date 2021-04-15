package stacksAndQueues8.homework;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;

class MultipleBallsPanel extends JPanel {
	private int delay = 10;
	//CHANGEE
	private PriorityQueue<MultipleBalls> queue = new PriorityQueue(Collections.reverseOrder());    //create a PriorityQueue, instead of an ArrayList of balls
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public MultipleBallsPanel() {
		timer.start();
		//adding the MouseListener
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();         //razbirame na koi koordinati sme cuknali tochno
				int y = e.getY();
				
				//shte srawnim distanciqta mejdu tezi koordinati i koordinatite na wsqko topche
				
				//CHANGEE
				for(MultipleBalls nextBall : queue) {         //obhojda wsichki topcheta 
         
					double distance = MultipleBallsPanel.distance(x, y, nextBall.x, nextBall.y); //kak namirame razstoqnieto
					
					if ( nextBall.radius >=distance ) {
						queue.remove(nextBall);  //trqbwa ni samo edna topka, na koqto da e cuknato i prekratqwame obhojbaneto
						break;                 //direktno mojem da mahnem topcheto, zashtoto prekratqwame cikula
					}
				}
				
			}
//unimplemented methods of MouseListener
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void add() {     //creates a new ball
	    //CHANGEE
		queue.offer(new MultipleBalls());

			
	}

	public void subtract() {        
		//CHANGEE
		if (queue.size() > 0)
			queue.poll(); // Remove the first ball from the queue
	}
//CHANGEE
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MultipleBalls ball : queue) {
			g.setColor(ball.color); // Set ball color - random
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		
		ArrayList<MultipleBalls> ballsToRemove = new ArrayList<>();    //ArrayList sus stoinosti, koito iskame da premahnem posle
		//wlojeni cikli
		for(MultipleBalls ball : queue) {  //obhojda wsichki topcheta
			if(ballsToRemove.contains(ball)) {
			for(MultipleBalls nextBall : queue) {         //obhojda wsichki topcheta sled towa, na koeto se namirame sega
				if(nextBall != ball) {
				int radiusSum = ball.radius + nextBall.radius;         
				double distance = MultipleBallsPanel.distance(ball.x, ball.y, nextBall.x, nextBall.y); //kak namirame razstoqnieto
				
				//kak da mahnem topche ot ArrayList, koito obhojdame w momenta
				if ( radiusSum>=distance ) {
					ballsToRemove.add(nextBall);  //shte natrupa topchetata, koito iskame da mahnem, no nqma da gi mahne predi da se izwurti cikula
			//poglushtane na topcheta
					ball.radius += nextBall.radius;
				
				}
			}
		}
		
		queue.removeAll(ballsToRemove);
			}
		}
			}
	

	public static double distance(int x1, int y1, int x2, int y2) {  //static method distance
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2))              //wrushta razstoqnieto mejdu dwe tochki
				+ Math.pow(Math.abs(y1-y2), 2);	      //abs - wrushta absoliutnata stoinost(modul)
	}
	
	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}

