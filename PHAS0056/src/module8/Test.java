package module8;

import java.lang.Thread;

public class Test {
	
	public class NumberSeriesTask implements Runnable {
		private int start;
		private int end;
		private int step;
		
		public NumberSeriesTask(int start, int end, int step) {
			this.start = start;
			this.end = end;
			this.step = step;
		 }
		
		public void run() {
			for (int i=start; i<end; i+=step) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		
		Thread odds = new Thread(t.new NumberSeriesTask(1,10,2));
		Thread evens = new Thread(t.new NumberSeriesTask(2,10,2));
		odds.start();
		evens.start();
	}

}
