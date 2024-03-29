package module8;

import java.util.ArrayList;

/** A class that creates an array of prime numbers.
 *  @author Ivan
 *  @version 1.0
 *
 */
public class PrimeNumberTask implements Runnable {
	private ArrayList<Integer> primeList = new ArrayList<Integer>();
	
	public PrimeNumberTask() {};
	
	/** Checks if a number is prime or not.
	 * 	@param n integer number
	 *  @return true if prime, false otherwise 
	 */
	private boolean isPrime(int n) {
	    // check if n is a multiple of 2
	    if (n%2 == 0) return false;
	    // if not check all of the odd numbers
	    for(int j=3; j < Math.sqrt(n)+1; j+=2) {
	        if(n%j == 0)
	            return false;
	    }
	    return true;
	}
	/** Checks if a number is prime and adds prime numbers to array.
	 */
	public void run() {
		int i = 1;
		while(true) {
			// check if program was interrupted
			if (Thread.currentThread().isInterrupted()) {
				int size = primeList.size();
				System.out.println("The largest checked integer so far: "+i);
				System.out.println("The largest prime number found: "+primeList.get(size-1));
				System.out.println("The total number of prime numbers found: "+size);
				
				return;
			}
			// check for a prime number
			if(isPrime(i) == true) {
				primeList.add(i);
			}
			
			i++;
		}
	}
	
	
	

}
