package exam2_16_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Stores information about a signal 
 * from a specific detector
 * @author zcappop
 *
 */
public class Signal {
	protected String detName;    // name of the detector
	// array of voltage values of the signal
	protected ArrayList<Double> voltages = new ArrayList<Double>(); 
	protected double maxAmpID; // id of maximum voltage amplitude in the array
	
	/**
	 * @param line string containing information about the signal
	 */
	public Signal(String line) {
		Scanner s = new Scanner(line);
		
		this.detName = s.next();
		
		while(s.hasNext()) {
			this.voltages.add(Double.parseDouble(s.next()));
		}
		
		s.close();
	}
	
	/**
	 * Calculates maximum voltage amplitude of the signal
	 * @return
	 */
	public double maxAmplitude() {
		double max = -Double.MAX_VALUE;
		int i = 0;  // counter for max amp id
		
		// scan through all voltages in the array
		for(double volt : voltages) {
			if(volt > max) {
				max = volt;
				maxAmpID = i;
			}
			i++;
		}
		
		return max;
	}

}
