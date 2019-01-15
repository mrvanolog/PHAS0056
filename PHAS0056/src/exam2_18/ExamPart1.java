package exam2_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Outputs information about flights
 * @author zcappop
 *
 */
public class ExamPart1 {
	protected static ArrayList<Airport> airports = new ArrayList<Airport>();
	protected static ArrayList<Flight> flights = new ArrayList<Flight>();
	
	/** creates BufferedReader object from a URL
	 * 
	 * @param url string containing a url
	 * @return BufferedReader object
	 * @throws IOException
	 */
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	/**
	 * Calculates the duration of flight in minutes
	 * @param dateTime1 departure local date/time
	 * @param zone1 departure time zone
	 * @param dateTime2 arrival local date/time
	 * @param zone2 arrival time zone
	 * @return time duration of a flight in minutes
	 */
	public static long calcTime(String dateTime1, String zone1, 
										String dateTime2, String zone2) {
		LocalDateTime lt1 = LocalDateTime.parse(dateTime1);
		ZoneId z1 = ZoneId.of(zone1);
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
		
		LocalDateTime lt2 = LocalDateTime.parse(dateTime2);
		ZoneId z2 = ZoneId.of(zone2);
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
		
		return zt1.until(zt2, ChronoUnit.MINUTES);
	}
	
	/**
	 * Goes through every flight stored in the array
	 * and outputs all of the necessary information
	 * @param flights array of flights data
	 */
	public static void outputInfo(ArrayList<Flight> flights, ArrayList<Airport> airports) {
		for(Flight f : flights) {
			System.out.println("Flight code: "+f.flightCode);
			String origin = "", departure = "";
			String depTZ = "", arrTZ = "";
			// find the names and time zones of 
			// the airports from their codes
			for(Airport a : airports) {
				if(a.code.equals(f.originCode)) {
					origin = "Origin airport: "+a.name;
					depTZ = a.timeZone;
				}
				
				if(a.code.equals(f.destCode)) {
					departure = "Destiniation airport: "+a.name;
					arrTZ = a.timeZone;
				}
			}
				
			System.out.println(origin);
			System.out.println(departure);
			// calculate the length of the flight
			f.setDurationTime(calcTime(f.depDateTime, depTZ, 
												f.arrDateTime, arrTZ));
			System.out.println("Duration of the flight: "+f.durationTime+" minutes");
			System.out.println("Cost of the flight: £"+f.price);
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		// create BufferedReader object for airports data
		BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad"
									+ "/3459/exam-data/2017-18/airports.txt");
		String line;
		// create an array containing data about airports
		while((line = br.readLine()) != null) {
			airports.add(new Airport(line));
		}
		
		// create BufferedReader object for flights data
		br = brFromURL("http://www.hep.ucl.ac.uk/undergrad"
							+ "/3459/exam-data/2017-18/flights.txt");
		// create an array containing data about flights
		while((line = br.readLine()) != null) {
			flights.add(new Flight(line));
		}
		// output flight information
		outputInfo(flights, airports);
	}

}
