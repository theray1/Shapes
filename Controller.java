package projetPOO;


import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.SwingUtilities;

public class Controller {
	private View linkedView;
	private Model linkedModel;
	private int updateIterator;
	private boolean stop;
	
	public Controller() {
		this.linkedModel = null;
		this.linkedView = null;
		this.stop = false;
		updateIterator = 0;
	}
	
	public Controller(Model model, View linkedView) {
		this.linkedModel = model;
		this.linkedView = linkedView;
		this.stop = false;
		this.updateIterator = 0;
	}
	
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
	
	public void setLinkedModel(Model newLinkedModel) {
		linkedModel = newLinkedModel;
	}
	
	public void setLinkedView(View newLinkedView) {
		linkedView = newLinkedView;
	}
	
	public void changeShapeSelectionTo(AvailableShape newShape) {
		int i = 0;
		for(AvailableShape sh : AvailableShape.values()) {
			if(sh.equals(newShape)) {
				linkedModel.setIndexOfSelectedShape(i);
			}
		i++;
		}
		
		linkedModel.setShape((Shape) linkedModel.getListOfShapes().get(linkedModel.getIndexOfSelectedShape()));
		
		linkedView.getLinkedDrawingPanel().resetCanvas();
	}

	public void changePathSelectionTo(AvailablePath newPath) {// PLEASE NOTE : this only works because 
		int i = 0;
		for(AvailablePath pa : AvailablePath.values()) {
			if(pa.equals(newPath)) {
				linkedModel.setIndexOfSelectedPath(i);
			}
		i++;
		}
		
		linkedModel.setPath(linkedModel.getListOfPaths().get(linkedModel.getIndexOfSelectedPath()));
		
		linkedView.getLinkedDrawingPanel().resetCanvas();
	}

	public void changeColor() {
	    
	    int pick1 = new Random().nextInt(255);
	    int pick2 = new Random().nextInt(255);
	    int pick3 = new Random().nextInt(255);
	    
		linkedModel.getShape().setColor(new Color(pick1, pick2, pick3));
	}
	
	public void accelerate() {
		if(linkedModel.getSpeed() >= 10) {
			linkedModel.setSpeed(10);
		}else {
			linkedModel.addSpeed(1);
		}
	}

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
