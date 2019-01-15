package exam2_18;

import java.util.ArrayList;
import java.util.List;

/**
 * Filters flights by a cost no greater 
 * than some specified limit
 * @author zcappop
 */
public class CostFilter implements FlightFilter {
	private long limit;
	
	/**
	 * @param limit maximum allowed flight cost
	 */
	public CostFilter(long limit) {
		this.limit = limit;
	}
	
	/**
	 * Creates a list of filtered flight data
	 * @param flights array of flights information
	 */
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> flights) {
		// create an array for filtered flights
		ArrayList<Flight> newFlights = new ArrayList<Flight>();
		
		for(Flight f : flights) {
			if(f.price <= limit) {
				newFlights.add(f);
			}
		}
		
		return newFlights;
	}
}