package module8;

/** A class that performs countdown and prime number calculation 
 *  @author Ivan
 *  @version 1.0
 *
 */
public class ThreadsMain {

	public static void main(String[] args) {
		Thread countdown = new Thread(new CountdownTask(3));
		Thread prime = new Thread(new PrimeNumberTask());
		// start the threads
		countdown.start();
		prime.start();
		// wait till countdown thread finishes operating
		countdown.interrupt();
		try {
			countdown.join();
		} catch (InterruptedException e) {};
		
		prime.interrupt();
	}

}
