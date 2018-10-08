package module2;

public class TestSimpleCounter {
	
	public static void main(String[] args) {
		SimpleCounter count1 = new SimpleCounter(13);
		SimpleCounter count2 = new SimpleCounter(3);
		
		SimpleCounter sum = SimpleCounter.add(count1, count2);
		System.out.println("The sum of two counters is: " + sum.getCounter()); 
		
		System.out.println("State of count1: " + count1);
		
		SimpleCounter.printMaximum();
		
		
	}
}
