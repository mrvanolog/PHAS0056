package exam2_16_2;

public class ThresholdTime implements ArrivalTime {

	private double threshold;
	
	/**
	 * @param threshold the value of the threshold
	 */
	public ThresholdTime(double threshold) {
		this.threshold = threshold;
	}
	
	/**
	 * Calculates time to the pulse with 
	 * amplitude above the given threshold
	 * @param sig signal object
	 */
	@Override
	public int findTime(Signal sig) {
		int time = 0;  // counter for max amp id
		
		// scan through all voltages in the array
		for(double volt : sig.voltages) {
			if(volt >= threshold) {
				return time;
			}
			time++;
		}
		return time;
	}

}
