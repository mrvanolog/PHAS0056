package exam2_16;

import java.io.BufferedReader;
import java.util.ArrayList;

public class FinalExam {

	public static void main(String[] args) throws Exception {
		DataParser dp = new DataParser();
		
		BufferedReader bSig = dp.brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "3459/exam-data/2015-16/signals.txt");
		BufferedReader bDet = dp.brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "3459/exam-data/2015-16/detectors.txt");
		
		ArrayList<Signals> signals = dp.signalsFromFile(bSig);
		ArrayList<Detector> detector = dp.detectorFromFile(bDet);
		
		System.out.println("Total number of pulses: "+dp.pulsesTot);
		System.out.println("The mean amplitude of the pulses: "+dp.pulsesMeanAmp(signals));
		
		
		
	}

}
