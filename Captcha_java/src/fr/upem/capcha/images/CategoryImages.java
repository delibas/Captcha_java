package fr.upem.capcha.images;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class CategoryImages implements Images {
	private ArrayList<URL> imagesURL = new ArrayList<URL>();
	
	public void getAllImages(File dir, String extension, ArrayList<URL> imagesURL) {

		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getAllImages(file, extension, imagesURL);
			} else {
				if (file.getName().endsWith(extension)) {
					System.out.println(this.getClass().getResource(file.getName()));
//					URI uri = new URI("file:",extension);
//					imagesURL.add("file:" + file.getAbsolutePath());					
				}
			}
		}
	}
	
	public ArrayList<URL> getPhotos() {
		return this.imagesURL;
	};
//	
//	public ArrayList<URL> getRandomPhotosURL(int nbOfPhotos) {
//		
//	}
//	
//	public ArrayList<URL> getRandomPhotoURL() {
//		
//	}
//	
//	public boolean isPhotoCorrect() {
//		
//	}
	
	public void setImagesURL(ArrayList<URL> imagesUrl) {
		this.imagesURL = imagesUrl;
	}
}
