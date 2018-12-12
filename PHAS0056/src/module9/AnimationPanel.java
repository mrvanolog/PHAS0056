package module9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
public class AnimationPanel extends JPanel implements ActionListener {
	private Polygon shape; // shape to be displayed
	private final int delay = 50; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate
	
	/**
	 * Create panel with rotating shape.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	AnimationPanel(int width, int height, double rotationTime) {
		setPreferredSize(new Dimension(width,height));
		int size = Math.min(width, height) / 4;
		int[] xpts = {size,-size,-size,size};
		int[] ypts = {size, size,-size,-size};
		shape = new Polygon(xpts,ypts,4);
		delta = 2*Math.PI*delay/(rotationTime*1000);
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	/** Paint shape at appropriate angle. */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// Fill in background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Rotate and draw shape
		g.setColor(Color.RED);
		Polygon rotatedShape = rotatePolygon(shape, angle);
		g.fillPolygon(rotatedShape);
	}
	
	/**
	 * Private utility method to rotate the polygon.
	 * @param poly polygon to be rotated
	 * @param angle angle in radians by which to rotate polygon
	 * @return rotated polygon
	 */
	private static Polygon rotatePolygon(Polygon poly, double angle) {
		Polygon newPoly = new Polygon();
		for (int i = 0; i < poly.npoints; i++) {
			double x = poly.xpoints[i]*Math.cos(angle)+
					poly.ypoints[i]*Math.sin(angle);
			double y = poly.ypoints[i]*Math.cos(angle)-
					poly.xpoints[i]*Math.sin(angle);
			newPoly.addPoint((int) x, (int) y);
		}
		return newPoly;
	}
	
	/**
	 * This is called by the animation Timer object
	 * at regular intervals to rotate the shape and
	 * update the display.
	 */
	public void actionPerformed(ActionEvent event) {
		angle += delta;
		repaint();
	}
	
	/** Start the animation */
	public void start() {animationTimer.start();}
	
	/** Stop the animation */
	public void stop() {animationTimer.stop();}
}
