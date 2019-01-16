package exam2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Stores the full information about the image
 *
 */
public class Image {
	protected int id;          // id of an image
	protected double lat, lon; // latitude and longitude of the
							   // location where the image was taken
	// names of the species identified by volunteers 
	protected ArrayList<String> namesVol = new ArrayList<String>();
	protected String nameExp;  // name of the species identified by an expert
	
	/**
	 * @param line1 string containing info about
	 * image location
	 * @param line2 string containing info about
	 * image classification by an expert
	 */
	public Image(String line1, String line2) {
		Scanner s1 = new Scanner(line1);
		Scanner s2 = new Scanner(line2);
		
		this.id = s1.nextInt();
		this.lat = Double.parseDouble(s1.next());
		this.lon = Double.parseDouble(s1.next());
		
		s2.next();
		s2.next();
		this.nameExp = s2.next();
		
		s1.close();
		s2.close();
	}
	
	public String toString() {
		return "id: "+id+"\n"+"Latitude: "+lat+", Longitude: "+lon+"\n"
						+"Species identified by an expert: "+nameExp+"\n"
						+"Species identifications by volunteers: "+namesVol;
	}

}
