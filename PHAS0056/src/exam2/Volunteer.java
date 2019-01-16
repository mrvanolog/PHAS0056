package exam2;

import java.util.Scanner;

/**
 * Stores information of how volunteer
 * has classified the image
 */
public class Volunteer {
	protected int id, idVol;  // id of the image and volunteer
	protected String name;    // name of the species 
	
	/**
	 * 
	 * @param line string containing info about
	 * image classification by a volunteer
	 */
	public Volunteer(String line) {
		Scanner s = new Scanner(line);
		
		this.id = s.nextInt();
		this.idVol = s.nextInt();
		this.name = s.next();
		
		s.close();
	}
}
