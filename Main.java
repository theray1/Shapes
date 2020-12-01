package projetPOO;

import java.awt.Point;
import java.util.Timer;

import javax.swing.*;

public class Main{
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Task());
		
		
		//Créer les formes et chemins disponibles
		CirclePath circlePath = new CirclePath(200, new Point(800, 500), 1);
		SpiralPath spiralPath = new SpiralPath(); // compléter l'instanciation du chemin spiral
		LemniscatePath lemniscatePath = new LemniscatePath();// compléter l'instaciation du chemin lemniscate
		
		Circle circle = new Circle(100, new Point(0,0));
		Square square = new Square(100, new Point(0,0));// compléter l'instanciation d'une forme carré
		
		//Créer le model et le controller utilisé par l'application
		Model model = new Model();
		Controller controller = new Controller();
		
		//Ajoute les chemins à la liste de chemins disponibles du model
		model.getListOfPaths().add(circlePath);
		//model.getListOfPaths().add(spiralPath);
		//model.getListOfPaths().add(lemniscatePath);
		
		
		//Définis le chemin et la forme par défaut du model
		model.setPath(circlePath);
		model.setShape(circle);
		
		//Créer la fenetre de l'application
		View view = new View("Shapes", 1920, 1015, controller, model);
		
		//Créer les liens entre les différents modules de l'application
		controller.setLinkedView(view);
		model.setLinkedView(view);
		view.setVisible(true);
		controller.setLinkedModel(model);
		
		//view.setResizable(true);
		
		//Ajoute les formes à la liste de formes disponibles de la fenetre graphique
		view.addShape(circle);
		view.addShape(square);
		
		//Créer la classe tickController, qui s'occupe d'éxecuter la programme en boucle
		TickController tickController = new TickController(model);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(tickController, 16, 16);
	}
}