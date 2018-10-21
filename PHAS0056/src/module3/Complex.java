package module3;

// allows creating complex numbers and provides tools to work with them
public class Complex {
	
	// member variables, real and imaginary components of a complex number (CN)
	private double realPart, imagPart;
	
	// member static variables
	public static final Complex ONE = new Complex(1, 0); 
	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex I = new Complex(0, 1);
	
	// input the real and imaginary parts of a CN
	public Complex (double a, double b) { realPart = a; imagPart = b; }
	
	// returns real part of CN
	public double real() { return realPart; }
	
	// returns imaginary part of CN
	public double imag() {return imagPart; }
	
	// returns modulus of CN
	public double modulus() { return Math.sqrt(realPart*realPart + imagPart*imagPart); }
	
	// returns angle in radians on the Argand diagram 
	// measured anticlockwise from the positive real axis
	public double angle() { return Math.atan2(imagPart, realPart); }
	
	// returns a complex conjugate of CN
	public Complex conjugate() { return new Complex(realPart, -imagPart);	}
	
	// returns normalised complex number
	public Complex normalised() throws Exception {
		double mod = modulus();
		if (mod == 0) {
			throw new Exception("Complex.normalised(): Cannot be normalised because the modulus is 0");
		}
		return new Complex(realPart/mod, imagPart/mod);
	}
	
	// checks whether two CN are the same and returns boolean
	public boolean equals(Complex c) {
		if (realPart == c.realPart && imagPart == c.imagPart) { return true; }
		else { return false; }	
	}
	
	// returns the real and imaginary parts of CN when modulus and argument (in radians) are given
	public Complex setFromModulusAngle(double mag, double ang) {
		// find real part of CN 
		double a = mag / Math.sqrt(1 + Math.tan(ang)*Math.tan(ang));
		// find imaginary part of CN
		double b = (mag * Math.tan(ang)) / Math.sqrt(1 + Math.tan(ang)*Math.tan(ang));
		
		return new Complex(a, b);		
	}
	
	// calculates the sum of two CNs
	public static Complex add(Complex a, Complex b) {
		return new Complex(a.realPart + b.realPart, a.imagPart + b.imagPart);
	}
	
	// returns the difference of two CNs
	public static Complex subtract(Complex a, Complex b) {
		return new Complex(a.realPart - b.realPart, a.imagPart - b.imagPart);
	}
	
	// returns the product of two CNs
	public static Complex multiply(Complex a, Complex b) {
		return new Complex(a.realPart*b.realPart - a.imagPart*b.imagPart, a.realPart*b.imagPart + a.imagPart*b.realPart);
	}
	
	// returns the retio of two CNs (a/b)
	public static Complex divide(Complex a, Complex b) throws Exception {
		// find the conjugate of the bottom
		Complex cjgt = b.conjugate();
		
		// multiply top and bottom by conjugate of the bottom
		a = Complex.multiply(a, cjgt);
		b = Complex.multiply(b, cjgt);
		
		if (b.realPart == 0) {
			throw new Exception("Complex.divide(): Cannot be normalised because the denumenator is 0");
		}
		
		return new Complex(a.realPart / b.realPart, a.imagPart / b.realPart);	
	}
	
	// output string
	public String toString() {
		if (imagPart >= 0) { return realPart + "+" + imagPart + "i"; }
		else { return realPart + "-" + -imagPart + "i"; }
	}
	

}
