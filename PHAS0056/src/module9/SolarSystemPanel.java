package module9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
public class SolarSystemPanel extends JPanel implements ActionListener {
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private Timer animationTimer; // timer controlling frame rate
	private final int delay = 50; // delay in ms between steps
	//private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of shape on screen
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
		planets.add(new Planet("Mercury", 1, 12, 100));
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	/** Paint shape at appropriate angle. */
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
		g.setColor(Color.RED);
		g.fillOval(planets.get(0).getX()-cor,planets.get(0).getY()-cor,
							planets.get(0).getRad(), planets.get(0).getRad());
	}
	
	private Planet rotatePlanet(Planet planet) {
		
		
	}

	public void actionPerformed(ActionEvent event) {
		repaint();
	}
	
	/** Start the animation */
	public void start() {animationTimer.start();}
	
	/** Stop the animation */
	public void stop() {animationTimer.stop();}

}
