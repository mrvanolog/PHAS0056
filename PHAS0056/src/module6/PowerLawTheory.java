package module6;

// returns x in a power of n
public class PowerLawTheory implements Theory {
	private double n;
	// input the value of te power n
	public PowerLawTheory(double n) {
		this.n = n;
	}
	// raise x to power n
	public double y(double x) {
		return Math.pow(x, n);
	}
	// returns string
	public String toString() {
		return "x^"+n;
	}
}
