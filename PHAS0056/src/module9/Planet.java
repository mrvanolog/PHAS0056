package module9;

/**
 * A class that defines physical properties of a planet
 * @author Ivan Popov
 *
 */
public class Planet {
	private String name;
	private int x, y, radius;
	private double mass, a, b, r, e, theta, period;
	/**
	 * Input the parameters of a planet
	 * @param name name of a planet 
	 * @param radius radius of the planet (arb. units)
	 * @param mass mass of a planet (masses of the Earth)
	 * @param a semi-major orbit of the planet (10^8 km)
	 * @param b semi-minor orbit of the planet (10^8 km)
	 * @param e eccentricity of the planet's orbit
	 * @param r current radius of the planet (10^8 km)
	 * @param period planet's year (Earth days)
	 */
	public Planet(String name, int radius, double mass, 
						double a, double e, double period) {	
		this.name = name;
		this.radius = radius;
		this.mass = mass;
		this.a = a;
		this.e = e;
		this.b = a*Math.sqrt(1-e*e);
		this.r = a;
		this.theta = 0;
		this.period = period;
		this.x = (int) a;  // current x co-ord of the planet
		this.y = 0;  // current y co-ord of the planet
	}
	/** Recalculates the position of the planet
	 *  @param dT time increment
	 */
	public void redrawPlanet(int dT) {
		// calculate the change in the angle
		// with the time increment
		double n = 2 * Math.PI / period;
		double dTheta = a*b*n*dT / (r*r);
		// recalculate the radius of the planet
		theta += dTheta;
		this.r = a*(1-e*e) / (1+e*Math.cos(theta));
		this.x = (int) (r * Math.cos(theta));
		this.y = (int) (r * Math.sin(theta));
		
	}
	/** Returns the name of the planet */ 
	public String getName() {
		return this.name;
	}
	/** Returns the radius of the planet */ 
	public int getRad() {
		return this.radius;
	}
	/** Returns the mass of the planet */ 
	public double getMass() {
		return this.mass;
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
