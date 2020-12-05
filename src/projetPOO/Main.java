package projetPOO;


import java.awt.Point;
import java.util.Timer;

import javax.swing.*;

public class Main{
	public static void main(String[] args) throws InterruptedException {
		
		//Créer le model et le controller utilisé par l'application
		Controller controller = new Controller();
		Model model = new Model();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//Créer la fenetre de l'application
				View view = new View("Shapes", 1920, 1015, controller, model);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.setVisible(true);
				
				//Créer les liens entre les différents modules de l'application
				controller.setLinkedView(view);
				controller.setLinkedModel(model);
			}
			
		});
		
		//Thread.sleep(200); //in case of weird fuckery happening at the start of the application, please uncomment this line, it might fix it
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//Créer la classe tickController, qui s'occupe d'éxecuter la programme en boucle
				TickController tickController = new TickController(controller);
				Timer timer = new Timer();
				timer.scheduleAtFixedRate(tickController, 16, 16);
			}
			
		});
		
	}
}