package module3;

import java.util.Random;
import java.lang.Integer;
import java.lang.Character;
import java.lang.StringBuilder;

public class Alphabet {
	
	// creates random character
	public static char randomCharacter() {
		// create random number generator using seed 5
		Random rnd = new Random();
		// create random integer in range 0-127
		int rndInt = rnd.nextInt(128);
		
		// convert int into char and return this value
		return (char)rndInt;
	}
	
	public static void main(String[] args) {
		// string to which I will append all letters and digits
		StringBuilder charString = new StringBuilder();
		// variable representing the running total
		long runTotal = 0;
		// counter of exceptions that have occurred
		int cntrExceptions = 0;
		// counter of number of chars in charString
		int cntrChar = 0;
		
		// create 400 random characters
		for (int i = 0; i < 400; i++) {
			// create a random character
			char rndChar = randomCharacter();
			
			if (Character.isDigit(rndChar) == true || Character.isLetter(rndChar) == true) {
				// append string representation of a char to string
				charString.append(rndChar);
				// update the number of characters counter
				cntrChar++;
				
				try {
					// create string from char (parseInt() only takes
					// in string values as an argument)
					String s = String.valueOf(rndChar);
					// interpret the character as a number
					int num = Integer.parseInt(s);
					
					// update running total in case of great success
					runTotal += num;
				}
				catch (Exception e) {					
					// update Exceptions counter
					cntrExceptions++;
				}
			}
		}
		
		// output the information after calling randomCharacter 400 times
		System.out.println("The contents of StringBuilder: " + charString);
		System.out.println("The number of characters StringBuilder contains: " + cntrChar);
		System.out.println("The sum of all the integers converted from characters: " + runTotal);
		System.out.println("The number of exceptions that were thrown by the Integer.parseInt() method: " + cntrExceptions);				
	}
}
