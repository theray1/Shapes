package projetPOO;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Model {
	private Path path;
	private Shape shape;
	private int speed;
	private int updateIterator;
	private View linkedView;
	private ArrayList<Path> listOfPaths;
	private int indexOfSelectedPath;
	private ArrayList<Drawable> listOfShapes; 
	private int indexOfSelectedShape;
	private boolean stop;
	
	public View getLinkedView() {
		return this.linkedView;
	}
	
	public Model() {
		this.setPath(null);
		this.setShape(null);
		this.setLinkedView(null);
		this.listOfPaths = new ArrayList<>();
		this.setIndexOfSelectedPath(0);
		this.setListOfShapes(new ArrayList<>());
		this.setIndexOfSelectedShape(0);
		this.speed = 5;
		this.stop = false;
		
		//Créer les formes et chemins disponibles
		CirclePath circlePath = new CirclePath(200, new Point(800, 500));
		SpiralPath spiralPath = new SpiralPath(new Point(800, 500)); // compléter l'instanciation du chemin spiral
		LemniscatePath lemniscatePath = new LemniscatePath(100, new Point(400, 450), new Point(800, 450));// compléter l'instaciation du chemin lemniscate
				
		Circle circle = new Circle(50, new Point(0,0));
		Square square = new Square(50, new Point(0,0));// compléter l'instanciation d'une forme carré
				
		//Ajoute les chemins à la liste de chemins disponibles du model
		this.getListOfPaths().add(this.getListOfPaths().size(), circlePath);
		this.getListOfPaths().add(this.getListOfPaths().size(), spiralPath);
		this.getListOfPaths().add(this.getListOfPaths().size(), lemniscatePath);
							
		//Définis le chemin et la forme par défaut du model
		this.setPath(circlePath);
		this.setShape(circle);
						
		//Ajoute les formes à la liste de formes disponibles de la fenetre graphique
		this.addShape(circle);
		this.addShape(square);
	}
	
	public Model(Path path, Shape shape, View linkedView) {
		this.setPath(path);
		this.setShape(shape);
		this.linkedView = linkedView;
		this.setListOfPaths(new ArrayList<>());
		this.setIndexOfSelectedPath(0);
		this.setListOfShapes(new ArrayList<>());
		this.setIndexOfSelectedShape(0);
		this.speed = 5;
		this.stop = false;
		
		//Créer les formes et chemins disponibles
		CirclePath circlePath = new CirclePath(200, new Point(800, 500));
		SpiralPath spiralPath = new SpiralPath(new Point(800, 500)); // compléter l'instanciation du chemin spiral
		LemniscatePath lemniscatePath = new LemniscatePath(100, new Point(400, 450), new Point(800, 450));// compléter l'instaciation du chemin lemniscate
				
		Circle circle = new Circle(50, new Point(0,0));
		Square square = new Square(50, new Point(0,0));// compléter l'instanciation d'une forme carré
						
		//Ajoute les chemins à la liste de chemins disponibles du model
		this.getListOfPaths().add(this.getListOfPaths().size(), circlePath);
		this.getListOfPaths().add(this.getListOfPaths().size(), spiralPath);
		this.getListOfPaths().add(this.getListOfPaths().size(), lemniscatePath);
							
		//Définis le chemin et la forme par défaut du model
		this.setPath(circlePath);
		this.setShape(circle);
								
		//Ajoute les formes à la liste de formes disponibles de la fenetre graphique
		this.addShape(circle);
		this.addShape(square);
	}
	
	public void setLinkedView(View newLinkedView) {
		this.linkedView = newLinkedView;
	}
	
	public void evolve(){
		
		if(updateIterator % (11 - speed) == 0 && !stop) {
			Point temp = new Point(shape.getReferencePoint());
			
			getShape().moveTo(getPath().nextPoint());
			
			if(!(shape.getReferencePoint().equals(temp))) {// ce if permet de rotate le forme seulement si elle change de position, afin d'éviter de voir les rformes tourner sur elle meme, a basse vitesse
				getShape().rotate(5);
			}
			
			this.updateDrawingPanel();
			
			System.out.println(this.speed);
		}
		
		if(updateIterator > 100) {
			updateIterator = 0;
		}
		
		updateIterator ++;
		
		
	}
	
	public void addSpeed(int addedSpeed) {
		this.speed += addedSpeed;
	}
	
	public void removeSpeed(int removedSpeed) {
		this.speed -= removedSpeed;
	}
	
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	public void setColor(Color c) {
		this.getShape().setColor(c);
	}

	public ArrayList<Path> getListOfPaths() {
		return listOfPaths;
	}

	public void setListOfPaths(ArrayList<Path> listOfPaths) {
		this.listOfPaths = listOfPaths;
	}

	public int getIndexOfSelectedPath() {
		return indexOfSelectedPath;
	}

	public void setIndexOfSelectedPath(int indexOfSelectedPath) {
		this.indexOfSelectedPath = indexOfSelectedPath;
	}

	public ArrayList<Drawable> getListOfShapes() {
		return listOfShapes;
	}

	public void setListOfShapes(ArrayList<Drawable> listOfShapes) {
		this.listOfShapes = listOfShapes;
	}

	public int getIndexOfSelectedShape() {
		return indexOfSelectedShape;
	}

	public void setIndexOfSelectedShape(int indexOfSelectedShape) {
		this.indexOfSelectedShape = indexOfSelectedShape;
	}

	public void addShape(Drawable shape) {
		this.listOfShapes.add(shape);
	}

	public void updateDrawingPanel() {
		linkedView.update();
	}

	public void stopLoop() {
		this.stop = !stop;
	}
}
