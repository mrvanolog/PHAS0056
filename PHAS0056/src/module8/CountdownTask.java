package module8;

// performs a countdown for a given number of seconds
public class CountdownTask implements Runnable {
	private int sec;
	
	// takes in the number of seconds to countdown
	public CountdownTask(int sec) {
		this.sec = sec;
	}
	// prints the number of seconds left to countdown
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
