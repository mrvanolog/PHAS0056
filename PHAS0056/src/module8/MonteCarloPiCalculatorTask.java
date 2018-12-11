package module8;

import java.util.concurrent.*;
import java.util.Random;

/** A class that performs Monte Carlo calculation.
 *  @author Ivan
 *  @version 1.0
 */
public class MonteCarloPiCalculatorTask implements Callable<Double> {
	private final long n_points;
	/** Input the number of points for which Monte Carlo
	 *  simulation should be carried out for
	 *  @param nPoints number of points for the simulation
	 */
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}
	/** Calculates an estimate of pi
	 */
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

