package exam1_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

// creates a single array of EarthquakeData objects and analyses them
public class DataParser {
	
	private double depthMax, depthAccMax;
	private int depthMaxID, depthAccMaxID, monthTot;
	private ArrayList<EarthquakeData> values;
	
	// initialise counter for the total number of earthquakes
	private static int earthTot = 0;
	
	// creates an array of EarthquakeData objects
	public DataParser(String url) throws IOException {
		BufferedReader br = brFromURL(url);
		
		values = dataFromURL(br);		
	}
	
	// creates BufferedReader object from a URL
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	public static ArrayList<EarthquakeData> dataFromURL(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<EarthquakeData> data = new ArrayList<EarthquakeData>();
		String line = "";
		
		// read each line one by one and add EarthquakeData objects to ArrayList
		while ((line = b.readLine()) != null) {
			// check that the line doesn't have any letters in it 
			if (!(line.isEmpty()) && !(Character.isLetter(line.charAt(0)))) {
				EarthquakeData quake = new EarthquakeData(line);
				data.add(quake);
			
				earthTot++;
			}
		}
		return data;
	}
	
	// get the total number of earthquakes
	public double getTot() {
		return this.earthTot;
	}
	
	// get the total number of earthquakes in a month
	public double getMonthTot() {
		return this.monthTot;
	}
	
	// get the total number of earthquakes in a month
	public double getDepthID() {
		return this.depthMaxID;
	}
	
	// get the total number of earthquakes in a month
	public double getDepthAccID() {
		return this.depthAccMaxID;
	}
	
	// analyses all earthquakes for a given month
	public void analyseMonth(int monthNum) {
		depthMax = -Double.MAX_VALUE;
		depthAccMax = Double.MAX_VALUE;
		monthTot = 0;
		int i = 0;
		
		// find an element index of the first earthquake of this month
		while(values.get(i).getMonth() != monthNum) {
			i++;
		}
		
		// analyse each earthquake in the month
		while(values.get(i).getMonth() == monthNum && i < earthTot) {
			// check for the deepest earthquake
			if (values.get(i).getDep() > depthMax) {
				depthMax = values.get(i).getDep();
				depthMaxID = i;
			}
			
			// check for the earthquake whose depth is most accurately known
			if (Math.abs(values.get(i).getEz()) < depthAccMax) {
				depthAccMax = Math.abs(values.get(i).getEz());
				depthAccMaxID = i;
			}
			
			// update the number of earthquakes in the month
			monthTot++;
			i++;
		}
	}
	
	public void stringFromID(int num) {
		System.out.println((int) values.get(num).getYear()+"."+(int) values.get(num).getMonth()+"."+(int) values.get(num).getDay()+", "+
				(int) values.get(num).getHour()+":"+(int) values.get(num).getMin()+":"+values.get(num).getSec()+",\n"+
				"Latitude: "+values.get(num).getLat()+", Longitude: "+values.get(num).getLon()+", Depth: "+
				values.get(num).getDep()+",\n"+"Horizontal major axis: "+values.get(num).getEh1()+
				", Horizontal minor axis: "+values.get(num).getEh2()+", Azimuth: "+values.get(num).getAz()+
				"\nError in depth: "+values.get(num).getEz()+", Magnitude of the earthquake: "+
				values.get(num).getMag()+", ID: "+(int) values.get(num).getID());
	}
	
		
	

}
