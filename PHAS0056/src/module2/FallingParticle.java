package module2;

public class FallingParticle {
	
	// mass, drag and initial height 
	private double m, d, h;
	
	// time, velocity and current position
	private static double t, v, z;
	
	// gravitational constant accurate to 2 d.p.
	public final double g = 9.81;
	
	// constructor
	public FallingParticle(double mass, double drag) { m = mass; d = drag; }
	
	// set the initial height
	public void setH(double height) {
		h = height;
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
	public void drop(double deltaT) {
		// initialize time and height
		t = 0;
		z = h;
		
		while (z > 0) {
			doTimeStep(deltaT);
			// increase time by a time step
			t += deltaT;
		}
		
	}
	
}
