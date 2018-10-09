package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// create three vectors
		ThreeVector v1 = new ThreeVector(4, 5, 3);
		ThreeVector v2 = new ThreeVector(1, 4, 2);
		ThreeVector v3 = new ThreeVector(0, 0, 0);
		
		// print three vectors
		System.out.println("Vector v1: " + v1);
		System.out.println("Vector v2: " + v2);
		System.out.println("Vector v3: " + v3);
		
		// print three unit vectors of the vectors
		System.out.println("\nUnit vector of v1: " + v1.unitVector());
		System.out.println("Unit vector of v2: " + v2.unitVector());
		System.out.println("Unit vector of v3: " + v3.unitVector());
		System.out.println("Unit vector of v3 returns NaN as each of the components, because "
				+ "of the division by 0, as vector's magnitude is 0. Such behaviour is observed, \n"
				+ "beacuse vector (0, 0, 0) doesn't have a direction, therefore it's unit vector "
				+ "won't have a direction neither.");
		
		// print scalar product of v1.v2, v1.v3 using static and non-static methods
		System.out.println("\nScalar product v1.v2 using static method: " + ThreeVector.scalarProduct(v1, v2));
		System.out.println("Scalar product v1.v3 using static method: " + ThreeVector.scalarProduct(v1, v3));
		System.out.println("Scalar product v1.v2 using non-static method: " + v1.scalarProduct(v2));
		System.out.println("Scalar product v1.v3 using non-static method: " + v1.scalarProduct(v3));
		
		// print scalar product of v1*v2, v1*v3 using static and non-static methods
		System.out.println("\nVector product v1*v2 using static method: " + ThreeVector.vectorProduct(v1, v2));
		System.out.println("Vector product v1*v3 using static method: " + ThreeVector.vectorProduct(v1, v3));
		System.out.println("Vector product v1*v2 using non-static method: " + v1.vectorProduct(v2));
		System.out.println("Vector product v1*v3 using non-static method: " + v1.vectorProduct(v3));
		
		// print angle between v1 and v2, v1 and v3 using static and non-static methods
		System.out.println("\nAngle between v1 and v2 using static method: " + ThreeVector.angle(v1, v2));
		System.out.println("Angle between v1 and v2 using static method: " + ThreeVector.angle(v1, v3));
		System.out.println("Angle between v1 and v2 using non-static method: " + v1.angle(v2));
		System.out.println("Angle between v1 and v2 using non-static method: " + v1.angle(v3));
		
		System.out.println("\nIf toString() method is not defined in the class, then instead of returning "
				+ "the value correspondong to the element, print statement will return the package name \n"
				+ "followed by type of the variable, followed by @ and then identity hash code of an array "
				+ "to whitch this elemnt belongs.");
	}

}
