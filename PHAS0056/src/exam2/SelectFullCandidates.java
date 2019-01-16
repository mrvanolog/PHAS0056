package exam2;

import java.util.ArrayList;

/**
 * Selects images that are candidates for identification as a
 * given species.
 */
public class SelectFullCandidates implements ImageSelector {
	private String name;  // name of the species of interest
	
	/**
	 * @param name name of a species you're looking for
	 */
	public SelectFullCandidates(String name) {
		this.name = name;
	}
	
	/**
	 * Selects images that were classified as a given species by
	 * all of the volunteers.
	 * @param images array of Image objects 
	 */
	@Override
	public ArrayList<Image> select(ArrayList<Image> images) {
		ArrayList<Image> subSet = new ArrayList<Image>();
		
		// go through all images and count how many volunteers
		// classified that image as a given species
		for(Image img : images) {
			int counter = 0;
			for(String name : img.namesVol) {
				if(name.equals(this.name)) {
					counter++;
				}
			}
			
			// check if that's more than a half of the volunteers
			if(counter == img.namesVol.size()) {
				subSet.add(img);
			}
		}
		
		return subSet;
	}
}