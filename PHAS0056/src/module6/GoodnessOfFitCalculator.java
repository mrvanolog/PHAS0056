package module6;

import java.util.Collection;

// defines any necessary method to make the bestTheory method work
public interface GoodnessOfFitCalculator {
	double goodnessOfFit(Collection<DataPoint> data, Theory theory);
}
