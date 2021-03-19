package collectionsDEMO7;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControlOne extends JPanel {
	private BallOne ball = new BallOne();
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");
	private JScrollBar jsbDelay = new JScrollBar();

	public BallControlOne() {
// Group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
// Add ball and buttons to the panel
		ball.setBorder(new javax.swing.border.LineBorder(Color.red));
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		ball.setDelay(jsbDelay.getMaximum());
		setLayout(new BorderLayout());
		add(jsbDelay, BorderLayout.NORTH);
		add(ball, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
// Register listeners
		jbtSuspend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.suspend();
			}
		});
		jbtResume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.resume();
			}
		});
		jsbDelay.addAdjustmentListener(new AdjustmentListener() {     //indicates when we move the scroll bar
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				System.out.println(jsbDelay.getMaximum());
				System.out.println(jsbDelay.getValue());
				ball.setDelay(jsbDelay.getMaximum() - e.getValue());    //the bigger getValue gets, the lower the value of delay
				
			}
		});
	}
}