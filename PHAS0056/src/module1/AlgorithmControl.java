package module1;

public class AlgorithmControl {
	public AlgorithmControl() {}
	
	public void loop() {
		for (int i = 1; i < 9; i++) {
			System.out.println(i);
		}
	}
	
	public void decrement() {
		int i = 10;
		while (i >= -5) {
			System.out.println(i);
			i--;
		}
	}
	
	public void increment() {
		double i = 2.5;
		do {
			System.out.println(i);
			i += 0.1;
		} while(i <= 4.3);
	}
	
	public void timer() {
		long time_init = System.currentTimeMillis(); // get initial time
		long time_now = 0;   // initialise instantaneous time
		long ctr_time = 0;   // initialise time counter
		int ctr_loop = 0;    // initialise loop counter
		
		while (ctr_time < 5000) {
			ctr_loop++;
			time_now = System.currentTimeMillis();
			ctr_time = time_now % time_init;
			if (ctr_loop % 100 == 0) {
				System.out.println("Number of loops so far " + ctr_loop);
			}
			
		}
	}
	
	public int timer1(long maxTime, int loopSteps) {
		long time_init = System.currentTimeMillis(); // get initial time
		long time_now = 0;   // initialise instantaneous time
		long ctr_time = 0;   // initialise time counter
		int ctr_loop = 0;    // initialise loop counter
		
		while (ctr_time < maxTime*1000) {
			ctr_loop++;
			time_now = System.currentTimeMillis();
			
			if (ctr_loop % loopSteps == 0) {
				System.out.println("Number of loops so far " + ctr_loop);
			}
			
			ctr_time = time_now % time_init;  // calculate the time that has passed			
		}
		
		return ctr_loop;
	}
	
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		
		int loop1 = ac.timer1(10, 1000);
		int loop2 = ac.timer1(10, 50000);
		
		System.out.println("Total number of Loops for 10 000 step " + loop1);
		System.out.println("Total number of Loops for 50 000 step " + loop2);
		
		/* In the second run, where the step was 50 000 loops, the total number of 
		 * loops completed is more by ~250 000 000 loops. 
		 */
	}

}
