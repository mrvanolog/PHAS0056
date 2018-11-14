package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class MidTermExam {

	public static void main(String[] args) throws IOException {
		// create DataAnalyser object
		DataAnalyser da = new DataAnalyser();
		

		// create BufferedReader object
		BufferedReader br = da.brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
									+ "3459/exam-data/NFL2012OffensiveStats.txt");
		
		// creare an array of NFLData objects
		ArrayList<NFLData> data = da.dataFromURL(br);
		
		// print the total number of players
		System.out.println("The total number of players recorded in a file: "+da.getTot());
		
		// print the players with the most Rushing Yards and All Purpose Yards
		da.analyse(data);
		
		System.out.println(da.getTeams(data));

	}

}
