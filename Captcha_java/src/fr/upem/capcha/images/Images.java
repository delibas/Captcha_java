
/**
* author : Élana Délio, Blactot Marc
*/

package fr.upem.capcha.images;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public interface Images {

	public void getFiles(File dir, String extension);
	public ArrayList<URL> getPhotos();
//	public ArrayList<URL> getRandomPhotosURL(int nbOfPhotos);
//	public ArrayList<URL> getRandomPhotoURL();
	public boolean isPhotoCorrect(ArrayList<URL> selectedImages);
	public void setImagesURL(ArrayList<URL> imagesUrl);
}
