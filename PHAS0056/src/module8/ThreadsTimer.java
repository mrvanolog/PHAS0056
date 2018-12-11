package module8;

import java.util.concurrent.*;
import java.util.*;

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
		
		int nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		timeInit = System.currentTimeMillis();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task1 = new
					MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task1);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			try {
				double result = futures.get(iThread).get();
				sum += result;
			}
			catch (InterruptedException e) { }
			catch (ExecutionException e) { }
		}
		threadPool.shutdown();
		double timeFourThreads = System.currentTimeMillis() - timeInit;
		double pi1 = sum/nThreads;
		
		System.out.println(pi1);
		System.out.println("Time taken for four threads: "+timeFourThreads/1000+" s");
		
		System.out.println("\nIt takes less time for four threads to perform the task than it takes the single thread."
				+ "\nThis is because 4 threads do those calculations simultaneously where possible and a single thread"
				+ "\nis performing the calculations one at a time.");
	}
}
