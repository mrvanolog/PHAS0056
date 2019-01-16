package exam2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Calculates Matthews Correlation Coefficient (MCC) for
 * lion images and lion candidates images.
 */
public class ExamPart3 {
	
	/**
	 * Calculates the Matthews Correlation Coefficient (MCC) 
	 * @param images array of Image objects
	 * @param mode "half" to use SelectCandidates, "full" to use
	 * SelectFullCandidates to determine the candidates 
	 * @return MCC
	 */
	public static double calculateMCC(ArrayList<Image> images, String mode) {
		int K, L, P = 0, N, TP = 0, TN, FP, FN;
		double MCC;
		ArrayList<Image> arrayL, arrayP;
		
		K = images.size();  // total number of images
		
		SelectSpecies ss = new SelectSpecies("lion");
		arrayL = ss.select(images);  // array of lion images
		L = arrayL.size();  // number of lions
		
		// determine the mode and use appropriate selctor class
		if(mode.equals("half")) {
			SelectCandidates sc = new SelectCandidates("lion");
			arrayP = sc.select(images);  // array of lion candidates
			P = arrayP.size();   // number of lion candidates
			
			for(Image img1 : arrayL) {
				for(Image img2 : arrayP) {
					if(img1.id == img2.id) {
						TP++; // number of true positives
					}
				}
			}
		}
		else if(mode.equals("full")) {
			SelectFullCandidates sfc = new SelectFullCandidates("lion");
			arrayP = sfc.select(images); // array of lion candidates
			P = arrayP.size();   // number of lion candidates
			
			for(Image img1 : arrayL) {
				for(Image img2 : arrayP) {
					if(img1.id == img2.id) {
						TP++; // number of true positives
					}
				}
			}
		}
		else {
			System.out.println("You've entered the wrong mode name, dumb a**!");
			System.exit(-1);
		}
		
		N = K - P;    // number of negatives
		FP = P - TP;  // number of false positives
		FN = L- TP;   // number of false negatives
		TN = N - FN;  // number of true negatives
		
		MCC = (TP*TN - FP*FN) / Math.sqrt((TP+FP) * (TP+FN) * (TN+FP) * (TN+FN));
		
		return MCC;
	}

	public static void main(String[] args) throws IOException {
		// create an array of Image objects
		ArrayList<Image> images = ExamPart1.createArray();
		
		System.out.println("MCC for the results calculated in section 2: "+calculateMCC(images, "half"));
		System.out.println("MCC for when all volunteers agree on classification: "+calculateMCC(images, "full"));

	}

}
