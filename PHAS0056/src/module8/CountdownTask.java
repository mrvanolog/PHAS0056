package module8;

/** A class that performs a count down 
 *  for a given number of seconds
 *  @author Ivan Popov
 *  @version 1.0
 */
public class CountdownTask implements Runnable {
	private int sec;
	
	/** Takes in the number of seconds to countdown.
	 *  @param sec seconds
	 */
	public CountdownTask(int sec) {
		this.sec = sec;
	}
	/** Prints the number of seconds left to countdown.
	 */
	public void run() {
		for(int i = 0; i < sec; i++) {
			System.out.println(sec-i);
			try {
				Thread.sleep(1000);     // main thread pauses for 1 second
										// while other threads run
			}
			catch (InterruptedException e) {
				// stop early if main thread is interrupted
			}
		}
		
		return;
	}
}
