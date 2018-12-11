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
	
	public class NumberSeries implements Runnable {
		private int start;
		private int step;
		public NumberSeries(int start, int step) {
			this.start = start;
			this.step = step;
		}
		public void run() {
			int i = start;
			while (true) { // run until interrupted
				if (Thread.currentThread().isInterrupted()) return;
				System.out.println(i);
				i += step;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(1/2);
	}

}
