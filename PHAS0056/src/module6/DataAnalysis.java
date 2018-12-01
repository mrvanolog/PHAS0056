package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// analyses the data and finds the best theory for it
public class DataAnalysis {
	
	// finds the best theory for this data
	private static Theory bestTheory(Collection<DataPoint> data,
           Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		
		// goes through all of the theories
		// and finds the best one
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		
		// create an ArrayList of DataPoints
		try {
			data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/"
										+ "3459/data/module6/module6-data.txt");
		}
		catch (IOException e) {
			System.out.println("DataAnalysis.main(): " + e);
		}
		
		// create an array of theories
		ArrayList<Theory> theories = new ArrayList<Theory>();
		theories.add(new PowerLawTheory(2));
		theories.add(new PowerLawTheory(2.05));
		theories.add(new QuadraticTheory(1, 10, 0));
		
		// create a goodness of fit calculator object
		ChiSquared chi = new ChiSquared();
		
		// find the best theory for this data
		System.out.println("The best theory is: "+DataAnalysis.bestTheory(data, theories, chi));
	}

}
