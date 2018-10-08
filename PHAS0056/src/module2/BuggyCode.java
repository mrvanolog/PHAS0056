package module2;

public class BuggyCode {

	// member variables for String array and incremented double value
	public String[] strArray;
	public double incremented;

	// Class null constructor
	public BuggyCode() { }

	// increment a double, initVal, by the value incVal, a number of times given by numSteps
	public double increment(double initVal, double incVal, int numSteps) {

		// Initialise necessary variables
		double finalVal = initVal;
		int i = 0;

		// Loop numSteps times, incrementing initVal each time
		while ( i <= numSteps ) {
			 initVal += incVal;
			 i += 1;
		}

		return finalVal;

	}

	// method to add one to arbitrary array of doubles
	public double[] addOne(double[] inputVals) {

		// Initialise new double array
		double[] doubArray = new double[inputVals.length];
		//System.out.println("Length of input array: "+inputVals.length);

		// Loop over all elements in input array
		for ( int i = 0 ; i < inputVals.length ; i++) {
			//System.out.println("Value of i: "+i);
			doubArray[i] = inputVals[i] + 1;
			//System.out.println("Value of inputVals[i]: "+inputVals[i]);
			//System.out.println("Value of doubArray[i]: "+doubArray[i]);
		}

		return inputVals;

	}

	public static void main(String[] args) {

		// Instantiate BuggyCode object bugs
		BuggyCode bugs = new BuggyCode();

		// Increment single value
		bugs.incremented = bugs.increment(0, 1, 10);
		System.out.println("The next line should display \"Incremented value: 10.0\"");
		System.out.println("Incremented value: "+bugs.incremented);
		System.out.println();

		// Add one to double array
		double[] doubVals = new double[]{3, 3, 10};
		double[] addedOne = bugs.addOne(doubVals);

		// Work out if new first element is bigger than second
		System.out.println("The next line should display \"4 is greater than 3\"");
		if ( addedOne[1] > doubVals[2] ) {
			System.out.println(addedOne[1] + " is greater than " + doubVals[2]);
		}

	}

}