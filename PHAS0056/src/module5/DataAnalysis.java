package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

// compares the data from the given URL 
// with the functions y = x^2 and y = x^4 and 
// reports which of these better describes the data.
public class DataAnalysis {
	
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
		String line = "";
		
		// read each line one by one and add values to ArrayList
		while ((line = b.readLine()) != null) {
			try{
				DataPoint dpt = new DataPoint(line);
				// append values to ArrayList using "getter" methodss
				data.add(dpt);
			}
			catch (Exception e) {
				System.out.println("DataAnalysis.dataFromURL(): " + e);
			}
		}
		
		return data;
	}
	
	// calculates the value of Chi^2
	public static double goodnessOfFit(Theory curve, ArrayList<DataPoint> data) {
		double yTheory, chiSqr = 0;
		
		// go through each point and calculate Chi^2
		for (DataPoint pnt : data) {
			// calculate theoretical y
			yTheory = curve.y(pnt.getX());
			// add another term to Chi^2
			chiSqr += Math.pow((pnt.getY() - yTheory) / pnt.getEY(), 2);
		}
		
		return chiSqr;
	}
	
	// creates two curves y = x^2 and y = x^4, calculates
	// Chi^2 and reports which better describes the data
	public static void main(String[] args) throws IOException {
		// create two Theory objects for y = x^2 and y = x^4
		Theory curve1 = new Theory(2);
		Theory curve2 = new Theory(4);
		
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		
		// create an ArrayList of DataPoints
		try {
			data = dataFromURL("http://www.hep.ucl.ac.uk/"
										+ "undergrad/3459/data/module5/module5-xy.txt");
		}
		catch (IOException e) {
			System.out.println("DataAnlysis.main(): " + e);
		}
		
		double chiSqr1 = goodnessOfFit(curve1, data);
		double chiSqr2 = goodnessOfFit(curve2, data);
		
		System.out.println("Chi^2 for y = x^2: " + chiSqr1);
		System.out.println("Chi^2 for y = x^4: " + chiSqr2);
		
		System.out.println("Chi^2 for y = x^2 is very large. Ideally the value of Chi^2 should be as close "
				+ "to 1 as possible, therefore y = x^4 describes the data much better.");

	}

}
