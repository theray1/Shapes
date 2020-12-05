package projetPOO;


import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
/**
 * this class represents a graphic window in which the graphic elements are going to be displayed
 * @author theray1
 *
 */
public class DrawingPanel extends JPanel{
	/**
	 * the boolean that is true when the next drawing panel update resets the graphic context
	 */
	private boolean reset;
	/**
	 * the model containing the shape that the drawing panel is drawing
	 */
	private Model linkedModel;

	/**
	 * class constructor
	 * @param model the model containing the elements to be displayed in this drawing panel
	 */
	public DrawingPanel(Model model) {
		super();
		linkedModel = model;
		setBackground(Color.white);
		reset = true;
	}
	
	/**
	 * paints a shape on the canvas
	 * @param graphics the visual context 
	 */
	public void paintComponent(Graphics graphics) {
		
		if(reset) {
			super.paintComponent(graphics);//dessinduJPanel(fond,bordure...) 
			reset = false;
			return;
		}
		
		graphics.setColor((linkedModel.getShape()).getColor());
		
		linkedModel.getShape().draw(graphics);
	}
	
	/**
	 * resets the canvas by erasing everything currently drawn onto it
	 */
	public void resetCanvas() {
		reset = true;
	}
}
