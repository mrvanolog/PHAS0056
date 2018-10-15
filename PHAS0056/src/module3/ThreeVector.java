package module3;

// allows creating 3 dimensional Cartesian vectors
public class ThreeVector {
	
	// member variables, co-ords of the 3 vector
	private double x, y, z;
	
	// pass in x, y, z co-ords of a vector
	public ThreeVector (double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}
	
	// calculates the magnitude of the vector
	public double magnitude() {
		// calculate square root of a sum of squared components
		double mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	
	// returns a unit vector in the same
	// direction as the original vector
	public ThreeVector unitVector () throws Exception {
		double mag = magnitude();
		if (mag == 0) {
			throw new Exception("ThreeVector.unitVector(): Can't find unit vector because the magnitude is 0");
		}
		
		// divide each component by a magnitude 
		ThreeVector unit = new ThreeVector(x / mag, y / mag, z / mag);
		return unit;
	}
	
	// returns the scalar product of two 3 vectors
	public static double scalarProduct(ThreeVector a, ThreeVector b) {
		// multiply and sum corresponding elements of each vector
		double dot = a.x*b.x + a.y*b.y + a.z*b.z;
		return dot;
	}
	
	// returns the vector product of two 3 vectors
	public static ThreeVector vectorProduct(ThreeVector a, ThreeVector b) {
		// multiply and subtract components of two vectors as described by a 'cross' product formula
		ThreeVector cross = new ThreeVector(a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
		return cross;
	}
	
	// returns a sum of two vectors
	public static ThreeVector add(ThreeVector a, ThreeVector b) {
		// sum corresponding elements of each vector
		ThreeVector sum = new ThreeVector(a.x + b.x, a.y + b.y, a.z + b.z);
		return sum;
	}
	
	// calculates angle in radians between two vectors
	public static double angle(ThreeVector a, ThreeVector b) throws Exception {
		double aMag = a.magnitude();  // calculate |a|
		double bMag = b.magnitude();  // calculate |b|
		if (aMag == 0 || bMag == 0) {
			throw new Exception("ThreeVector.angle(): The angle between (0,0,0) and any other vector is not defined");
		}
		
		// calculate cos of an angle using "a.b = |a||b|cos(a^b)" formula
		double ang = scalarProduct(a, b) / (aMag * bMag);
		ang = Math.acos(ang);       // calculate angle in radians
		return ang;
	}
	
	// returns the scalar product of two 3 vectors
	public double scalarProduct(ThreeVector a) {
		return scalarProduct(this, a);
	}
	
	// returns the vector product of two 3 vectors
	public ThreeVector vectorProduct(ThreeVector a) {
		return vectorProduct(this, a);
	}
	
	// returns a sum of two vectors
	public ThreeVector add(ThreeVector a) {
		return add(this, a);
	}
	
	// calculates angle between two vectors
	public double angle(ThreeVector a) throws Exception{
		return angle(this, a);
	}
	
	// outputs string
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")"; 
	}

}
