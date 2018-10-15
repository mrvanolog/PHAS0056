package module3;

// allows to create a particle and model a drop under gravitational field
public class FallingParticle {
	
	// mass, drag, initial height, time, velocity and current position
	private double m, d, h, t, v, z;
	
	// gravitational constant accurate to 2 d.p.
	public static final double g = 9.81;
	
	// pass the mass of the particle and the drag
	public FallingParticle(double mass, double drag) throws Exception { 
		m = mass; d = drag; 
		if (mass < 0) {
			throw new Exception("FallingParticle(): Mass cannot be negative");
		}
	}
	
	// set the initial height
	public void setH(double height) throws Exception {
		h = height;
		if (h < 0) {
			throw new Exception("FallingParticle.setH(): Height cannot be negative");
		}
	}
	
	// get the value of the current vertical position
	public double getZ() {
		return z;
	}
	
	// set the velocity
	// POSITIVE IS UP & NEGATIVE IS DOWN
	public void setV(double vel) {
		v = vel;
	}
	
	// get the current velocity
	public double getV() {
		return v;
	}
	
	// get the time since the particle was dropped
	public double getT() {
		return t;
	}
	
	// recalculates velocity and position for a single time increment
	public void doTimeStep(double deltaT) {
		// calculate acceleration in the current state 
		double a = (d * v*v / m) - g;
		// update velocity
		v += a * deltaT;
		// update position
		z += v * deltaT;
	}
	
	// simulate the descent of a particle 
	// !!!YOU MUST SET VELOCITY BEFORE EACH DROP!!!
	// otherwise it will use the final velocity from the previous run
	public void drop(double deltaT) throws Exception {
		// initialize time and height
		t = 0;
		z = h;
		
		if (deltaT == 0) {
			throw new Exception("FallingParticle.drop(): Time increment can't be non-zero, "
					+ "otherwise the particle will freeze in time");
		}
		else if (deltaT < 0) {
			throw new Exception("FallingParticle.drop(): Time increment can't be negative, "
					+ "otherwise the particle will travel back in time");
		}
		
		while (z > 0) {
			doTimeStep(deltaT);
			// increase time by a time step
			t += deltaT;
		}
		
	}
	
}
