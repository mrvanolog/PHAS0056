package exam2_18;

import java.util.Scanner;

public class Flight {
	String flightCode, originCode, destCode, depTime, arrTime,
			depDate, arrDate, depDateTime, arrDateTime;
	protected double price;
	protected long durationTime;
	
	/**
	 * @param line string with information about a flight
	 * @param flightCode flight code
	 * @param originCode origin airport code
	 * @param destCode destination airport code
	 * @param depDateTime departure date and time
	 * @param arrDateTime arrival date and time
	 * @param price cost of the flight in pounds
	 */
	public Flight(String line) {
		Scanner s = new Scanner(line).useDelimiter(",\\s");
		
		this.flightCode = s.next();
		this.originCode = s.next();
		this.destCode = s.next();
		this.depDate = s.next();
		this.depTime = s.next();
		this.arrDate = s.next();
		this.arrTime = s.next();
		// create date/time variables for LocalDateTime
		this.depDateTime = depDate+"T"+depTime;
		this.arrDateTime = arrDate+"T"+arrTime;
		this.price = Double.parseDouble(s.next());
		
		s.close();
	}
	
	/**
	 * Sets the duration time of the flight
	 * @param durationTime time of the flight
	 */
	public void setDurationTime(long durationTime) {
		this.durationTime = durationTime;
	}
	
	/**
	 * Outputs Flight object in a string format
	 */
	public String toString() {
		return flightCode+", "+originCode+", "+destCode+", "+
					depDateTime+", "+arrDateTime+", "+price;
	}

}
