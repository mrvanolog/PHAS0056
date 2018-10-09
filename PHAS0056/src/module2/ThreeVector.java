package module2;

public class ThreeVector {
	
	// member variables, co-ords of the 3 vector
	private double x, y, z;
	
	// constructor
	public ThreeVector (double a, double b, double c) {
		x = a; y = b; z = c;
	}
	
	// method that calculates the magnitude of the vector
	public double magnitude() {
		// calculate square root of a sum of squared components
		double mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	
	// method that returns a unit vector in the same
	// direction as the original vector
	public ThreeVector unitVector () {
		double mag = magnitude();
		// divide each component by a magnitude 
		ThreeVector unit = new ThreeVector(x / mag, y / mag, z / mag);
		return unit;
	}
	
	// static method that returns the scalar product of two 3 vectors
	public static double scalarProduct(ThreeVector a, ThreeVector b) {
		// multiply and sum corresponding elements of each vector
		double dot = a.x*b.x + a.y*b.y + a.z*b.z;
		return dot;
	}
	
	// static method that returns the vector product of two 3 vectors
	public static ThreeVector vectorProduct(ThreeVector a, ThreeVector b) {
		// multiply and subtract components of two vectors as described by a 'cross' product formula
		ThreeVector cross = new ThreeVector(a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
		return cross;
	}
	
	// static method that returns a sum of two vectors
	public static ThreeVector add(ThreeVector a, ThreeVector b) {
		// sum corresponding elements of each vector
		ThreeVector sum = new ThreeVector(a.x + b.x, a.y + b.y, a.z + b.z);
		return sum;
	}
	
	// static method that calculates angle between two vectors
	public static double angle(ThreeVector a, ThreeVector b) {
		// calculate cos of an angle using "a.b = |a||b|cos(a^b)" formula
		double ang = scalarProduct(a, b) / (a.magnitude() * b.magnitude());
		ang = Math.acos(ang);       // calculate angle in radians
		return ang;
	}
	
	// non-static method that returns the scalar product of two 3 vectors
	public double scalarProduct(ThreeVector a) {
		return scalarProduct(this, a);
	}
	
	// non-static method that returns the vector product of two 3 vectors
	public ThreeVector vectorProduct(ThreeVector a) {
		return vectorProduct(this, a);
	}
	
	// non-static method that returns a sum of two vectors
	public ThreeVector add(ThreeVector a) {
		return add(this, a);
	}
	
	// non-static method that calculates angle between two vectors
	public double angle(ThreeVector a) {
		return angle(this, a);
	}
	
	// output string
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")"; 
	}

}
