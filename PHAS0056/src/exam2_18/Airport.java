package exam2_18;

import java.util.Scanner;

/**
 * Class to store information about an airport.
 * @author zcappop
 *
 */
public class Airport {
	protected String code, name, timeZone;
	
	/**
	 * @param line string containing data about an airport
	 * @param code airport code
	 * @param name full airport name
	 * @param timeZone time zone
	 */
	public Airport(String line) {
		Scanner s = new Scanner(line).useDelimiter(",\\s");
		
		this.code = s.next();
		this.name = s.next();
		this.timeZone = s.next();
		
		s.close();
	}
	
	public String toString() {
		return code+", "+name+", "+timeZone;
	}

}
