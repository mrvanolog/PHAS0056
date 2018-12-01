package module6;

public class Practise {
	
	public class SimpleCounter {
		protected int counter;
		public SimpleCounter() {}
		public SimpleCounter(int value) { counter = value; }
		public int getCounter() {return counter;}
		public void setCounter(int val) { counter = val; }
	}
	
	public class LimitedCounter extends SimpleCounter {
		public LimitedCounter() {}
		
		public LimitedCounter(int val) {
			if (val<=max) counter=val;
		}
		
		protected static final int max = 1000;
		
		public void setCounter(int val) {
			if (val<=max) counter=val;
		}
	}
	
	public class NamedCounter extends SimpleCounter {
		protected String n;
		public NamedCounter(String name) {
			super();
			n = name;
		}
		public NamedCounter(String name, int value) {
			super(value);
			n = name;
		}
		public String getName() {return n;}
	}

	public static void main(String[] args) {
		Practise p = new Practise();
		
		SimpleCounter a = p.new SimpleCounter(2);
		SimpleCounter b = p.new LimitedCounter();
		System.out.println(a.getCounter());
		b.setCounter(1001);
		System.out.println(b.getCounter());
		

	}

}
