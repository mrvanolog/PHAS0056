package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		// initialise double 2D arrays
		double[][] valA = {{2,1,0}, {0,1,0}, {-1,0,2}};
		double[][] valB = {{1,3,1}, {0,2,0}, {1,0,-1}};
		double[][] valC = {{2,3}, {3,4}};
		double[][] valD = {{-4,3}, {3,-2}};
		
		// create SquareMatrix objects from double arrays
		SquareMatrix mtrxA = new SquareMatrix(valA);
		SquareMatrix mtrxB = new SquareMatrix(valB);
		SquareMatrix mtrxC = new SquareMatrix(valC);
		SquareMatrix mtrxD = new SquareMatrix(valD);
		
		// calculate and print A+B and A-B
		System.out.println("A+B:");
		System.out.println(mtrxA.add(mtrxB));
		System.out.println("A-B:");
		System.out.println(mtrxA.subtract(mtrxB));
		
		// calculate and print AB and BA
		System.out.println("AB:");
		System.out.println(mtrxA.multiply(mtrxB));
		System.out.println("BA:");
		System.out.println(mtrxB.multiply(mtrxA));
		
		// calculate and print the commutator [A,B]
		SquareMatrix commutator = (mtrxA.multiply(mtrxB)).subtract(mtrxB.multiply(mtrxA));
		System.out.println("(AB - BA):");
		System.out.println(commutator);
		
		// create 2x2 unit matrix
		SquareMatrix unit = SquareMatrix.unitMatrix(2);
		//calculate product CD
		SquareMatrix mtrxCD = mtrxC.multiply(mtrxD);
		System.out.println(mtrxCD);
		// compare two matrices and print the result
		System.out.println("2x2 unit matrix and CD are equal: " + unit.equals(mtrxCD));
	}

}
