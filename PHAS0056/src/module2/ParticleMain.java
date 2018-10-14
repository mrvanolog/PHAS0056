package module2;

public class ParticleMain {

	public static void main(String[] args) {
		
		FallingParticle p = new FallingParticle(4.3, 2.4);
		
		// set initial height
		p.setH(5);
		
		// do the drop with dt = 0.5
		p.setV(0);    // drop the particle from rest
		p.drop(0.5);
		System.out.println("Data for the time interval 0.5s"); 
		System.out.println("Time taken to reach the bottom of the vessel: "+ p.getT()+ "s");
		System.out.println("Final velocity: "+ p.getV()+ " m/s");
		
		// do the drop with dt = 0.1
		p.setV(0);    // drop the particle from rest
		p.drop(0.1);
		System.out.println("\nData for the time interval 0.1s"); 
		System.out.println("Time taken to reach the bottom of the vessel: "+ p.getT()+ "s");
		System.out.println("Final velocity: "+ p.getV()+ " m/s");
		
		// do the drop with dt = 0.01
		p.setV(0);    // drop the particle from rest
		p.drop(0.01);
		System.out.println("\nData for the time interval 0.01s"); 
		System.out.println("Time taken to reach the bottom of the vessel: "+ p.getT()+ "s");
		System.out.println("Final velocity: "+ p.getV()+ " m/s");
		
		// do the drop with dt = 0.001
		p.setV(0);    // drop the particle from rest
		p.drop(0.001);
		System.out.println("\nData for the time interval 0.001s"); 
		System.out.println("Time taken to reach the bottom of the vessel: "+ p.getT()+ "s");
		System.out.println("Final velocity: "+ p.getV()+ " m/s");
		
		// do the drop with dt = 0.0001
		p.setV(0);    // drop the particle from rest
		p.drop(0.0001);
		System.out.println("\nData for the time interval 0.0001s"); 
		System.out.println("Time taken to reach the bottom of the vessel: "+ p.getT()+ "s");
		System.out.println("Final velocity: "+ p.getV()+ " m/s");
		
		System.out.println("\nBoth the time and the velocity decrease with the decrease of the time interval. This\n"
				+ "happens becasue in the actual calulations the final value of z is not exactly 0, but a negative value close to 0.\n"
				+ "With the decrease of the time increments, the difference between final value of z and 0 decreases, and\n"
				+ "the total distance travelled by a particle also decreases. As a result, it takes less time to travel that\n"
				+ "smaller distance and the velocity stops increasing (in negative direction) sooner, therefore the final velocity is\n"
				+ "smaller for smaller time increments.");
	}

}
