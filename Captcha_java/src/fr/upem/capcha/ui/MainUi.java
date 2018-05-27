
/**
* author : Élana Délio, Blactot Marc
*/

package fr.upem.capcha.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import fr.upem.capcha.images.CategoryImages;
import fr.upem.capcha.images.Images;
import fr.upem.capcha.images.panneaux.Panneaux;
import fr.upem.capcha.images.ponts.Ponts;
import fr.upem.capcha.images.villes.Villes;

public class MainUi {
	
	private static ArrayList<URL> selectedImages = new ArrayList<URL>();
	
//	choisi la bonne instruction à afficher
	public static String question(String category) {
		String question = new String();
		switch(category) {
			case "panneaux":
				question = "qui affichent un panneaux";
				break;
			case "villes":
				question = "qui représentent une ville";
				break;
			case "ponts":
				question = "qui affichent un pont";
				break;
			default:
			break;
		}
		return question;
	}
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Capcha"); // Création de la fenÃªtre principale
		
		GridLayout layout = createLayout();  // Création d'un layout de type Grille avec 4 lignes et 3 colonnes
		
		frame.setLayout(layout);  // affection du layout dans la fenÃªtre.
		frame.setSize(1024, 768); // définition de la taille
		frame.setResizable(false);  // On définit la fenêtre comme non redimentionnable
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fenêtre on quitte le programme.
		 
		CategoryImages CatIm = new CategoryImages();
		ArrayList<URL> imagesURL = CatIm.getPhotos();
//		System.out.println(selectedImages);
		
		JButton okButton = createOkButton();

		for(URL my_url: imagesURL) {
			frame.add(createLabelImage(my_url));
		}
//		frame.add(createLabelImage("centre ville.jpg")); //ajouter des composants à  la fenêtre
//		frame.add(createLabelImage("le havre.jpg"));
//		frame.add(createLabelImage("panneau 70.jpg"));
//		frame.add(createLabelImage("panneaubleu-carre.jpeg"));
//		frame.add(createLabelImage("parking.jpg"));
//		frame.add(createLabelImage("route panneau.jpg"));
//		frame.add(createLabelImage("tour eiffel.jpg"));
//		frame.add(createLabelImage("ville espace verts.jpg"));
//		frame.add(createLabelImage("voie pieton.jpg"));
		
		String question = question("panneaux");
		
		frame.add(new JTextArea("Sélectionnez toutes les images " + question));
		
		
		frame.add(okButton);
		
		frame.setVisible(true);
	}
	
	
	private static GridLayout createLayout(){
		return new GridLayout(4,3);
	}
	
	private static JButton createOkButton(){
		return new JButton(new AbstractAction("Vérifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // faire des choses dans l'interface donc appeler cela dans la queue des événements
					
					@Override
					public void run() { // c'est un runnable
						System.out.println("J'ai cliqué sur Ok");
					}
				});
			}
		});
	}
	
	private static JLabel createLabelImage(URL my_url) throws IOException{
		
		final URL url = my_url; //Aller chercher les images !! IMPORTANT 
//		System.out.println(MainUi.class);
		System.out.println(url); 
		
		BufferedImage img = ImageIO.read(url); //lire l'image
		Image sImage = img.getScaledInstance(1024/3,768/4, Image.SCALE_SMOOTH); //redimentionner l'image
		
		final JLabel label = new JLabel(new ImageIcon(sImage)); // créer le composant pour ajouter l'image dans la fenêtre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'événement de souris
			private boolean isSelected = false;
			
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
		
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) { //ce qui nous intéresse c'est lorsqu'on clique sur une image, il y a donc des choses à  faire ici
				EventQueue.invokeLater(new Runnable() { 
					
					@Override
					public void run() {
						if(!isSelected){
							label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
							isSelected = true;
							selectedImages.add(url);
							
						}
						else {
							label.setBorder(BorderFactory.createEmptyBorder());
							isSelected = false;
							selectedImages.remove(url);
						}
						
					}
				});
				
			}
		});
		
		return label;
	}
}
