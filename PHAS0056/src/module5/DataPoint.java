package module5;

import java.util.Scanner;

// allows to store and retrieve data x, y and ey
public class DataPoint {
	private double x, y, ey;
	
	// input String containing values of x, y and ey
	public DataPoint(String line) throws Exception {
		double[] val = Parser(line);
		
		x = val[0];
		y = val[1];
		ey = val[2];
	}

	// extracts 3 double values from a string
	private static double[] Parser(String line) {
		double[] val = new double[3];
		
		try (
			Scanner s = new Scanner(line);
		){
			// assign values to corresponding variables
			val[0] = s.nextDouble();
			val[1] = s.nextDouble();
			val[2] = s.nextDouble();
		}
		catch (Exception e) {
			System.out.println("DataPoint constructor: " + e);
		}
		
		return val;
	}
	
	// x getter
	public double getX() {
		return this.x;
	}
	
	// y getter
	public double getY() {
		return this.y;
	}
	
	// ey getter
	public double getEY() {
		return this.ey;
	}
}
