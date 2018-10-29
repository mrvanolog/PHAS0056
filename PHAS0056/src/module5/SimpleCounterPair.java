package module5;

import java.lang.Object;

public class SimpleCounterPair implements Cloneable {
	
 	public SimpleCounter first = new SimpleCounter(1);
 	public SimpleCounter second = new SimpleCounter(1);
 	
 	protected Object clone() throws CloneNotSupportedException {
 		SimpleCounter copy1 = (SimpleCounter) this.first.clone();
 		SimpleCounter copy2 = (SimpleCounter) this.second.clone();
 		SimpleCounterPair copy = new SimpleCounterPair();
 		copy.first = copy1;
 		copy.second = copy2;
 		return (Object) copy;
 	}
 }
