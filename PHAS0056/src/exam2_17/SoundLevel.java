package exam2_17;

public class SoundLevel implements SoundClassifyer {
	
	public String classification(Recording r) {
		double amp = r.calcAmp();
		
		if(amp < -20) return "loud";
		else return "quiet";
	}

}
