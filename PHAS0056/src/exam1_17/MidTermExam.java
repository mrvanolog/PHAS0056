package exam1_17;

import java.io.BufferedReader;
import java.util.ArrayList;

public class MidTermExam {

	public static void main(String[] args) throws Exception {
		DataParser dp = new DataParser();
		
		// create an array of GWData objects
		BufferedReader br = dp.brFromFile("N:\\Eclipse\\git\\PHAS0056\\src\\exam1_17\\N_extent_v3.0.csv");
		ArrayList<GWData> data = dp.dataFromFile(br);
		
		// output the information
		int[]years = dp.analysePeriod(data);
		System.out.println("Lowest total ice extent: ");
		System.out.println(data.get(years[0]));
		System.out.println("\nLowest total ice area: ");
		System.out.println(data.get(years[1]));
		
		System.out.println("\nTotal number of measurements recorded in the file: "+dp.getTot());
		
		// perform calculations for each month
		for (int i = 1; i < 13; i++) {
			dp.analyseMonth(data, i);
		}
		
		// find the month with the highest and lowest ice average area
		double dropMax = -Double.MAX_VALUE, dropMin = Double.MAX_VALUE;
		int monthMax = 0, monthMin = 0;
		for (int i = 0; i < 12; i++) {
			if (dp.areaAve[i] < dropMin) { dropMin = dp.areaAve[i]; monthMin = i+1; }
			if (dp.areaAve[i] > dropMax) { dropMax = dp.areaAve[i]; monthMax = i+1; }
		}
		
		//System.out.println("\nMonth with the highest ice average area: "+monthMax);
		//System.out.println("Month with the lowest ice average area: "+monthMin);
		
		int year = dp.linearExtrap(dropMin, monthMin);
		System.out.println("The year when it is likely that there will "
				+ "no longer be any ice in the Arctic\n"
				+ "for the month with the lowest average area: "+year);
		
		year = dp.linearExtrap(dropMax, monthMax);
		System.out.println("The year when it is likely that there will "
				+ "no longer be any ice in the Arctic\n"
				+ "for the month with the highest average area: "+year);
	}

}
