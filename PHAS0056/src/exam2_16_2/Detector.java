package exam2_16_2;

import java.util.Scanner;

/**
 * Stores information about detector
 * @author zcappop
 *
 */
public class Detector {
	protected String name;           // name of the detector
	protected double distance;       // distance of the source
	protected int numSignals = 0;    // num of signals from detector
	protected double meanAmplitude = 0;  // mean ampl of the signals
	protected double meanArrTime = 0;    // mean arrival time of the signals
	protected double meanArrTime2 = 0;
	protected double speed;          // speed of particles 
	protected double speed2;
	
	/**
	 * @param line string containing info about detector
	 */
	public Detector(String line ) {
		Scanner s = new Scanner(line);
		
		this.name = s.next();
		this.distance = Double.parseDouble(s.next());
		
		s.close();
	}

}
