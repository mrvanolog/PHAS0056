package exam2_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) throws IOException {
		// create ExamPart1 object to have 
		// an access to flights array
		ExamPart1 ep = new ExamPart1();
		// create filter objects
		OrigDestFilter odf = new OrigDestFilter("LHR", "ATH");
		DurationFilter df = new DurationFilter(240);
		CostFilter cf = new CostFilter(200);
		
		ArrayList<Airport> airports = new ArrayList<Airport>();
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
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
		
		// find flights from LHR to ATH that cost no more than £200
		ArrayList<Flight> flights1 = odf.filter(flights);
		flights1 = cf.filter(flights1);
		// print the flights found
		System.out.println("Flights from LHR to ATH that cost no more than £200:\n");
		ExamPart1.outputInfo(flights1, airports);
		System.out.println("-----------------------------------------------------\n");
		
		// find flights from LHR to ATH that's duration is no more than 4h
		ArrayList<Flight> flights2 = odf.filter(flights);
		flights2 = df.filter(flights2);
		// print the flights found
		System.out.println("Flights from LHR to ATH that's duration is no more than 4h:\n");
		ExamPart1.outputInfo(flights2, airports);
		System.out.println("-----------------------------------------------------\n");
		
		// find the quickest flight from LHR to ATH that cost no more than £200
		ArrayList<Flight> flights3 = odf.filter(flights);
		flights3 = cf.filter(flights3);
		flights3 = df.filter(flights3);
		// print the flights found
		System.out.println("The quickest flight from LHR to ATH that cost no more than £200:\n");
		ExamPart1.outputInfo(flights3, airports);
		System.out.println("-----------------------------------------------------");
	}

}
