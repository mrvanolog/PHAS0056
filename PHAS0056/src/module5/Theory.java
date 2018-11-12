package module5;

// stores the power and returns the value 
// of theoretical function y = x^n
public class Theory {
	private double n;
	
	// sets the value of the power (n)
	public Theory(double pwr) {
		n = pwr;
	}
	
	// returns the value of the function y = x^n
	public double y(double x) {
		return Math.pow(x, n);
	}

}
