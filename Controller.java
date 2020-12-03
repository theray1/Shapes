package projetPOO;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Controller {
	private View linkedView;
	private Model linkedModel;
	
	public Controller() {
		this.linkedModel = null;
		this.linkedView = null;
	}
	
	public Controller(Model model, View linkedView) {
		this.linkedModel = model;
		this.linkedView = linkedView;
	}
	
	public void setLinkedModel(Model newLinkedModel) {
		this.linkedModel = newLinkedModel;
	}
	
	public void setLinkedView(View newLinkedView) {
		this.linkedView = newLinkedView;
	}
	
	public void changeShapeSelectionTo(AvailableShape newShape) {
		int i = 0;
		for(AvailableShape sh : AvailableShape.values()) {
			if(sh.equals(newShape)) {
				this.linkedModel.setIndexOfSelectedShape(i);
			}
		i++;
		}
		
		this.linkedView.getLinkedDrawingPanel().resetCanvas();
		
		this.linkedModel.setShape((Shape) this.linkedModel.getListOfShapes().get(this.linkedModel.getIndexOfSelectedShape()));
		
		this.linkedModel.getLinkedView().getLinkedDrawingPanel().setSelectedShape(this.linkedModel.getShape());
	}

	public void changePathSelectionTo(AvailablePath newPath) {// PLEASE NOTE : this only works because 
		int i = 0;
		for(AvailablePath pa : AvailablePath.values()) {
			if(pa.equals(newPath)) {
				this.linkedModel.setIndexOfSelectedPath(i);
			}
		i++;
		}
		
		this.linkedView.getLinkedDrawingPanel().resetCanvas();
		
		this.linkedModel.setPath(this.linkedModel.getListOfPaths().get(this.linkedModel.getIndexOfSelectedPath()));
	}

	public void changeColor() {
	    
	    int pick1 = new Random().nextInt(255);
	    int pick2 = new Random().nextInt(255);
	    int pick3 = new Random().nextInt(255);
	    
		this.linkedModel.getShape().setColor(new Color(pick1, pick2, pick3));
	}
	
	public void accelerate() {
		System.out.println("accelerate");
		if(this.linkedModel.getSpeed() >= 10) {
			this.linkedModel.setSpeed(10);
		}else {
			this.linkedModel.addSpeed(1);
		}
	}

	public void decelerate() {
		System.out.println("decelerate");
		if(this.linkedModel.getSpeed() <= 1) {
			this.linkedModel.setSpeed(1);
		}else {
			this.linkedModel.removeSpeed(1);
		}
	}


	public void updateShapeSelection() {
		linkedView.getLinkedDrawingPanel().setSelectedShape((Shape) this.linkedModel.getListOfShapes().get(this.linkedModel.getIndexOfSelectedShape()));
	}

	public void stopTime() {
		this.linkedModel.stopLoop();
	}
}
