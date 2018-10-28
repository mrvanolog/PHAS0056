package module4;

import java.io.*;
import java.util.Scanner;
import java.net.URL;

// reads the text from URL, creates a text file with the resource data
// and then parses the data to find max, min, average and total number of values
public class NumericalReader {
	
	private double minValue, maxValue, sumOfValues;
	private int nValues;
	private String saveFile;
	
	// prompts the user to enter a string via the 
	// keyboard and stores the resulting String
	public static String getStringFromKeyboard() throws IOException {				
		// initialise buffered reader 
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		// read the line
		String s = b.readLine();
		
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
	
	// creates a file, writes the source data into it and initialises private variables
	void analysisStart(String dataFile) throws IOException {
		// create text file
		File outputFile = new File(dataFile);
		outputFile.createNewFile();
		
		// initialise private variables
		minValue = Double.MAX_VALUE; 
		maxValue = -Double.MAX_VALUE;
		nValues = 0;
		sumOfValues = 0;
	}
	
	// parses the data and writes data into a file line by line
	void analyseData(String line) throws Exception {	
		// initialise PrintWriter to write into newly created file
		FileWriter f = new FileWriter(saveFile, true);
		BufferedWriter b = new BufferedWriter(f);
		PrintWriter pw = new PrintWriter(b);
		
		// write in a file
		try { 
			pw.println(line);
		}
		catch (Exception e) {
			System.out.println("analyseData() writing to a file: " + e.getMessage());
		}
		// close the writer
		pw.close();
		
		Scanner s = new Scanner(line);
		
		while (s.hasNext()) {			
			String token = s.next();
			
			// if line is empty or contains letters go to next line
			if (!(line.isEmpty()) && !(Character.isLetter(line.charAt(0)))) {				
				// parse the data
				try {				
					double x = Double.parseDouble(token);
					System.out.println(x);  // print the number to a screen
					
					if (x > maxValue) { maxValue = x; }
					if (x < minValue) { minValue = x; }
					sumOfValues += x;
					nValues++;
				} catch (NumberFormatException e) {
					// Ignore anything that is not a number
				}
			}
		}
		// close the scanner
		s.close();
	}
	
	// prints out the results of the analysis
	void analysisEnd() {
		System.out.println("The maximum value: " + maxValue);
		System.out.println("The minimum value: " + minValue);
		System.out.println("The average value: " + sumOfValues/nValues);
		System.out.println("The number of values: " + nValues);
	}

	public static void main(String[] args) throws Exception {
		NumericalReader nr = new NumericalReader();
		
		// get the file directory from the user
		System.out.println("Type in the file directory");
		String saveDir = NumericalReader.getStringFromKeyboard();
		
		// create the directory, file name and type string
		String dataFile = "data1";
		nr.saveFile = (saveDir + File.separator + dataFile + ".txt");
		
		////// Analyse data from URL file data1.txt //////
		
		BufferedReader br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		String line = "";
		
		// start the analysis process
		try {
			nr.analysisStart(nr.saveFile);    // initialise minValue etc.
			while ((line = br.readLine()) != null) {
				nr.analyseData(line);    // analyse lines, check for comments etc.
			}
			nr.analysisEnd();    // print min, max, etc.
		}
		catch (Exception e) {
			System.out.println("Analysis process for data1.txt: " + e.getMessage());
		}
		
		System.out.println("\n");
		
		////// analyse data from URL file data2.txt //////
		
		// create the directory, file name and type string again
		dataFile = "data2";
		nr.saveFile = (saveDir + File.separator + dataFile + ".txt");
		
		br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		line = "";
		
		// start the analysis process
		try {
			nr.analysisStart(nr.saveFile);    // initialize minValue etc.
			while ((line = br.readLine()) != null) {
				nr.analyseData(line);    // analyse lines, check for comments etc.
			}
			nr.analysisEnd();    // print min, max, etc.
		}
		catch (Exception e) {
			System.out.println("Analysis process for data2.txt: " + e.getMessage());
		}
	}
}