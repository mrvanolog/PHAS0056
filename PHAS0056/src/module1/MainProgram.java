package module1;

public class MainProgram {
	public static void main(String[] args) {
		
		// Trial of switch/case Statements
		int month = 0;
		
		switch (month) {
			case 1:
			System.out.println("Jan");
			break;
			case 2:
			System.out.println("Feb");
			break;
			case 3:
			System.out.println("Mar");
			break;
			default:
			System.out.println("???");
			break;
		}
		
		// Trial of for Loop
		int i, maxN = 10;
		
		for (i = 0; i < maxN; i++) {
			System.out.println(" i = "+i);
		}
		
		// Trial of while Loop
		boolean funValue = true;
		float x = 10;
		
		while (funValue) {
			x++;
			System.out.println(x);;
			if (x == 15) { break; }
		 }
		
		
		
		
	}   		
}
