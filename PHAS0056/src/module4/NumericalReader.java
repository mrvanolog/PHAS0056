package module4;

import java.io.*;
import java.net.URL;

public class NumericalReader {
	
	// prompts the user to enter a string via the 
	// keyboard and stores the resulting String
	public static String getStringFromKeyboard() throws IOException {
		int CARRIAGE_RETURN = 10;
		int av;
		String s = "";
		
		System.out.println("Type something please!");
		
		try {
			do {
				av = System.in.read();
				char avc = (char) av;
				s += Character.toString(avc);
			}
			while (av != CARRIAGE_RETURN);
		}
		catch (java.io.IOException e) {
			System.out.println("getStringFromKeyboard(): " + e.getMessage());
		} 
		
		return s;
	}
	
	// takes the name of a URL as argument and
	// returns a BufferedReader object
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		return b; 
	}
	
	// creates a file called dataFile and initialises private variables
	void analysisStart(String dataFile) throws IOException {
		File outputfile = new File("N://Eclipse//mywork//" + dataFile);
		FileWriter fw = new FileWriter(outputfile);
		
		int minValue, maxValue, nValues, sumOfValues;
	}
	
	//
	void analyseData(String line) {
		
	}

	public static void main(String[] args) throws Exception {
		String s = getStringFromKeyboard();
		System.out.println(s);
		

	}

}