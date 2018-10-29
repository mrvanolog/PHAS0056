package module5;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Array;

public class Test {

	public static void main(String[] args) {
		 SimpleCounterPair p1 = new SimpleCounterPair();
		 try {
			 SimpleCounterPair p2 = (SimpleCounterPair) p1.clone();
			 p2.first.setCounter(2);
			 System.out.println(p1.first.getCounter());
		 }
		 catch (CloneNotSupportedException e) {
			 System.out.println(e);
		 }
		 
		 ArrayList<String> list = new ArrayList<String>();
		 list.add("hello"); // add to end
		 list.add("and"); // add to end
		 list.add("welcome"); // add to end
		 list.add(2,"another"); // add 3 at position 2
		 list.set(3,"word");
		 String o = list.get(1);
		 System.out.println(o);
		 list.remove(2);
		 System.out.println(list);
		 list.clear();
		 System.out.println(list);
		 boolean contains_and = list.contains("and");
		 int location = list.indexOf("and");
	}

}
