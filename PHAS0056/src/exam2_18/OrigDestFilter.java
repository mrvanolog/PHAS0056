package exam2_18;

import java.util.ArrayList;
import java.util.List;

/**
 * Filters flights by a specified Origin and Destination airport
 * @author zcappop
 */
public class OrigDestFilter implements FlightFilter {
	private String origin, destination;
	
	/**
	 * @param origin code of the origin airport
	 * @param destination code of the destination airport
	 */
	public OrigDestFilter(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
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
			if(f.originCode.equals(origin)
					&& f.destCode.equals(destination)) {
				newFlights.add(f);
			}
		}
		
		return newFlights;
	}
}
