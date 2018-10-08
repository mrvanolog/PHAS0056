package module2;

public class SimpleCounter {
	
	// same val for all SimpleCounters
	private static final int max = 1000;
	
	// member variable
	private int counter;
	
	// constructor (ignore for now)
	public SimpleCounter(int val) { counter = val; }
	
	// method to set value
	public void setCounter(int val) {
		// only change if new value <= max
		if (val <= max) { counter = val; }
	}
	
	// retrieve value
	int getCounter() {
	 return counter;
	}
	
	// print the value of maximum value of the counter
	public static void printMaximum() {
		System.out.println("Maximum = " + max);
	}
	
	// add value to member counter
	public static SimpleCounter add(SimpleCounter x, SimpleCounter y) {
		int sum = x.counter + y.counter;
		return new SimpleCounter(sum);
	}
	
	// add value to member counter 
	public SimpleCounter add(SimpleCounter z) {
		return add(this, z);
	}
	
	// output string
	public String toString() {
		return "counter = " + counter + ", max = " + max;
	}
}
