package stacksAndQueues8.homework;

import java.awt.*;
import javax.swing.*;

public class MultipleBallsApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(new MultipleBallsControl());
		frame.setTitle("Bouncy");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}