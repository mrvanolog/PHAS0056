package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		double doubVar = 5.0;
		System.out.println(doubVar);
		
		float floatVar = 5;
		int intVar = 5;
		long longVar = 5;
		byte byteVar = 5;
		
		floatVar *= floatVar;
		System.out.println(floatVar);
		intVar *= intVar;
		System.out.println(intVar);
		longVar *= longVar;
		System.out.println(longVar);
		byteVar *= byteVar;
		System.out.println(byteVar);
		
		char charVar = 'c' + 10;
		System.out.println(charVar);
		
		// Adding long to int will return an Error
		// because you can't convert from long to int
		//long l1 = 12345;
		//int i1 = 12 + l1;
		//System.out.println(i1);
		
		// However, adding int to long is fine, because this
		// is widening and is acceptable
		int i2 = 12;
		long l2 = i2 + 12345;
		System.out.println(l2);
		
		// Adding int to float is also fine,
		// int gets automatically converted into float
		int i3 = 12;
		float f1 = 12.0f + i3;
		System.out.println(f1);
		
		
		// If the variable is not initialised
		// compiler will return an Error
		// int j=1; int i; j=i+1;
		
		double doubleNew = 4.99;
		int intNew = (int) doubleNew;
		System.out.println(intNew);
		// When casting from double to int, the compiler
		// will always ROUND DOWN the initial double value
		// to the closest integer
		
	}

}
