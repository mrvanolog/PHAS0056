package exam1_17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataParser {
	
	private int iceTot = 0;
	private double extTotMin, areaTotMin;
	private double[] areaMin = new double[12], yLast = new double[12];
	private int[] yearLast = new int[12]; 
	public double[] areaAve = new double[12], areaChangeAve = new double[12];
	private double[][] biggestDrop  = new double[12][5];
	
	// creates BufferedReader from a text file name
	public BufferedReader brFromFile(String fileName) throws IOException {
		FileReader f = new FileReader(fileName);
		BufferedReader b = new BufferedReader(f);
		
		return b;
	}
	
	public ArrayList<GWData> dataFromFile(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<GWData> data = new ArrayList<GWData>();
		String line = b.readLine();		
		
		// read each line one by one and add EarthquakeData objects to ArrayList
		while ((line = b.readLine()) != null) {
			GWData ice = new GWData(line);
			data.add(ice);

			iceTot++;
		}
		return data;
	}
	
	public int getTot() {
		return iceTot;
	}
	
	public double[] getAreaAve() {
		return areaAve;
	}
	
	// returns the array w/ index for the lowest extent[0] and area[1]
	public int[] analysePeriod(ArrayList<GWData> data) {
		areaTotMin = extTotMin = Double.MAX_VALUE;
		int[] index = new int[2];
		
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getExtent() < extTotMin && data.get(i).getExtent() != 0) {
				extTotMin = data.get(i).getExtent();
				index[0] = i;
			}
			
			if (data.get(i).getArea() < areaTotMin && data.get(i).getArea() != 0) {
				areaTotMin = data.get(i).getArea();
				index[1] = i;
			}
		}
		
		return index;
	}
	
	public void analyseMonth(ArrayList<GWData> data, int m) {
		// year w/ lowest area
		int index = 0;
		int[] iDrop = new int[5];
		double first, second = 0;
		double aveSum = 0, aveChangeSum = 0, monthTot = 0;
		
		// initialise areaMin and biggestDrop
		areaMin[m-1] = Double.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			biggestDrop[m-1][i] = Double.MAX_VALUE;
		}
		
		System.out.println("\nThe difference in area between each year and the previous " + 
				"year for month "+m+": ");
		// run through all values
		for (int i = 0; i < data.size(); i++) {
			// check for the correct month
			if (data.get(i).getMonth() == m) {			
				// assign area to second to find difference between
				// two consecutive months
				first = data.get(i).getArea();
				// check if data for a given year exists
				if (first == 0 || second == 0) {
					second = first;
				}
				else {
					// calculate and print the difference in area 
					// between each year and the previous year
					double n = first - second;
					aveChangeSum += n;
					int year = data.get(i).getYear() - 1;
					System.out.println(data.get(i).getYear()+" - "+year+": "+n);
					
					// find 5 years with the largest drop
					if (n < biggestDrop[m-1][0]) {
						biggestDrop[m-1][0] = n;
						iDrop[0] = data.get(i).getYear();
					}
					else if (n < biggestDrop[m-1][1]) {
						biggestDrop[m-1][1] = n;
						iDrop[1] = data.get(i).getYear();
					}
					else if (n < biggestDrop[m-1][2]) {
						biggestDrop[m-1][2] = n;
						iDrop[2] = data.get(i).getYear();
					}
					else if (n < biggestDrop[m-1][3]) {
						biggestDrop[m-1][3] = n;
						iDrop[3] = data.get(i).getYear();
					}
					else if (n < biggestDrop[m-1][4]) {
						biggestDrop[m-1][4] = n;
						iDrop[4] = data.get(i).getYear();
					}
					
					second = first;
				}
				
				yLast[m-1] = first;
				yearLast[m-1] = data.get(i).getYear();
				
				// calculate total ice area and num of measurements for this calendar month
				if (data.get(i).getArea() != 0) {
					aveSum += data.get(i).getArea();
					monthTot++;
					
					// find year with the lowest area
					if (data.get(i).getArea() < areaMin[m-1]) {
						areaMin[m-1] = data.get(i).getArea();
						index = i;
					}
				}
			}
		}
		// calculate average area
		areaAve[m-1] = aveSum / monthTot;
		areaChangeAve[m-1] = aveChangeSum / monthTot;
		
		System.out.println("\nYear with the lowest ice area for the month "+m+": "+data.get(index).getYear());
		
		System.out.println("\nFive years with the largest drop for month "+m+": ");
		for (int i = 0; i < 4; i++) {
			System.out.print(iDrop[i]+", ");
		}
		System.out.print(iDrop[4]+".\n");
	}
	
	// returns the year for which area is predicted to be 0
	public int linearExtrap(double drop, int m) { 
		// subtracts the average year change from the last value of area
		// while the latter is +ve, increments the year by 1
		while (yLast[m-1] > 0) {
			yLast[m-1] += drop;
			yearLast[m-1] ++;
		}
		
		return yearLast[m-1];
	}
}
