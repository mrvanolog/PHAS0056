package module2;

public class TestComplex {

	public static void main(String[] args) {
		// create twp complex numbers
		Complex c1 = new Complex(1, -2);
		Complex c2 = new Complex(-2, 1);

		System.out.println("The product c1*c2: " + Complex.multiply(c1, c2));
		System.out.println("The ratio c1/c2: " + Complex.divide(c1, c2));
		System.out.println("The product c1*I: " + Complex.multiply(c1, Complex.I));
		System.out.println("The ratio c1/ZERO: " + Complex.multiply(c1, Complex.ZERO));
		System.out.println("The product c1 * conjugate c1: " + Complex.multiply(c1, c1.conjugate()));
		System.out.println("The product c2 * conjugate c2: " + Complex.multiply(c2, c2.conjugate()));
	}

}
