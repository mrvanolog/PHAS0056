package module4;

import java.io.*;
import java.net.*;

public class Test {
	
	// Print contents of text
	// file to the screen
	public static void printFile(String fileName)
	throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	public static void main(String[] args) {
		System.out.println(File.separator);
		
	}
}
