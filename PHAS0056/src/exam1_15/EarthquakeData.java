package exam1_15;

import java.util.Scanner;

// stores all the data about a single earthquake
public class EarthquakeData {
	
	private int year, month, day, hour, min; 
	private double sec, lat, lon, dep, eh1, eh2, az, ez, mag;
	private int id;
	
	public EarthquakeData(String line) {
		double[] val = parser(line);
		
		year = (int) val[0];
		month = (int)val[1];
		day = (int) val[2];
		hour = (int) val[3];
		min = (int) val[4];
		sec = val[5];
		lat = val[6];
		lon = val[7];
		dep = val[8];
		eh1 = val[9];
		eh2 = val[10];
		az = val[11];
		ez = val[12];
		mag = val[13];
		id = (int) val[14];
	}
	
	// extracts 15 double values from a string
	private static double[] parser(String line) {
		double[] val = new double[15];
		
		try (
			Scanner s = new Scanner(line);
		){
			// assign values to corresponding variables
			for (int i = 0; i < 15; i++) {
				val[i] = s.nextDouble();
			}
		}
		catch (Exception e) {
			System.out.println("EarthquakeData.parser(): " + e);
		}
		
		return val;
	}
	
	// year getter
	public double getYear() {
		return this.year;
	}
	
	// month getter
	public double getMonth() {
		return this.month;
	}
	
	// day getter
	public double getDay() {
		return this.day;
	}
	
	// hour getter
	public double getHour() {
		return this.hour;
	}
	
	// minute getter
	public double getMin() {
		return this.min;
	}
	
	// second getter
	public double getSec() {
		return this.sec;
	}
	
	// latitude getter
	public double getLat() {
		return this.lat;
	}
	
	// longitude getter
	public double getLon() {
		return this.lon;
	}
	
	// depth getter
	public double getDep() {
		return this.dep;
	}
	
	// eh1 getter
	public double getEh1() {
		return this.eh1;
	}
	
	// eh2 getter
	public double getEh2() {
		return this.eh2;
	}
	
	// az getter
	public double getAz() {
		return this.az;
	}
	
	// ez getter
	public double getEz() {
		return this.ez;
	}
	
	// magnitude getter
	public double getMag() {
		return this.mag;
	}
	
	// ID getter
	public double getID() {
		return this.id;
	}
}
