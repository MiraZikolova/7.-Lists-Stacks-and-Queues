package stacksAndQueues8.homework;

import java.awt.Color;

class MultipleBalls implements Comparable<MultipleBalls>{
	int x = 0;
	int y = 0; // Current ball position
	int dx = 2; // Increment on ball's x-coordinate
	int dy = 2; // Increment on ball's y-coordinate

	int radius = (int) (Math.random() * 19) + 2;    //random radius between 2 and 20
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));  //random color
	@Override
	public int compareTo(MultipleBalls o) {
		// TODO Auto-generated method stub
		if(radius - o.radius > 0) {
			return 1;
		}else if(radius - o.radius < 0){
			return -1;
		}					
		return 0;         //if equal	}
}
}