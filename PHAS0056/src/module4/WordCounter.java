package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {
	
	// takes the name of a URL as argument and 
	// returns a BufferedReader object
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		return b; 
	}
	
	// takes the name of a file on the disk as 
	// argument and returns a BufferedReader object
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader f = new FileReader(fileName);
		BufferedReader b = new BufferedReader(f);
		
		return b;
	}
	
	// reads through the data contained in the 
	// BufferedReader object dataAsBR and then returns 
	// the number of words in the corresponding resource.
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		// initialise word counter
		int cntrWords = 0;
		
		try (
			Scanner s = new Scanner(dataAsBR);
		) {
			// start a loop that ends, when all 
			// the words in the resource end
			while (s.hasNext()) {
				cntrWords++;
				s.next();
			}
		}
		
		return cntrWords;
	}

	public static void main(String[] args) throws IOException {
		// create BufferedReader object from a URL 
		BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt"); 
		// count the number of words in a resource
		int numWords = countWordsInResource(br);
		
		System.out.println("Number of words in a doucument: " + numWords);
		
		
	}

}
