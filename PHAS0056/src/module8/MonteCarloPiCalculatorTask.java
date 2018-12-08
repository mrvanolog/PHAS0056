package module8;

import java.util.concurrent.*;
import java.util.Random;

public class MonteCarloPiCalculatorTask implements Callable<Double> {
	private final long n_points;
	// input the number of points for which Monte Carlo
	// simulation should be carried out for
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}
	// calculates an estimate of pi
	@Override
	public Double call() {
		Random rand = new Random();
		long n_in = 0;
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x*x + y*y;
			if (r2 < 1.0) ++n_in;
	 }
		return 4.0 * n_in / n_points;
	}	
}

