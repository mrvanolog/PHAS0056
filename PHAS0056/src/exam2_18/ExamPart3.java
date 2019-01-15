package exam2_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExamPart3 {
	
	private static int id1 = 0, id2 = 0;
	private static long doubleTime = 0;
	private static double doublePrice = 0;
	
	public static void shortestDouble(ArrayList<Flight> flights, ArrayList<Airport> airports, 
														String origin, String destination) {
		double minPrice = Double.MAX_VALUE;
		
		// counters to store the index of the flight in the array
		int i = 0; int k = 0;
		// loop through all flights to find the needed pair
		for(Flight f : flights) {
			if(f.originCode.equals(origin)) {
				for(Flight j : flights) {
					if(f.destCode.equals(j.originCode) 
							&& j.destCode.equals(destination)) {
						
						// find departure and arrival time zones
						String fDepTZ = "", fArrTZ = "", jDepTZ = "", jArrTZ = "";
						// find the names and time zones of 
						// the airports from their codes
						for(Airport a : airports) {
							if(a.code.equals(f.originCode)) {
								fDepTZ = a.timeZone;
							}
							if(a.code.equals(f.destCode)) {
								fArrTZ = a.timeZone;
							}
							if(a.code.equals(j.originCode)) {
								jDepTZ = a.timeZone;
							}
							if(a.code.equals(j.destCode)) {
								jArrTZ = a.timeZone;
							}
						}
						
						// calculate combined time and make sure it doesn't take more than 24h
						doubleTime += ExamPart1.calcTime(f.depDateTime, fDepTZ, f.arrDateTime, fArrTZ);
						doubleTime += ExamPart1.calcTime(f.arrDateTime, fArrTZ, j.depDateTime, jDepTZ);
						doubleTime += ExamPart1.calcTime(j.depDateTime, jDepTZ, j.arrDateTime, jArrTZ);
						if(doubleTime < 1440) {
							double price = f.price + j.price;
							if(price <= minPrice) {
								doublePrice = price;
								minPrice = doublePrice;
								id1 = i;
								id2 = k;
							}
						}
					}
					k++;
				}
			}
			i++;
		}
	}


	public static void main(String[] args) throws IOException {
		ArrayList<Airport> airports = new ArrayList<Airport>();
		ArrayList<Flight> flights = new ArrayList<Flight>();
		DurationFilter df = new DurationFilter(1440);
		OrigDestFilter odf = new OrigDestFilter("LHR", "CPT");
		
		// create BufferedReader object for airports data
		BufferedReader br = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/undergrad"
									+ "/3459/exam-data/2017-18/airports.txt");
		String line;
		// create an array containing data about airports
		while((line = br.readLine()) != null) {
			airports.add(new Airport(line));
		}
		
		// create BufferedReader object for flights data
		br = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/undergrad"
							+ "/3459/exam-data/2017-18/flights.txt");
		// create an array containing data about flights
		while((line = br.readLine()) != null) {
			flights.add(new Flight(line));
		}
		
		shortestDouble(flights, airports, "LHR", "CPT");
		ArrayList<Flight> f = new ArrayList<Flight>();
		f = odf.filter(flights);
		f = df.filter(f);

		//f.add(flights.get(id1));
		//f.add(flights.get(id2));
		
		ExamPart1.outputInfo(f, airports);
		
		
		
	}

}
