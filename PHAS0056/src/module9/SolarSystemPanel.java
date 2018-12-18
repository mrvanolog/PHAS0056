package module9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * JPanel containing Solar System
 *  with planets orbiting the Sun 
 *  that can be stopped and started.
 */
public class SolarSystemPanel extends JPanel implements ActionListener {
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private Timer animationTimer; // timer controlling frame rate
	private final int delay = 10; // delay in ms between steps
	private int radSun = 60; // radius of the Sun 
	private int massSun = 333000; // mass of the Sun
		
	/**
	 * Create panel with planets.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	SolarSystemPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		// create an array of planets
		planets.add(new Planet("Earth", 20, 1, 310, 0.0167, 365));
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	/** Paint planets at appropriate positions. */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Draw the Sun
		g.setColor(Color.YELLOW);
		g.fillOval(-radSun/2, -radSun/2, radSun, radSun);
		// Redraw Mercury
		int cor = planets.get(0).getRad()/2;  // planet's correction factor
		g.setColor(Color.BLUE);
		g.fillOval(planets.get(0).getX()-cor,planets.get(0).getY()-cor,
							planets.get(0).getRad(), planets.get(0).getRad());
	}

	public void actionPerformed(ActionEvent event) {
		planets.get(0).redrawPlanet(1);
		repaint();
	}
	
	/** Start the animation */
	public void start() { animationTimer.start();}
	
	/** Stop the animation */
	public void stop() { animationTimer.stop();}

}
