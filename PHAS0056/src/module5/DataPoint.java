package module5;

import java.util.Scanner;

// allows to store and retrieve data x, y and ey
public class DataPoint {
	private double x, y, ey;
	
	// input a line with x, y and ey
	public DataPoint(String line) throws Exception {
		try (
				Scanner s = new Scanner(line);
		){
			// append values to corresponding ArrayLists
			x = s.nextDouble();
			y = s.nextDouble();
			ey = s.nextDouble();
		}
		catch (Exception e) {
			System.out.println("DataPoint constructor: " + e);
		}	
	}
	
	// x ArrayList getter
	public double getX() {
		return this.x;
	}
	
	// y ArrayList getter
	public double getY() {
		return this.y;
	}
	
	// ey ArrayList getter
	public double getEY() {
		return this.ey;
	}
}
