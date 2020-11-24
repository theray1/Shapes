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
	
	public DrawingPanel() {
		super();
		this.setBackground(Color.white);
		this.setBorder(
				BorderFactory.createLineBorder(Color.black));
		this.listOfShapes = new ArrayList<>();
		Circle circle = new Circle(300, new Point(960, 540) );
		this.listOfShapes.add(circle);
		System.out.println("end of DrawingPanel Constructor");
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("beginning of paintComponent function");
		super.paintComponent(g);//dessinduJPanel(fond,bordure...)
		//int w = this.getWidth(), h = this.getHeight(), r = 50, d = 2*r;
		//g.setColor(Color.RED);
		//g.fillOval(w/2 - r, h/2 - r, d, d);//disquerougecentré
		this.listOfShapes.get(0).draw(g);
	}
}
