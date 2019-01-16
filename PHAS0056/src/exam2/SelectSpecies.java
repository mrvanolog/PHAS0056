package exam2;

import java.util.ArrayList;

/**
 * Selects images that show (according to the expert classification)
 * a given species.
 */
public class SelectSpecies implements ImageSelector {
	private String name;  // name of the species of interest
	
	/**
	 * @param name name of a species you're looking for
	 */
	public SelectSpecies(String name) {
		this.name = name;
	}
	
	/**
	 * Finds the images that show a given species (according to the expert)
	 * @param images array of Image objects
	 */
	@Override
	public ArrayList<Image> select(ArrayList<Image> images) {
		ArrayList<Image> subSet = new ArrayList<Image>();
		
		// go through all images and find the ones
		// with the correct names
		for(Image img : images) {
			if(name.equals(img.nameExp)) {
				subSet.add(img);
			}
		}
		
		return subSet;
	}

}
