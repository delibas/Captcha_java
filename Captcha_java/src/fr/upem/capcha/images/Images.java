package fr.upem.capcha.images;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public interface Images {

	public void getAllImages(File dir, String extension, ArrayList<URL> imagesURL);
	public ArrayList<URL> getPhotos();
//	public ArrayList<URL> getRandomPhotosURL(int nbOfPhotos);
//	public ArrayList<URL> getRandomPhotoURL();
//	public boolean isPhotoCorrect();
	public void setImagesURL(ArrayList<URL> imagesUrl);
}
