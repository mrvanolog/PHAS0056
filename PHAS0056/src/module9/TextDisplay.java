package module9;

import javax.swing.*;
/**
 * Simple Swing application using JLabel to display text.
 */
public class TextDisplay {
	/** Create and display a JFrame containing a JLabel. */
	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("Swing example");
		// Exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello Java programmers!");
		frame.add(label); // Add label to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
	}
	
	/** Call method to create and display GUI. */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});
	}
}