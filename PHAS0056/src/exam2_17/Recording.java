package exam2_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recording {
	protected String name;
	protected double samplingFq; 
	protected int sampleN, maxAmp;
	protected ArrayList<Integer> data = new ArrayList<Integer>();
	private double sumAmp = 0;
	
	public Recording(String name, BufferedReader b) throws IOException {
		String line = b.readLine();
		Scanner s = new Scanner(line);
		
		this.name = name;
		this.samplingFq = Double.parseDouble(s.next());
		this.sampleN = s.nextInt();
		this.maxAmp = s.nextInt();
		
		while ((line = b.readLine()) != null) {
			s = new Scanner(line);
			int num = s.nextInt();
			this.data.add(num);
			this.sumAmp += Math.pow(num, 2);
		}
		
		s.close();
	}
	
	// calculate the duration of the recording 
	public double calcDuration() {
		return sampleN / samplingFq;
	}
	
	// calculate the amplitude of the signal in dBFS
	public double calcAmp() {
		double aRMS;
		
		aRMS = Math.sqrt(sumAmp / sampleN);
		
		return 20 * Math.log10(aRMS/maxAmp);		
	}
}
