package exam2_17;

import java.util.ArrayList;

public class SoundDensity implements SoundClassifyer {
	public String classification(Recording r) {
		
		double sf100 = spectralDensity(r.data, r.calcDuration(), 100);
		double sf400 = spectralDensity(r.data, r.calcDuration(), 400);
		double sf1000 = spectralDensity(r.data, r.calcDuration(), 1000);
		
		if(sf100 > sf400 && sf100 > sf1000) return "low";
		else if(sf400 > sf100 && sf400 > sf1000) return "medium";
		else return "high";
	}
	
	private double spectralDensity(ArrayList<Integer> samples, double t, double f) {
		int bigN = samples.size();
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		
		for (int n = 0; n < bigN; ++n) {
			sumCos += samples.get(n)* Math.cos(z*n);
			sumSin += samples.get(n) * Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		
		return norm * (sumCos*sumCos + sumSin*sumSin);
	}
}
