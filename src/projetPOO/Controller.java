package projetPOO;


import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.SwingUtilities;
/**
 * this class creates a controller according to an MVC structure
 * @author theray1
 *
 */
public class Controller {
	/**
	 * the view the controller sends requests to
	 */
	private View linkedView;
	/**
	 * the model which this controller is gonna upate
	 */
	private Model linkedModel;

	
	/**
	 * class constructor
	 */
	public Controller() {
		this.linkedModel = null;
		this.linkedView = null;
	}
	
	/**
	 * main method of the program, which start a progression of the model, and updates the drawing panel accordingly
	 */
	public void evolve() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				linkedModel.evolve();
			}
			
		});
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				linkedView.update();
			}
			
		});

	}
	
	/**
	 * linkedModel setter
	 * @param newLinkedModel the new model linked to the controller
	 */
	public void setLinkedModel(Model newLinkedModel) {
		linkedModel = newLinkedModel;
	}
	
	/**
	 * linkedView setter
	 * @param newLinkedView
	 */
	public void setLinkedView(View newLinkedView) {
		linkedView = newLinkedView;
	}
	
	/**
	 * changes the current shape to a new one, and clears the canvas
	 * @param newShape the new shape used by the model, amongst the shapes in AvailableShapes
	 */
	public void changeShapeSelectionTo(AvailableShape newShape) {// PLEASE NOTE : this only works because for each loops always iterate over enums in the same order
		
		if(newShape == AvailableShape.circle) {
			linkedModel.setShape(new Circle(50, new Point(0,0)));
		}
		
		if(newShape == AvailableShape.square) {
			linkedModel.setShape(new Square(50, new Point(0,0)));
		}
		
		linkedModel.getShape().moveTo(linkedModel.getPath().nextPoint());
		
		linkedView.getLinkedDrawingPanel().resetCanvas();
	}

	/**
	 * changes the current path to a new one, and clears the canvas
	 * @param newPath the new shape used by the model, amongst the shapes in AvailablePaths
	 */
	public void changePathSelectionTo(AvailablePath newPath) {// PLEASE NOTE : this only works because for each loops always iterate over enums in the same order
		
		if(newPath == AvailablePath.circle) {
			linkedModel.setPath(new CirclePath(200, new Point(800, 500)));
		}
		
		if(newPath == AvailablePath.spiral) {
			linkedModel.setPath(new SpiralPath(new Point(800, 500), 4));
		}
		
		if(newPath == AvailablePath.lemniscate) {
			linkedModel.setPath(new LemniscatePath(new Point(400, 450), new Point(800, 450)));
		}
		
		linkedModel.getShape().moveTo(linkedModel.getPath().nextPoint());
		
		linkedView.getLinkedDrawingPanel().resetCanvas();
	}

	/**
	 * randomly changes the color of the current shape
	 */
	public void changeColor() {
	    int pick1 = new Random().nextInt(255);
	    int pick2 = new Random().nextInt(255);
	    int pick3 = new Random().nextInt(255);
	    
		linkedModel.getShape().setColor(new Color(pick1, pick2, pick3));
	}
	
	/**
	 * Elevate the current speed by one unity, maximum of 10
	 */
	public void accelerate() {
		if(linkedModel.getSpeed() >= 10) {
			linkedModel.setSpeed(10);
		}else {
			linkedModel.addSpeed(1);
		}
	}
	
	/**
	 * lowers the current speed by one unity, minimum of 1
	 */
	public void decelerate() {
		if(linkedModel.getSpeed() <= 1) {
			linkedModel.setSpeed(1);
		}else {
			linkedModel.removeSpeed(1);
		}
	}

	public void stopTime() {
		linkedModel.stopTime();
	}
}
