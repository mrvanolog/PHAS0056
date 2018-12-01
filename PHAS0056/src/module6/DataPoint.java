package module6;

import java.util.Scanner;

// allows to store and retrieve data x, y and error of y (ey)
public class DataPoint {
	protected double x, y, ey;
	
	// input values of x, y and ey
	public DataPoint(double x, double y, double ey) throws Exception {
		this.x = x;
		this.y = y;
		this.ey = ey;
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
	
	// returns a string 
	public String toString() {
		return "x = "+x+", y = "+y+" +/- "+ey; 
	}
}
