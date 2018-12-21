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
	private final int delay = 25; // delay in ms between steps
	private int radSun = 50; // radius of the Sun 
	private int time = 0; // time elapsed since start
	private int dT = 1; // time increment
	
	/**
	 * Create panel with planets.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	SolarSystemPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		// create an array of planets
		planets.add(new Planet("Mercury", Color.RED, 10, 0.387, 0.2056, 88));
		planets.add(new Planet("Venus", Color.MAGENTA, 23, 0.723, 0.0068, 225));
		planets.add(new Planet("Earth", Color.BLUE, 25, 1, 0.0167, 365));
		planets.add(new Planet("Mars", Color.RED, 16, 1.524, 0.0934, 687));
		planets.add(new Planet("Comet", Color.PINK, 6, 2.1, 0.87, 800));
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
		// Display timer information
		g.setColor(Color.WHITE);
		g.drawString("Time elapsed from start - "+time+" Earth days.", 1, 12);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Draw the Sun
		g.setColor(Color.YELLOW);
		g.fillOval(-radSun/2, -radSun/2, radSun, radSun);
		// Redraw planets
		for(Planet planet : planets) {	
			int cor = planet.getRad()/2;  // planet's correction factor
			g.setColor(planet.getColor());  // planet's colour 
			// draw the planet
			g.fillOval(planet.getX()-cor,planet.getY()-cor,
								planet.getRad(), planet.getRad());
			// draw planet's label
			g.setColor(Color.WHITE);
			g.drawString(planet.getName(), planet.getX()-cor,
											planet.getY()-cor-4);
		}
	}
	
	/**
	 * This is called by the animation Timer object
	 * at regular intervals to recalculate the co-ords
	 * of the planets and update the display.
	 */
	public void actionPerformed(ActionEvent event) {
		time += dT; // update time elapsed
		 // recalculate the positions of the planets
		for(Planet planet : planets) {	
			planet.redrawPlanet(dT);
		}
		repaint();
	}
	
	/** Start the animation */
	public void start() { animationTimer.start();}
	
	/** Stop the animation */
	public void stop() { animationTimer.stop();}

}
