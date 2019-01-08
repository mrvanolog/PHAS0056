package exam2_16;

import java.util.Scanner;

/**
 * Class describing a detector
 * @author Ivan
 *
 */
public class Detector {
	protected String name;
	protected Double distance;
	
	/**
	 * 
	 * @param name name of the detector
	 * @param distance distance of the detector 
	 * from the particle source, m
	 */
	public Detector(String line) {
		Scanner s = new Scanner(line);
		
		this.name = s.next();
		this.distance = Double.parseDouble(s.next());
		
		s.close();
	}
}
