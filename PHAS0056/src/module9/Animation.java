package module9;

import javax.swing.*;

/**
 * Rotating square animation with start, stop and exit buttons.
 */
public class Animation {
	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation demo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(250,300);
				JPanel panel = new AnimationGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}