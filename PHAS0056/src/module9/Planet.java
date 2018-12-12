package module9;

/**
 * A class that defines physical properties of a planet
 * @author Ivan Popov
 *
 */
public class Planet {
	private String name;
	private int mass, radius, orbit, x, y;
	/**
	 * Input the parameters of a planet
	 * @param name name of a planet 
	 * @param mass mass of a planet
	 * @param radius radius of the planet
	 * @param orbit distance of a planet from the Sun
	 */
	public Planet(String name, int mass, int radius, int orbit) {	
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.orbit = orbit;
		this.x = orbit;  // current x co-ord of the planet
		this.y = 0;  // current y co-ord of the planet
	}
	
	/** Returns the name of the planet */ 
	public String getName() {
		return this.name;
	}
	/** Returns the mass of the planet */ 
	public int getMass() {
		return this.mass;
	}
	/** Returns the radius of the planet */
	public int getRad() {
		return this.radius;
	}
	/** Returns the orbit of the planet */
	public int getOrb() {
		return this.orbit;
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
