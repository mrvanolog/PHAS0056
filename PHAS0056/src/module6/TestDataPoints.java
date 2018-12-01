package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

// creates an array of DataPoints and LabelledDataPoints
// and prints them all on the screen
public class TestDataPoints {
	
	// reads the values from the given URL and returns 
	// them in the form of an ArrayList of DataPoints
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		// initialise ArrayList object
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(); 
		double x, y, ey;
		String line = "";
		
		// read each line one by one and add Data Points to ArrayList
		while ((line = b.readLine()) != null) {
			try{
				Scanner s = new Scanner(line);

				// get three double values
				x = Double.parseDouble(s.next());
				y = Double.parseDouble(s.next());
				ey = Double.parseDouble(s.next());
				
				// check if data has label and create 
				// corresponding data point object
				if (s.hasNext() == true) {
					// append values to ArrayList
					data.add(new LabelledDataPoint(x, y, ey, s.next()));
				}
				else {
					// append values to ArrayList
					data.add(new DataPoint(x, y, ey));
				}	
				s.close();
			}
			catch (Exception e) {
				System.out.println("TestDataPoints.dataFromURL(): " + e);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		//TestDataPoints tdp = new TestDataPoints();
		
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		
		// create an ArrayList of DataPoints
		try {
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/"
										+ "3459/data/module6/module6-data.txt");
		}
		catch (IOException e) {
			System.out.println("TestDataPoints.main(): " + e);
		}
		
		for (DataPoint dtp : data) {
			System.out.println(dtp);
		}
	}

}
