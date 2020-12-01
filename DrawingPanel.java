package projetPOO;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Drawable> listOfShapes; 
	private int indexOfSelectedShape;
	private boolean reset;
	
	public ArrayList<Drawable> getListOfShapes(){
		return this.listOfShapes;
	}
	
	public DrawingPanel() {
		super();
		
		this.setBackground(Color.white);
	
		this.listOfShapes = new ArrayList<>();
		
		this.setIndexOfSelectedShape(0);
		
		reset = true;
	}
	
	public void addShape(Shape shape) {
		this.listOfShapes.add((Drawable) shape);
	}
	
	public void paintComponent(Graphics g) {
		
		if(reset) {
			super.paintComponent(g);//dessinduJPanel(fond,bordure...) 
			reset = false;
		}
		
		g.setColor(((Shape) this.listOfShapes.get(this.indexOfSelectedShape)).getColor());
		
		this.listOfShapes.get(this.indexOfSelectedShape).draw(g);
		
	}

	public int getIndexOfSelectedShape() {
		return indexOfSelectedShape;
	}

	public void setIndexOfSelectedShape(int indexOfSelectedShape) {
		this.indexOfSelectedShape = indexOfSelectedShape;
	}

	public void setCurrentShapeTo(AvailableShape newShape) {// PLEASE NOTE : This only works because for each loops always iterate over enums in the same order
		int i = 0;
		
		for(AvailableShape sh : AvailableShape.values()) {
			if(sh.equals(newShape)) {
				this.setIndexOfSelectedShape(i);
			}
		i++;
		}
	}
	
	public void resetCanvas(Graphics graphics) {
		reset = true;
	}
	
	private class WhiteRectangle implements Drawable{

		@Override
		public void draw(Graphics g) {
			g.fillRect(0, 0, 200, 200);
		}
		
	}
}
