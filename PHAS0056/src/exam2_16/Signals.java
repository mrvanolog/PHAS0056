package exam2_16;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Describes the signals coming from the detector
 * @author Ivan
 *
 */
public class Signals {
	protected String name;
	protected ArrayList<Double> signals = new ArrayList<Double>();
	protected int pulses = 0;
	
	/**
	 * 
	 * @param name name of the detector
	 * @param signals array of signals from the detector
	 * with an interval of 1 ns
	 */
	public Signals(String line) {
		Scanner s = new Scanner(line);
		double signal;
		
		this.name = s.next();
		while(s.hasNext()) {
			signal = Double.parseDouble(s.next());
			this.signals.add(signal);
			this.pulses++;
		}
		
		s.close();
	}
	
	// calculates the mean amplitude of the pulses
	// for this detector
	public double meanAmp() {
		double sum = 0;
		for(double signal : this.signals) {
			sum += signal;
		}
		
		return sum / this.pulses;
	}
	
}
