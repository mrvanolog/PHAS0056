package module1;
import java.lang.Math.*;

public class VectorMethods {
	public VectorMethods() {}
	
	public double dotProduct(double x1, double y1, double z1, double x2, double y2, double z2) {
		// Method that calculates dot product of two 3D vectors
		double a;
		a = x1*x2 + y1*y2 + z1*z2;
		return a;
	}
	
	public double magnitude(double x, double y, double z) {
		// Method that calculates magnitude of a single 3D vector
		double mag;
		mag = Math.sqrt(x*x + y*y + z*z) ;
		return mag;
	}
	
	public double angle(double x1, double y1, double z1, double x2, double y2, double z2) {
		// Method that calculates angle between two 3D vectors
		// (0,0,0) vectors are not allowed, as this would cause division by 0
		// and therefore an Error from Java
		double ang, cos;
		cos = dotProduct(x1, y1, z1, x2, y2, z2) / (magnitude(x1, y1, z1) * magnitude(x2, y2, z2));
		ang = Math.acos(cos);
		ang = Math.toDegrees(ang);
		return ang;
	}

	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		
		double ang = vm.angle(4, 3, 2, 1, 5, 4);
		System.out.println(ang);
		
		//double ang = vm.angle(4, 3, 2, 0, 0, 0);
		//System.out.println(ang);
		// Cannot calculate the angle between two vectors if one of them is (0,0,0)
		// because the magnitude of (0,0,0) vector is 0. This causes a division by 0
		// in angle method, so the compiler returns an Error
		
	}

}