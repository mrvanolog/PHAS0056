package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Reads data about images and stores them in appropriate data structures
 * prints the total number of images, number of images classified by
 * at least one volunteer and prints details of images that has been
 * classified by at least 10 volunteers.
 *
 */
public class ExamPart1 {
	/** 
	 * Creates BufferedReader object from a URL
	 * @param url string containing a url
	 * @return BufferedReader object
	 * @throws IOException
	 */
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	/**
	 * Creates an array of Image objects from 3 web files provided 
	 * for final exam: locations.txt, classification.txt and expert.txt
	 * @return array of Image objects
	 * @throws IOException
	 */
	public static ArrayList<Image> createArray() throws IOException {
		ArrayList<Image> images = new ArrayList<Image>();
		
		// create BufferedReader with info about location and expert's classification
		BufferedReader br1 = brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "0056/exam-data/2018-19/locations.txt");
		BufferedReader br2 = brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "0056/exam-data/2018-19/expert.txt");
		String line1, line2;
		// fill array with data
		while((line1 = br1.readLine()) != null) {
			line2 = br2.readLine();
			images.add(new Image(line1, line2));
		}
		
		// create an array of volunteers' classifications
		ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
		br1 = brFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "0056/exam-data/2018-19/classification.txt");
		// fill array with data
		while((line1 = br1.readLine()) != null) {
			volunteers.add(new Volunteer(line1));
		}
		
		// complete the information in images array
		for(Image img : images) {
			// add all of the volunteer classifications to 
			// image array of names
			for(Volunteer vol : volunteers) {
				if(vol.id == img.id) {
					img.namesVol.add(vol.name);
				}
			}
		}
		
		return images;
	}

	public static void main(String[] args) throws IOException {		
		// create an array of Image objects
		ArrayList<Image> images =createArray();
		
		// output and calculate the information
		System.out.println("The total number of images: "+images.size());
		
		int counter = 0;  // counter of number of images identified by at least one volunteer
		// count the number of images identified by at least one volunteer
		for(Image img : images) {
			if(img.namesVol.size() != 0) {
				counter++;
			}
		}
		System.out.println("Number of images identified by at least one volunteer: "+counter);
		System.out.println();
		System.out.println("/////Details of each image that has been classified by at least 10 volunteers\\\\\\\\\\");
		System.out.println();
		// go through each image and output info about each 
		// each image that has been classified by at least 10 volunteers
		for(Image img : images) {
			if(img.namesVol.size() > 9) {
				System.out.println(img);
				System.out.println();
			}
		}
	}

}
