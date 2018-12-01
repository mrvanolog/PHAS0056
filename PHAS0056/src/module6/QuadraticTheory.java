package module6;

public class QuadraticTheory implements Theory{
	private double a, b, c;
	// input a, b and c parameters of a quadratic
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// calculate quadratic
	public double y(double x) {
		return a*x*x + b*x + c;
	}
	// return string
	public String toString() {
		return a+"x^2 + "+b+"x + "+c;
	}
}
