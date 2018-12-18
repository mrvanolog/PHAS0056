package module9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Panel with start, stop and exit buttons for Solar System
   animation.
 */
public class SolarSystemGuiPanel extends JPanel
							implements ActionListener {
	private SolarSystemPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	/** Create JPanel containing animation panel and buttons. */
	public SolarSystemGuiPanel() {
		super();
		setPreferredSize(new Dimension(800,800));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		animPanel = new SolarSystemPanel(200,200);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		add(animPanel);
		add(buttonPanel);
	}
	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}
	/** Start animation */
	public void start() { animPanel.start();}
	/** Stop animation */
	public void stop() { animPanel.stop();}
}
