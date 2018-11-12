package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

// finds the samples with the largest and smallest mass, and for 
// each of these prints out the code number of the sample, the mass
// of the sample and the name of the location where the sample was found
public class Minerals {
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	// reads the values from the first URL and returns 
	// them in the form of a HashMap<Integer, Double>
	public static HashMap<Integer, Double> dataFromURL1(BufferedReader b) throws IOException {
		// initialise HashMap object
		HashMap<Integer, Double> data = new HashMap<Integer, Double>(); 
		String line = "";
		int key;
		double val;
		
		// read each line one by one and add key-value pairs to HashMap
		while ((line = b.readLine()) != null) {
			try (
				Scanner s = new Scanner(line);
			){
				// update key and value
				key = s.nextInt();
				val = s.nextDouble();
				// add key-value pair to HashMap
				data.put(key, val);
			}
			catch (Exception e) {
				System.out.println("DataAnalysis.dataFromURL1(): " + e);
			}
		}
		
		return data;
	}
	
	// reads the values from the first URL and returns 
	// them in the form of a HashMap<Integer, String>
	public static HashMap<Integer, String> dataFromURL2(BufferedReader b) throws IOException {
		// initialise HashMap object
		HashMap<Integer, String> data = new HashMap<Integer, String>(); 
		String line = "";
		int key;
		String val;
		
		// read each line one by one and add key-value pairs to HashMap
		while ((line = b.readLine()) != null) {
			try (
				Scanner s = new Scanner(line);
			){
				// update key and value
				val = s.next();
				key = s.nextInt();
				// add key-value pair to HashMap
				data.put(key, val);
			}
			catch (Exception e) {
				System.out.println("DataAnalysis.dataFromURL2(): " + e);
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		// create BufferedReader objects
		BufferedReader b1, b2;
		b1 = brFromURL("http://www.hep.ucl.ac.uk/"
						+ "undergrad/3459/data/module5/module5-samples.txt");
		b2 = brFromURL("http://www.hep.ucl.ac.uk/"
						+ "undergrad/3459/data/module5/module5-locations.txt");

		// create HashMap objects
		HashMap<Integer, Double> data1 = dataFromURL1(b1);
		HashMap<Integer, String> data2 = dataFromURL2(b2);
		
		// initialise variables needed to find min and max values of mass
		double mass, massMax = Double.MIN_VALUE, massMin = Double.MAX_VALUE;
		int numMax = 0, numMin = 0;
		
		// go through first HashMap to find the largest and the smallest masses
		for (int num : data1.keySet()) {
			mass = data1.get(num);
			// check for largest mass
			if (mass > massMax) {
				massMax = mass;
				numMax = num;
			}
			
			// check for smallest mass
			if (mass < massMin) {
				massMin = mass;
				numMin = num;
			}
		}
		
		// print the results
		System.out.println("<<<The sample with the largest mass>>>");
		System.out.println("Code number of the sample: " + numMax);
		System.out.println("Mass of the sample: " + massMax + " kg");
		System.out.println("Name of the location where the sample was found: " + data2.get(numMax) + "\n");
		
		System.out.println("<<<The sample with the smallest mass>>>");
		System.out.println("Code number of the sample: " + numMin);
		System.out.println("Mass of the sample: " + massMin + " kg");
		System.out.println("Name of the location where the sample was found: " + data2.get(numMin));
	}

}
