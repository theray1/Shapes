package projetPOO;


import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Model {
	private Path path;
	private Shape shape;
	private int speed;
	private View linkedView;
	private ArrayList<Path> listOfPaths;
	private int indexOfSelectedPath;
	private ArrayList<Shape> listOfShapes;
	private int indexOfSelectedShape;
	private int updateIterator;
	private boolean stop;

	public Model() {
		this.setPath(null);
		this.setShape(null);
		this.setLinkedView(null);
		this.listOfPaths = new ArrayList<>();
		this.setIndexOfSelectedPath(0);
		this.setListOfShapes(new ArrayList<>());
		this.setIndexOfSelectedShape(0);
		this.speed = 5;
		stop = false;
		updateIterator = 0;
		
		
		//Créer les formes et chemins disponibles
		CirclePath circlePath = new CirclePath(200, new Point(800, 500));
		SpiralPath spiralPath = new SpiralPath(new Point(800, 500), 4); // compléter l'instanciation du chemin spiral
		LemniscatePath lemniscatePath = new LemniscatePath(new Point(400, 450), new Point(800, 450));// compléter l'instaciation du chemin lemniscate
				
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
		linkedView = newLinkedView;
	}
	
	public void evolve(){
		if(updateIterator % (11 - getSpeed()) == 0 && !stop) {
			
			getShape().moveTo(getPath().nextPoint());
			
			getShape().rotate(5);
		}
		
		updateIterator ++;
	}

	public View getLinkedView() {
		return linkedView;
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
		return speed;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape newShape) {
		shape = newShape;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path newPath) {
		path = newPath;
	}
	
	public void setColor(Color c) {
		shape.setColor(c);
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

	public ArrayList<Shape> getListOfShapes() {
		return listOfShapes;
	}

	public void setListOfShapes(ArrayList<Shape> listOfShapes) {
		this.listOfShapes = listOfShapes;
	}

	public int getIndexOfSelectedShape() {
		return indexOfSelectedShape;
	}

	public void setIndexOfSelectedShape(int indexOfSelectedShape) {
		this.indexOfSelectedShape = indexOfSelectedShape;
	}

	public void addShape(Shape shape) {
		listOfShapes.add(shape);
	}
	
	public void stopTime() {
		stop = !stop;
	}
}
