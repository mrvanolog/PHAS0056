package exam2_17;

public class SoundDuration implements SoundClassifyer {
	
	public String classification(Recording r) {
		double dur = r.calcDuration();
		
		if(dur>1) return "long";
		else return "short";
	}
}
