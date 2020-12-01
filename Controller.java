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
		Object currentShape = this.linkedView.getLinkedDrawingPanel().getListOfShapes().get(this.linkedView.getLinkedDrawingPanel().getIndexOfSelectedShape());
		
		if(!currentShape.getClass().equals((new Circle(0, new Point(0,0)).getClass())) && newShape.equals(AvailableShape.circle)) {
			this.linkedView.getLinkedDrawingPanel().resetCanvas(this.linkedView.getLinkedDrawingPanel().getGraphics());
			this.linkedView.getLinkedDrawingPanel().setCurrentShapeTo(AvailableShape.circle);
		}
		
		if(!currentShape.getClass().equals((new Square(0, new Point(0,0)).getClass())) && newShape.equals(AvailableShape.square)) {
			this.linkedView.getLinkedDrawingPanel().resetCanvas(this.linkedView.getLinkedDrawingPanel().getGraphics());
			this.linkedView.getLinkedDrawingPanel().setCurrentShapeTo(AvailableShape.square);
		}
		
		this.linkedModel.updateShape();
	}

	public void changePathSelectionTo(AvailablePath newPath) {// PLEASE NOTE : this only works because 
		int i = 0;
		
		for(AvailablePath pa : AvailablePath.values()) {
			if(pa.equals(newPath)) {
				this.linkedModel.setIndexOfSelectedPath(i);
			}
		i++;
		}
		this.linkedModel.setPath(this.linkedModel.getListOfPaths().get(this.linkedModel.getIndexOfSelectedPath()));
	}

	public void changeColor() {
	    
	    int pick1 = new Random().nextInt(255);
	    int pick2 = new Random().nextInt(255);
	    int pick3 = new Random().nextInt(255);
	    
		this.linkedModel.getShape().setColor(new Color(pick1, pick2, pick3));
	}
	
	public void accelerate(int valueOfSpeedChange) {
		if(this.linkedModel.getPath().getSpeed() >= 10) {
			this.linkedModel.getPath().setSpeed(10);
		}else {
			this.linkedModel.getPath().highenSpeed(valueOfSpeedChange);
		}
	}

	public void decelerate(int valueOfSpeedChange) {
		if(this.linkedModel.getPath().getSpeed() <= 1) {
			this.linkedModel.getPath().setSpeed(1);
		}else {
			this.linkedModel.getPath().lowerSpeed(valueOfSpeedChange);
		}
	}
}
