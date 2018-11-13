package exam1_17;

import java.util.Scanner;

public class GWData {
	private int year, month;
	private String type, region;
	private double extent, area;
	
	public GWData (String line) {
		int valI[] = parserInt(line);
		year = valI[0];
		month = valI[1];
		
		String valS[] = parserString(line);
		type = valS[0];
		region = valS[1];
		
		double valD[] = parserDouble(line);
		extent = valD[0];
		area = valD[1];
	}
	
	// parses int data
	public int[] parserInt(String line) {
		int[] val = new int[2];
		
		try (
			Scanner s = new Scanner(line).useDelimiter(",\\s*");
		){
			// assign values to corresponding variables
			val[0] = s.nextInt();
			if (val [0] == -9999) { val[0] = 0;	}
			val[1] = s.nextInt();
			if (val [1] == -9999) { val[1] = 0; }
		}
		catch (Exception e) {
			System.out.println("GWData.parserInt(): " + e);
		}
		
		return val;
	}
	
	// parses String data
	public String[] parserString(String line) {
		String[] val = new String[2];
		
		try (
			Scanner s = new Scanner(line).useDelimiter(",\\s*");
		){
			s.next(); s.next();
			// assign values to corresponding variables
			val[0] = s.next();
			if (val [1] == "-9999") { val[1] = ""; }
			val[1] = s.next();
			if (val [1] == "-9999") { val[1] = ""; }
		}
		catch (Exception e) {
			System.out.println("GWData.parserString(): " + e);
		}
		
		return val;
	}

	// parses Double data
	public double[] parserDouble(String line) {
		double[] val = new double[2];
		
		try (
			Scanner s = new Scanner(line).useDelimiter(",\\s*");
		){
			s.next(); s.next(); s.next(); s.next();
			// assign values to corresponding variables
			val[0] = s.nextDouble();
			if (val [0] == -9999) { val[0] = 0;	}
			val[1] = s.nextDouble();
			if (val [1] == -9999) { val[1] = 0;	}
		}
		catch (Exception e) {
			System.out.println("GWData.parserDouble(): " + e);
		}
		
		return val;
	}
	
	// getter methods
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public double getExtent() {
		return this.extent;
	}
	
	public double getArea() {
		return this.area;
	}
	
	public String toString() {
		return this.month+" "+this.year+". Extent: "+this.extent+", Area: "+this.area+",\n"
				+"Data-type: "+this.type+", Hemisphere: "+this.region+"."; 
	}
	
}
