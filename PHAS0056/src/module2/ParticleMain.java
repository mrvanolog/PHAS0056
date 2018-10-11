package module2;

public class ParticleMain {

	public static void main(String[] args) {
		
		FallingParticle p = new FallingParticle(4.3, 2.4);
		
		// set initial height
		p.setH(5);
		
		System.out.println("velocity: "+ p.getV());
		
		// do the drop with dt = 0.5
		p.drop(0.0001);
		
		System.out.println("final position: "+ p.getZ());

	}

}
