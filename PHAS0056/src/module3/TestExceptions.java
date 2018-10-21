package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {
		
		//////Test Exceptions In Complex Class//////
		
		// create complex number
		Complex c1 = new Complex(1, -2);
		
		// test Exceptions in divide() method
		try {
			Complex.divide(c1, Complex.ZERO);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in normalised() method
		try {
			Complex.ZERO.normalised();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		//////Test Exceptions In ThreeVector Class//////
		
		// create two three vectors
		ThreeVector v1 = new ThreeVector(1, 4, 2);
		ThreeVector v2 = new ThreeVector(0, 0, 0);
		
		// test Exceptions in unitVector() method
		try {
			v2.unitVector();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in angle() static method
		try {
			ThreeVector.angle(v1, v2);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in angle() non-static method
		try {
			v1.angle(v2);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		//////Test Exceptions In FallingParticle Class//////
		
		// test Exceptions in constructor for nrgative mass
		try {
			new FallingParticle(-1, 2);  // set -ve mass
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in constructor for negative drag
		try {
			new FallingParticle(1, -2);  // set -ve mass
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// create new particle with mass 4.3 and drag 2.4
		FallingParticle p = new FallingParticle(4.3, 2.4);
		
		// test Exceptions in setH() method
		try {
			p.setH(-1);    // set -ve initial height
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in drop() method
		try {
			p.drop(0);    // set time increment equal to 0
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// test Exceptions in drop() method
		try {
			p.drop(-1);    // set -ve time increment
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
