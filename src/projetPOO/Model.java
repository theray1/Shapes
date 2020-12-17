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
		this.speed = 5;
		stop = false;
		updateIterator = 0;
		
		//Définis le chemin et la forme par défaut du model
		setPath(new CirclePath(200, new Point(800, 500)));
		setShape(new Circle(50, new Point(0,0)));
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
	
	public static Shape shapeFactory(AvailableShape newShape) {
		switch(newShape) {
		  case circle:
			  return new Circle(50, new Point(0,0));
		  case square:
			  return new Square(50, new Point(0,0));
		  default:
			  return null;
		}
	}
	
	public static Path pathFactory(AvailablePath newPath) {
		switch(newPath) {
		  case circle:
			  return new CirclePath(200, new Point(800, 500));
		  case spiral:
			  return new SpiralPath(new Point(800, 500), 4);
		  case lemniscate:
			  return new LemniscatePath(new Point(400, 450), new Point(800, 450));
		  default:
		    return null;
		}

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
	
	/*
	 * flip the value of the stop variable, thus stopping or resuming the progress of the model
	 */
	public void stopTime() {
		stop = !stop;
	}
}
