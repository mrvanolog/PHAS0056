package module5;

import java.util.Arrays;

// allows to create and perform calculations with saquare matricies
public class SquareMatrix {
	
	private double[][] mtrx;
	
	// input a square matrix in the form of 2D array
	public SquareMatrix(double[][] elements) {
		// check that all columns are the same length as rows
		// throw an Exception and close constructor if not square
		for (int i = 0; i < elements.length; i++) {
			if (elements.length != elements[i].length) {
				System.out.println("SquareMatrix constructor: Matrix is not square");
				return;
			}
		}
		mtrx = elements;
	}
	
	// outputs matrix in a readable form
	public String toString() {
		for (int i = 0; i < mtrx.length; i++) {
		    for (int j = 0; j < mtrx[i].length; j++) {
		        System.out.print(mtrx[i][j] + "  ");
		    }
		    System.out.println();
		}
		return "";
	}
	
	// returns a square matrix of given size
	public static SquareMatrix unitMatrix(int size) {
		// create a square 2D array and fill it with 1
		// on the main diagonal
		double[][] unit = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					unit[i][j] = 1;
				}
			}
		}
		
		return new SquareMatrix(unit);
	}
	
	// checks whether two matrices have the same elements
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		// check if two specified arrays are deeply equal to one another
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(mtrx, other.mtrx))
			return false;
		return true;
	}
	
	// calculates sum of two equal matrices (sm1 + sm2)
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) {
		// check if two matrices have the same size
		if (sm1.mtrx.length != sm2.mtrx.length) {
			System.out.println("SquareMatrix.add(): Matrices are not equal");
			return null;
		}
		
		int size = sm1.mtrx.length;
		double[][] sum = new double[size][size];

		// go through each term and add corresponding terms
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum[i][j] = sm1.mtrx[i][j] + sm2.mtrx[i][j];
			}
		}
		
		return new SquareMatrix(sum);
	}
	
	// for two equal matrices subtracts one from another (sm1 - sm2)
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) {
		// check if two matrices have the same size
		if (sm1.mtrx.length != sm2.mtrx.length) {
			System.out.println("SquareMatrix.subtract(): Matrices are not equal");
			return null;
		}
		
		int size = sm1.mtrx.length;
		double[][] sub = new double[size][size];
		
		// go through each term and subtract corresponding terms
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sub[i][j] = sm1.mtrx[i][j] - sm2.mtrx[i][j];
			}
		}
		
		return new SquareMatrix(sub);
	}
	
	// multiplies two matrices together 
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) {
		// check if two matrices have the same size
		if (sm1.mtrx.length != sm2.mtrx.length) {
			System.out.println("SquareMatrix.multiply(): Matrices are not equal");
			return null;
		}
		
		double sum;
		int i, j, c, size = sm1.mtrx.length;
		double[][] mult = new double[size][size];
		
		// go through each term and write in the sum of the products
		// of corresponding row-column pair for each term
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				sum = 0;
				for (c = 0; c < size; c++) {
					sum += sm1.mtrx[i][c] * sm2.mtrx[c][j];
				}
				mult[i][j] = sum;
			}
		}
		
		return new SquareMatrix(mult);
	}
	
	// calculates sum of two equal matrices (sm1 + sm2)
	public SquareMatrix add(SquareMatrix sm2) {
		return add(this, sm2);
	}
	
	// for two equal matrices subtracts one from another (sm1 - sm2)
	public SquareMatrix subtract(SquareMatrix sm2) {
		return subtract(this, sm2);
	}
	
	// multiplies two matrices together 
	public SquareMatrix multiply(SquareMatrix sm2) {
		return multiply(this, sm2);
	}
}
