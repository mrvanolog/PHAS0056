package module2;

public class StaticTest {
	private int varA;
	private static int varB;
	
	public static void main(String[] args) {
		StaticTest objectX = new StaticTest();
		StaticTest objectY = new StaticTest();
		
 		objectX.varA = 1; objectX.varB = 2;
 		objectY.varA = 10; objectY.varB = 20;
 		
 		System.out.println("objectX: varA="+objectX.varA+
 				" varB="+objectX.varB);
 		System.out.println("objectY: varA="+objectY.varA+
 				" varB="+objectY.varB);
 	}
}