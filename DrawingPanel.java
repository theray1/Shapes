package projetPOO;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Drawable selectedShape;
	private boolean reset;

	
	public DrawingPanel() {
		super();
		this.setBackground(Color.white);
		reset = true;
	}
	
	public void setSelectedShape(Shape shape) {
		this.selectedShape = (Drawable) shape;
	}
	
	public void paintComponent(Graphics g) {
		
		if(reset) {
			super.paintComponent(g);//dessinduJPanel(fond,bordure...) 
			reset = false;
		}
		
		g.setColor(((Shape) selectedShape).getColor());
		
		selectedShape.draw(g);
	}
	
	public void resetCanvas() {
		reset = true;
	}
}
