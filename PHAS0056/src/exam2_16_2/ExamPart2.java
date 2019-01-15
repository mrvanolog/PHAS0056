package exam2_16_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) throws IOException {
		// create an array of signals
		ArrayList<Signal> signals = new ArrayList<Signal>();
		
		BufferedReader br = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/"
						+ "undergrad/3459/exam-data/2015-16/signals.txt");
		String line;
		// read information from url an add it to the array
		while((line = br.readLine()) != null) {
			signals.add(new Signal(line));
		}
		
		// create an array for the detector info
		ArrayList<Detector> detectors = new ArrayList<Detector>();
		
		br = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/"
				+ "undergrad/3459/exam-data/2015-16/detectors.txt");
		// read information from url an add it to the array
		while((line = br.readLine()) != null) {
			detectors.add(new Detector(line));
		}
		
		MaxAmpTime mat = new MaxAmpTime();
		ThresholdTime tt = new ThresholdTime(1.0);
		
		double maxDiff = -Double.MAX_VALUE;
		String nameMaxDiff = "FUCK YOU MOTHERFUCKER";
		
		// calculate info specific for each detector
		for(Detector det : detectors) {
			for(Signal sig : signals) {
				if(det.name.equals(sig.detName)) {
					det.numSignals++;
					det.meanArrTime += tt.findTime(sig);
					det.meanArrTime2 += mat.findTime(sig);
				}
			}
			det.meanArrTime /= det.numSignals;
			det.meanArrTime2 /= det.numSignals;
			det.speed = det.meanArrTime / det.distance;
			det.speed2 = det.meanArrTime2 / det.distance;
			
			if(Math.abs(det.speed-det.speed2) > maxDiff) {  
				nameMaxDiff = det.name;
			}
			
			System.out.println("Detector "+det.name+"");
			System.out.println("Speed of the particles: "+(det.speed*1000000000)+" m/s");
			System.out.println();
		}
		
		System.out.println("----------------------------------------------");
		System.out.println("Detector with the greatest difference between the arrival times\n"
						+ "calculated using the two methods: "+nameMaxDiff);
		
	}

}
