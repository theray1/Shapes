package projetPOO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public View(String title, int w, int h) {
		super(title);
		build(w, h);
	}
	
	private void build(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		buildContentPane(); //TODO (contenu)
		setLocationRelativeTo(null); //set la position de la fenetre au milieu de l'écran
		setResizable(true); //la taille ne peut pas être modifiée
		pack(); // dimensionnement des composants (?);
		
	}
	
	private void buildContentPane() {
		JLabel label = new JLabel("Welcome!", JLabel.CENTER);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().add(label, BorderLayout.WEST);
		
		JButton testButton = new JButton("This is not a button");
		getContentPane().add(testButton, BorderLayout.EAST);
		testButton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("wtf am i doing");
						}
					}
		);
		
		DrawingPanel redDisk = new DrawingPanel();
		getContentPane().add(redDisk, BorderLayout.CENTER);
		
		
	}
	
	private class EqListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			try {
				System.out.println("how did i get here");
			}
			catch(Exception e) {
				System.out.println("what? how?");
			}
		}
		
	}
	
}
