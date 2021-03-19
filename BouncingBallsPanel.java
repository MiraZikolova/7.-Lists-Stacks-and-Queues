package collectionsLinkedList7;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BouncingBallsPanel extends JPanel {
	private int delay = 10;
	private ArrayList<BouncingBall> list = new ArrayList<BouncingBall>();    //create an ArrayList of balls
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BouncingBallsPanel() {
		timer.start();
		//adding the MouseListener
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();         //razbirame na koi koordinati sme cuknali tochno
				int y = e.getY();
				
				//shte srawnim distanciqta mejdu tezi koordinati i koordinatite na wsqko topche w ArrayList
				for(int j = 0; j < list.size(); j++) {         //obhojda wsichki topcheta 
					BouncingBall nextBall = (BouncingBall)list.get(j);          
					double distance = BouncingBallsPanel.distance(x, y, nextBall.x, nextBall.y); //kak namirame razstoqnieto
					
					if ( nextBall.radius>=distance ) {
						list.remove(nextBall);  //trqbwa ni samo edna topka, na koqto da e cuknato i prekratqwame obhojbaneto
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

	public void add() {          //creates a new ball
		list.add(new BouncingBall());
	}

	public void subtract() {           //removes the last ball and then stops drawing it
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			BouncingBall ball = (BouncingBall) list.get(i); // Get a ball  //each and every ball from the list is drawn  //we use get(i) because of the Array List
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
		
		ArrayList<BouncingBall> ballsToRemove = new ArrayList<>();     //ArrayList sus stoinosti, koito iskame da premahnem posle
		//wlojeni cikli
		for(int i = 0; i < list.size(); i++) {           //obhojda wsichki topcheta
			BouncingBall ball = (BouncingBall)list.get(i);  //ball pazi topkata w momenta ; polzwame get, zashtoto e ArrayList
			for(int j = i + 1; j < list.size(); j++) {         //obhojda wsichki topcheta sled towa, na koeto se namirame sega
				BouncingBall nextBall = (BouncingBall)list.get(j);   //nextBall pazi wsichki topcheta sled ball
				int radiusSum = ball.radius + nextBall.radius;         
				double distance = BouncingBallsPanel.distance(ball.x, ball.y, nextBall.x, nextBall.y); //kak namirame razstoqnieto
				
				//kak da mahnem topche ot ArrayList, koito obhojdame w momenta
				if ( radiusSum>=distance ) {
					ballsToRemove.add(nextBall);  //shte natrupa topchetata, koito iskame da mahnem, no nqma da gi mahne predi da se izwurti cikula
			//poglushtane na topcheta
					ball.radius += nextBall.radius;
				}
			}
		}
		
		list.removeAll(ballsToRemove);
	
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