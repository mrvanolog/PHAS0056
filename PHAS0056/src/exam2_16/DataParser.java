package exam2_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DataParser {
	int pulsesTot = 0;
	
	
	/// creates BufferedReader object from a URL
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	// creates an array of Signals objects
	public ArrayList<Signals> signalsFromFile(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<Signals> data = new ArrayList<Signals>();
		String line;		
		
		// read each line one by one and add Signals objects to ArrayList
		while ((line = b.readLine()) != null) {
			Signals signals = new Signals(line);
			data.add(signals);
			this.pulsesTot += signals.pulses; 
		}
		return data;
	}
	
	// creates an array of detector objects
	public ArrayList<Detector> detectorFromFile(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<Detector> data = new ArrayList<Detector>();
		String line;		
		
		// read each line one by one and add Signals objects to ArrayList
		while ((line = b.readLine()) != null) {
			Detector detector = new Detector(line);
			data.add(detector);
		}
		return data;
	}
	
	// calculates the mean amplitude of the pulses
	public double pulsesMeanAmp(ArrayList<Signals> signals) {
		double sum = 0;
		
		for(Signals signal : signals) {
			sum += signal.meanAmp();
		}
		
		return sum / signals.size();
	}
}