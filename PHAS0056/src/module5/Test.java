package module5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		 
		 HashMap<String, GregorianCalendar> myDates = new HashMap<String, GregorianCalendar>();
		 	// Insert using put(<KEY>,<VALUE>):
		 	myDates.put("christmas",
		 			new GregorianCalendar(2007,Calendar.DECEMBER,25));
		 	myDates.put("birthday-john",
		 			new GregorianCalendar(2006,Calendar.AUGUST,22));
		 	myDates.put("birthday-jane",
		 			new GregorianCalendar(2006,Calendar.AUGUST,22));
		 	myDates.put("birthday-john",
		 			new GregorianCalendar(2006,Calendar.AUGUST,24));
		 	// DUPLICATE KEYS ARE NOT ALLOWED
		 	// Therefore in this example only
		 	// 3 items remain since the same key
		 	// "birthday-john" was used twice:
		 	System.out.println(myDates.size());
		 	// The last pair to use the duplicate
		 	// key is the only one that remains
		 	// in the HashMap.
		 
	}

}
