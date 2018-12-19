package module9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** Dynamic model of the Solar System */
public class SolarSystem {
	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Solar Sytem Model");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(800,800);
				JPanel panel = new SolarSystemGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}
