package module9;

import java.awt.Color;

/**
 * A class that defines physical properties of a planet
 * and methods to recalculate its position.
 * 
 * @author Ivan Popov
 * @version 6.66
 */
public class Planet {
	private String name;
	private Color color;
	private int x, y, radius;
	private double a, b, r, e, theta, period;
	/**
	 * Input the parameters of the planet
	 * @param name name of the planet 
	 * @param color colour of the planet (class Color)
	 * @param radius radius of the planet (arb. units)
	 * @param a semi-major orbit of the planet (A.U.)
	 * @param e eccentricity of the planet's orbit
	 * @param period planet's year (Earth days)
	 */
	public Planet(String name, Color color, int radius, 
						double a, double e, double period) {	
		this.name = name;
		this.color = color;
		this.radius = radius;
		this.a = a*200; // A.U. multiplied by 250 pixels
		this.e = e;
		this.b = this.a*Math.sqrt(1-e*e); // semi-minor orbit of the planet
		this.r = this.a; // current distance of the planet from the Sun
		this.theta = 0; // angle from the starting horizontal
		this.period = period;
		this.x = (int) this.a;  // current x co-ord of the planet
		this.y = 0;  // current y co-ord of the planet
	}
	/** Recalculates the position of the planet
	 *  @param dT time increment days
	 */
	public void redrawPlanet(int dT) {
		// calculate the change in the angle
		// with the time increment
		double n = 2 * Math.PI / period;
		double dTheta = a*b*n*dT / (r*r);
		// update the angle
		if(theta < 2*Math.PI) {
			theta += dTheta;
		}
		else {
			theta -= 2*Math.PI;
			theta += dTheta;
		}
		// recalculate the radius and co-ords of the planet
		this.r = a*(1-e*e) / (1+e*Math.cos(theta));
		this.x = (int) (r * Math.cos(theta));
		this.y = (int) (r * Math.sin(theta));
		
	}
	/** Returns the name of the planet */ 
	public String getName() {
		return this.name;
	}
	/** Returns the mass of the planet */ 
	public Color getColor() {
		return this.color;
	}
	/** Returns the radius of the planet */ 
	public int getRad() {
		return this.radius;
	}
	/** Returns the semi-major orbit of the planet */
	public double getA() {
		return this.a;
	}
	/** Returns the semi-minor orbit of the planet */
	public double getB() {
		return this.b;
	}
	/** Returns the radius of the planet */
	public double getR() {
		return this.b;
	}
	/** Returns the eccentricity of the planet */
	public double getE() {
		return this.b;
	}
	/** Returns the current angle from a of the planet */
	public double getTheta() {
		return this.b;
	}
	/** Returns the time period of the planet */
	public double getPeriod() {
		return this.b;
	}
	/** Returns the X co-ord of the planet */
	public int getX() {
		return this.x;
	}
	/** Returns the y co-ord of the planet */
	public int getY() {
		return this.y;
	}
}
