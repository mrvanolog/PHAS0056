package exam2;

import java.util.ArrayList;

/**
 * Interface to select specific images from
 * a given list of images
 */
public interface ImageSelector {
	ArrayList<Image> select(ArrayList<Image> images);
}
