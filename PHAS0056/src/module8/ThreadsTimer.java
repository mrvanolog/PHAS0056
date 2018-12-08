package module8;

public class ThreadsTimer {

	public static void main(String[] args) {
		// calculating pi estimate in 1 thread
		long nPoints = 10000000L;
		MonteCarloPiCalculatorTask task = new
				MonteCarloPiCalculatorTask(nPoints);
		// calculate the time it takes for a single thread to execute
		double timeInit = System.currentTimeMillis();
		double pi = task.call();
		double timeSingleThread = System.currentTimeMillis() - timeInit;
		System.out.println(pi);
		System.out.println("Time taken for a single thread: "+timeSingleThread/1000+" s");
		
		// calculating pi estimate in 4 threads
		long n1 = 2500000L;
		MonteCarloPiCalculatorTask task1 = new
				MonteCarloPiCalculatorTask(n1);
		// calculate the time it takes for 4 threads to execute
		timeInit = System.currentTimeMillis();
		double pi1 = task1.call();
		double pi2 = task1.call();
		double pi3 = task1.call();
		double pi4 = task1.call();
		double timeFourThreads = System.currentTimeMillis() - timeInit;
		
		System.out.println((pi1+pi2+pi3+pi4)/4);
		System.out.println("Time taken for four threads: "+timeFourThreads/1000+" s");
		
		System.out.println("\nIn general it takes less time for four threads to perform the task than it takes the single thread."
				+ "\nThis is because 4 threads do those calculations simultaneously where possible and a single thread"
				+ "\nis performing the calculations one at a time.");
	}
}
