package projetPOO;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Model {
	private Path path;
	private Shape shape;
	private View linkedView;
	private ArrayList<Path> listOfPaths;
	private int indexOfSelectedPath;
	
	public View getLinkedView() {
		return this.linkedView;
	}
	
	public Model() {
		this.setPath(null);
		this.setShape(null);
		this.setLinkedView(null);
		this.listOfPaths = new ArrayList<>();
		this.setIndexOfSelectedPath(0);
	}
	
	public Model(Path path, Shape shape, View linkedView) {
		this.setPath(path);
		this.setShape(shape);
		this.linkedView = linkedView;
		this.setListOfPaths(new ArrayList<>());
		this.setIndexOfSelectedPath(0);
	}
	
	public void setLinkedView(View newLinkedView) {
		this.linkedView = newLinkedView;
	}
	
	public void evolve(){
		
		Point temp = new Point(this.shape.getReferencePoint());
		
		this.getShape().moveTo(this.getPath().nextPoint());
		
		if(!(this.shape.getReferencePoint().equals(temp))) {// ce if permet de rotate le forme seulement si elle change de position, afin d'éviter de voir les rformes tourner sur elle meme, a basse vitesse
			this.getShape().rotate(5);
		}
		
		this.linkedView.update();
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

	public void updateShape() {
		this.setShape((Shape) this.linkedView.getLinkedDrawingPanel().getListOfShapes().get(this.linkedView.getLinkedDrawingPanel().getIndexOfSelectedShape()));
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
}
