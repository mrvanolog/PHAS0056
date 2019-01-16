package exam2;

import java.util.ArrayList;
import java.io.IOException;

/**
 * Prints the details of images that show lions, as identified
 * by the expert and shows lion candidates.
 */
public class ExamPart2 {

	public static void main(String[] args) throws IOException {
		// create an array of Image objects
		ArrayList<Image> images = ExamPart1.createArray();
		// create selector objects
		SelectSpecies ss = new SelectSpecies("lion");
		SelectCandidates sc = new SelectCandidates("lion");
		// create subsets of images
		ArrayList<Image> subSet1 = ss.select(images);
		ArrayList<Image> subSet2 = sc.select(images);
		
		// print out the results
		System.out.println("All images that show lions:\n");
		for(Image img : subSet1) {
			System.out.println(img);
			System.out.println();
		}
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("All images that show lion candidates:\n");
		for(Image img : subSet2) {
			System.out.println(img);
			System.out.println();
		}

	}

}
