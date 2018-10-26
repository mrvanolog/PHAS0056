package module4;

import java.io.*;
import java.util.Scanner;
import java.net.URL;

public class NumericalReader {
	
	private static double minValue, maxValue, sumOfValues;
	private static int nValues;
	
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
		//File outputfile = new File("D:\\Eclipse\\mywork\\" + dataFile);
		File outputfile = new File("C:\\Users\\Ivan\\Documents\\Java\\mywork\\"+dataFile+".txt");
		outputfile.createNewFile();
		
		// initialise buffered reader to read the text from URL
		NumericalReader nr = new NumericalReader();
		BufferedReader br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		
		// initialise buffered writer to write into newly created file
		FileWriter f = new FileWriter(outputfile);
		BufferedWriter b = new BufferedWriter(f);
		PrintWriter pw = new PrintWriter(b);
		
		// write into a file
		String line;
		while ((line=br.readLine()) != null) {
			pw.println(line);
			System.out.println(line);
		}
		pw.close();
		
		
		// initialise private variables
		minValue = Double.MAX_VALUE; 
		maxValue = -Double.MAX_VALUE;
		nValues = 0;
		sumOfValues = 0;
	}
	
	//
	void analyseData(String line) {
		Scanner s = new Scanner(line);
		
		while (s.hasNext()) {
			String token = s.next();
			if (token.isEmpty()) { s.nextLine(); }
			//else if (token)
			
			try {
				double x = Double.parseDouble(token);
				
				if (x > maxValue) { maxValue = x; }
				if (x < minValue) { minValue = x; }
				sumOfValues += x;
				nValues++;
			} catch (NumberFormatException e) {
				// Ignore anything that is not a number!
			}
		}
	}
	
	void analysisEnd() {
		System.out.println("The maximum value: " + maxValue);
		System.out.println("The minimum value: " + minValue);
		System.out.println("The average value: " + sumOfValues/nValues);
		System.out.println("The number of values: " + nValues);
	}

	public static void main(String[] args) throws Exception {
		
		//String saveDir = NumericalReader.getStringFromKeyboard();
		
		String dataFile = "NumericalReaderFile";
		//String saveFile = (saveDir + File.separator + dataFile);
		
		NumericalReader nr = new NumericalReader();
		BufferedReader br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		String line = "";
		
		nr.analysisStart(dataFile);    // initialize minValue etc.
		while ((line = br.readLine()) != null) {
		  nr.analyseData(line);    // analyze lines, check for comments etc.
		}
		nr.analysisEnd();    // print min, max, etc.
		

	}

}