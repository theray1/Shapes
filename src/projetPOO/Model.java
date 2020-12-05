package projetPOO;


import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
/**
 * this class creates a model according to an MVC structure
 * @author theray1
 *
 */
public class Model {
	/**
	 * the current path of the model
	 */
	private Path path;
	/*
	 * the current shape of the model
	 */
	private Shape shape;
	/**
	 * the list of the paths know to the model
	 */
	private ArrayList<Path> listOfPaths;
	/**
	 * the index in the list of paths corresponding to the current path
	 */
	private int indexOfSelectedPath;
	/**
	 * the list of the shapes know to the model
	 */
	private ArrayList<Shape> listOfShapes;
	/**
	 * the index in the list of shapes corresponding to the current path
	 */
	private int indexOfSelectedShape;
	/**
	 * the integer that keeps track of the number of update
	 */
	private int updateIterator;
	/**
	 * the boolean that keeps track of whether or not the shape is moving 
	 */
	private boolean stop;
	/**
	 * the speed at which the shape moves, arbitrary unit
	 */
	private int speed;

	/**
	 * class constructor
	 */
	public Model() {
		this.setPath(null);
		this.setShape(null);
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
		listOfPaths.add(listOfPaths.size(), circlePath);
		listOfPaths.add(listOfPaths.size(), spiralPath);
		listOfPaths.add(listOfPaths.size(), lemniscatePath);
							
		//Définis le chemin et la forme par défaut du model
		setPath(circlePath);
		setShape(circle);
						
		//Ajoute les formes à la liste de formes disponibles de la fenetre graphique
		listOfShapes.add(circle);
		listOfShapes.add(square);
	}
	
	/**
	 * makes a the model progress by changing the the position of the shape and its rotation
	 */
	public void evolve(){
		if(updateIterator % (11 - speed) == 0 && !stop) {
			
			shape.moveTo(path.nextPoint());
			
			shape.rotate(5);
		}
		
		updateIterator ++;
	}
	
	/**
	 * adds an amount of units of speed
	 * @param addedSpeed the amount of speed units added
	 */
	public void addSpeed(int addedSpeed) {
		speed += addedSpeed;
	}
	
	/**
	 * removes an amount of units of speed
	 * @param removedSpeed the amount of speed units removed
	 */
	public void removeSpeed(int removedSpeed) {
		speed -= removedSpeed;
	}

	/**
	 * speed setter
	 * @param newSpeed the new speed of change of the model
	 */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	/**
	 * speed getter
	 * @return the current speed of the model
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * shape getter
	 * @return the current shape of the model
	 */
	public Shape getShape() {
		return shape;
	}
	
	/**
	 * shape setter
	 * @param newShape the new shape of the model
	 */
	public void setShape(Shape newShape) {
		shape = newShape;
	}

	/**
	 * path getter
	 * @return the current path of the model
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * path setter 
	 * @param newPath the new path of the model
	 */
	public void setPath(Path newPath) {
		path = newPath;
	}
	
	/**
	 * color setter
	 * @param newColor the new color of the model
	 */
	public void setColor(Color newColor) {
		shape.setColor(newColor);
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
	
	/**
	 * adds a shape to the list of shapes of the model
	 * @param shape the shape to be added to the listOfShape of the model
	 */
	public void addShape(Shape shape) {
		listOfShapes.add(shape);
	}
	
	/*
	 * flip the value of the stop variable, thus stopping or resuming the progress of the model
	 */
	public void stopTime() {
		stop = !stop;
	}
}
