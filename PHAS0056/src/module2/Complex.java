package module2;

public class Complex {
	
	// member variables, real and imaginary components of a complex number (CN)
	private double r, i;
	
	// member static variables
	public static final Complex ONE = new Complex(1, 0); 
	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex I = new Complex(0, 1);
	
	// constructor
	public Complex (double a, double b) { r = a; i = b; }
	
	// method that returns real part of CN
	public double real() { return r; }
	
	// method that returns imaginary part of CN
	public double imag() {return i; }
	
	// method that returns modulus of CN
	public double modulus() { return Math.sqrt(r*r + i*i); }
	
	// method that returns angle in radians on the Argand diagram 
	// measured anticlockwise from the positive real axis
	public double angle() { return Math.atan(i / r); }
	
	// method that returns a complex conjugate of CN
	public Complex conjugate() { return new Complex(r, -i);	}
	
	// method that returns normalised complex number
	public Complex normalised() {
		double mod = modulus();
		return new Complex(r/mod, i/mod);
	}
	
	// method that checks whether two CN are the same and returns boolean
	public boolean equals(Complex c) {
		if (r == c.r && i == c.i) { return true; }
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
	
	// method that calculates the sum of two CNs
	public static Complex add(Complex a, Complex b) {
		return new Complex(a.r + b.r, a.i + b.i);
	}
	
	// method that returns the difference of two CNs
	public static Complex subtract(Complex a, Complex b) {
		return new Complex(a.r - b.r, a.i - b.i);
	}
	
	// method that returns the product of two CNs
	public static Complex multiply(Complex a, Complex b) {
		return new Complex(a.r*b.r - a.i*b.i, a.r*b.i + a.i*b.r);
	}
	
	// method that returns the retio of two CNs (a/b)
	public static Complex divide(Complex a, Complex b) {
		// find the conjugate of the bottom
		Complex cjgt = b.conjugate();
		
		// multiply top and bottom by conjugate of the bottom
		a = Complex.multiply(a, cjgt);
		b = Complex.multiply(b, cjgt);
		
		System.out.println(b);
		
		return new Complex(a.r / b.r, a.i / b.r);	
	}
	
	// output string
	public String toString() {
		return r + " + " + i + "i";
	}
	

}
