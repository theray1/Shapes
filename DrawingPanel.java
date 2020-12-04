package projetPOO;


import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel{

	private boolean reset;
	private Model linkedModel;

	
	public DrawingPanel(Model model) {
		super();
		linkedModel = model;
		setBackground(Color.white);
		reset = true;
	}
	
	public void paintComponent(Graphics g) {
		
		if(reset) {
			super.paintComponent(g);//dessinduJPanel(fond,bordure...) 
			reset = false;
		}
		
		g.setColor((linkedModel.getShape()).getColor());
		
		linkedModel.getShape().draw(g);
	}
	
	public void resetCanvas() {
		reset = true;
	}
}
