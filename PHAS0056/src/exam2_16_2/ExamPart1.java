package exam2_16_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author zcappop
 *
 */
public class ExamPart1 {
	
	/** creates BufferedReader object from a URL
	 * 
	 * @param url string containing a url
	 * @return BufferedReader object
	 * @throws IOException
	 */
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}

	public static void main(String[] args) throws Exception {
		// create an array of signals
		ArrayList<Signal> signals = new ArrayList<Signal>();
		
		BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/"
						+ "undergrad/3459/exam-data/2015-16/signals.txt");
		String line;
		// read information from url an add it to the array
		while((line = br.readLine()) != null) {
			signals.add(new Signal(line));
		}
		
		// create an array for the detector info
		ArrayList<Detector> detectors = new ArrayList<Detector>();
		
		br = brFromURL("http://www.hep.ucl.ac.uk/"
				+ "undergrad/3459/exam-data/2015-16/detectors.txt");
		// read information from url an add it to the array
		while((line = br.readLine()) != null) {
			detectors.add(new Detector(line));
		}
		
		// calculate and output information
		System.out.println("Total number of pulses: "+signals.size());
		
		// calculate the mean amplitude of the pulses
		double mean = 0;
		for(Signal sig : signals) {
			mean += sig.maxAmplitude();
		}
		mean /= signals.size();
		
		System.out.println("Mean amplitude of the pulses: "+mean);
		System.out.println("-------------------------------------");
		
		// calculate info specific for each detector
		for(Detector det : detectors) {
			for(Signal sig : signals) {
				if(det.name.equals(sig.detName)) {
					det.numSignals++;
					det.meanAmplitude += sig.maxAmplitude();
					det.meanArrTime += sig.maxAmpID;
				}
			}
			det.meanAmplitude /= det.numSignals;
			det.meanArrTime /= det.numSignals;
			det.speed = det.meanArrTime / det.distance;
			
			System.out.println("Detector "+det.name+"");
			System.out.println("Number of signals from this detector: "+det.numSignals);
			System.out.println("Mean amplitude of the pulses from this detector: "+det.meanAmplitude);
			System.out.println("Mean arrival time of the pulses from this detector: "+det.meanArrTime+" ns");
			System.out.println("Speed of the particles: "+(det.speed*1000000000)+" m/s");
			System.out.println();
		}
	}

}
