package module6;

import java.util.Collection;

// calculates Chi^2 for given theory and data
public class ChiSquared implements GoodnessOfFitCalculator {
	public ChiSquared() {}
	
	// calculates Chi^2 for a given theory and array of data points
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		double yTheory, chiSqr = 0;
		
		// go through each point and calculate Chi^2
		for (DataPoint pnt : data) {
			// calculate theoretical y
			yTheory = theory.y(pnt.getX());
			// add another term to Chi^2
			chiSqr += Math.pow((pnt.getY() - yTheory) / pnt.getEY(), 2);
		}
		
		return chiSqr;
	}
}
