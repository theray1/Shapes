package projetPOO;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame{
	
	public View(String title, int w, int h) {
		super(title);
		build(w, h);
	}
	
	private void build(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		buildContentPane(); //TODO (contenu)
		setLocationRelativeTo(null); //set la position de la fenetre au milieu de l'écran
		setResizable(false); //la taille ne peut pas être modifiée
		pack(); // dimensionnement des composants (?);
		
	}
	
	private void buildContentPane() {
		JLabel label = new JLabel("Welcome!", JLabel.CENTER);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().add(label);
	}
	
}
