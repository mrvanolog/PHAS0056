package exam2_16_2;

/**
 * Calculates the arrival time by determining time
 * to the signal with maximum amplitude
 * @author zcappop
 *
 */
public class MaxAmpTime implements ArrivalTime {
	
	/**
	 * Calculates time to the max amplitude pulse
	 * @param sig signal object
	 */
	@Override
	public int findTime(Signal sig) {
		double max = -Double.MAX_VALUE;
		int i = 0;  // counter for max amp id
		int time = 0;
		
		// scan through all voltages in the array
		for(double volt : sig.voltages) {
			if(volt > max) {
				max = volt;
				time = i;
			}
			i++;
		}
		return time;
	}
}
