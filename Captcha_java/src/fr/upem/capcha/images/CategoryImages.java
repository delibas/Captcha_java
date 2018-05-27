
/**
* author : �lana D�lio, Blactot Marc
*/

package fr.upem.capcha.images;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import fr.upem.capcha.images.panneaux.Panneaux;
import fr.upem.capcha.images.ponts.Ponts;
import fr.upem.capcha.images.villes.Villes;
import fr.upem.capcha.ui.MainUi;

public class CategoryImages implements Images {
	private ArrayList<URL> imagesURL = new ArrayList<URL>();
	
// 	R�cup�re tous les fichiers avec l'extension .jpg
	public void getFiles(File dir, String extension) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file, extension);
			} else {
//				if (file.getName().endsWith(extension) || file.getName().endsWith(".jpeg")) {
				if (file.getName().endsWith(extension)) {
//					Cr�e une url pour chaque file gr�ce � son nom de dossier parent, identique � sa classe
					switch(file.getParentFile().getName()) {
						case "panneaux":
							this.imagesURL.add(Panneaux.class.getResource(file.getName()));
							break;
						case "villes":
							this.imagesURL.add(Villes.class.getResource(file.getName()));
							break;
						case "ponts":
							this.imagesURL.add(Ponts.class.getResource(file.getName()));
							break;
						case "ui":
							this.imagesURL.add(MainUi.class.getResource(file.getName()));
							break;
						default:
						break;
					}
				}
			}
		}
	}
//	Retourne l'ArrayList<URL>	
	public ArrayList<URL> getPhotos() {
		File dir = new File("C:\\Users\\ASUS\\eclipse-workspace\\Captcha_java\\Captcha_java\\src");
		getFiles(dir, ".jpg");
		return this.imagesURL;
	};
/*	
*	public ArrayList<URL> getRandomPhotosURL(int nbOfPhotos) {
*		
*	}
*	
*	public ArrayList<URL> getRandomPhotoURL() {
*		
*	}
*/	
	public boolean isPhotoCorrect(ArrayList<URL> selectedImages) {
		for(URL url: selectedImages) {
			if(url.getClass().equals((Panneaux.class)));
				return true;
		}
		return false;
	}
	
	public void setImagesURL(ArrayList<URL> imagesUrl) {
		this.imagesURL = imagesUrl;
	}
}
