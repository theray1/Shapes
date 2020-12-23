package projetPOO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
/**
 * this class represents a view according to an MVC structure
 * @author theray1
 *
 */
public class View extends JFrame{
	/**
	 * the drawing panel contained inside the view
	 */
	private DrawingPanel linkedDrawingPanel;
	/**
	 * the controller linked to this view
	 */
	private Controller linkedController;
	/**
	 * the model containing the data used by the linked drawing panel
	 */
	private Model linkedModel;

	public View(String title, int w, int h, Controller linkedController, Model linkedModel) {
		super(title);
		this.setLinkedController(linkedController);//Lie le controller et cette view
		this.setLinkedModel(linkedModel);//Lie le model et cette view
		build(w, h);
	}
	
	private void build(int w, int h) {
		setPreferredSize(new Dimension(w, h));//Set les dimensions de la fenetre de l'application 
		buildContentPane(); //Créer le contenu de la fenetre de l'application
		//setLocationRelativeTo(null); //set la position de la fenetre au milieu de l'écran
		setResizable(false); //la taille ne peut pas être modifiée
		pack(); // dimensionnement des composants (?);
	}
	
	private void buildContentPane() {
		
		DrawingPanel pathAndShapeDisplay = new DrawingPanel(linkedModel);
		pathAndShapeDisplay.setFocusable(true);
		pathAndShapeDisplay.addKeyListener(new KeyBoardListener());
		pathAndShapeDisplay.setPreferredSize(new Dimension(1220, 1080));
		pathAndShapeDisplay.addMouseListener(new PathAndShapeDisplayListener());
		getContentPane().add(pathAndShapeDisplay, BorderLayout.CENTER);
		
		linkedDrawingPanel = pathAndShapeDisplay;
		
		JPanel settings = new JPanel();
		settings.setFocusable(false);
		settings.setMinimumSize(new Dimension(100, 0));//Dimension minimum si resize de la fenetre.
		settings.setPreferredSize(new Dimension(300, 0));
		settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
		settings.setBackground(Color.GRAY);
		
		JPanel shapeButtons = new JPanel();
		shapeButtons.setFocusable(false);
		shapeButtons.setMaximumSize(new Dimension(100, 200));
		shapeButtons.setBackground(Color.GRAY);
		
		ButtonGroup shapeButtonsGroup = new ButtonGroup();
		
		JRadioButton squareShapeButton = new JRadioButton("carré");
		squareShapeButton.setFocusable(false);
		JRadioButton circleShapeButton = new JRadioButton("cercle");
		circleShapeButton.setFocusable(false);
		circleShapeButton.setSelected(true);
		
		squareShapeButton.addMouseListener(new SquareShapeRadioButtonListener());
		circleShapeButton.addMouseListener(new CircleShapeRadioButtonListener());
		
		shapeButtonsGroup.add(squareShapeButton);
		shapeButtonsGroup.add(circleShapeButton);
		
		shapeButtons.add(squareShapeButton);
		shapeButtons.add(circleShapeButton);
		
		JPanel pathButtons = new JPanel();
		pathButtons.setFocusable(false);
		pathButtons.setMaximumSize(new Dimension(200, 200));
		pathButtons.setBackground(Color.GRAY);
		
		ButtonGroup pathButtonsGroup = new ButtonGroup();
		
		JRadioButton spiralPathButton = new JRadioButton("spirale");
		spiralPathButton.setFocusable(false);
		
		JRadioButton lemniscatePathButton = new JRadioButton("lemniscate");
		lemniscatePathButton.setFocusable(false);
		
		JRadioButton circlePathButton = new JRadioButton("cercle");
		circlePathButton.setFocusable(false);
		
		circlePathButton.setSelected(true);
		
		spiralPathButton.addMouseListener(new SpiralPathRadioButtonListener());
		lemniscatePathButton.addMouseListener(new LemniscatePathRadioButtonListener());
		circlePathButton.addMouseListener(new CirclePathRadioButtonListener());
		
		pathButtonsGroup.add(circlePathButton);
		pathButtonsGroup.add(lemniscatePathButton);
		pathButtonsGroup.add(spiralPathButton);
		
		pathButtons.add(circlePathButton);
		pathButtons.add(lemniscatePathButton);
		pathButtons.add(spiralPathButton);
		
		pathButtons.setMaximumSize(new Dimension(200, 200));
		
		settings.add(pathButtons);
		settings.add(shapeButtons);
		
		JPanel buttonsGroup = new JPanel();
		buttonsGroup.setFocusable(false);
		buttonsGroup.setMaximumSize(new Dimension(200,200));
		buttonsGroup.setBackground(Color.GRAY);
		
		JButton colorButton = new JButton("color");
		colorButton.setFocusable(false);
		colorButton.addMouseListener(new ColorButtonListener());
		buttonsGroup.add(colorButton);
		
		JButton stopTimeButton = new JButton("『ZA WARDUO』");
		stopTimeButton.setFocusable(false);
		stopTimeButton.addMouseListener(new StopTimeButtonListener());
		buttonsGroup.add(stopTimeButton);	
		
		JButton faster = new JButton("faster");
		faster.setFocusable(false);
		faster.addMouseListener(new FasterButtonListener());
		buttonsGroup.add(faster);
		
		JButton slower = new JButton("slower");
		slower.setFocusable(false);
		slower.addMouseListener(new SlowerButtonListener());
		buttonsGroup.add(slower);
		
		JButton resetButton = new JButton("reset canvas");
		resetButton.setFocusable(false);
		resetButton.addMouseListener(new ResetButtonListener());
		buttonsGroup.add(resetButton);
		
		JButton quitButton = new JButton("close");
		quitButton.setFocusable(false);
		quitButton.addMouseListener(new QuitButtonListener());
		buttonsGroup.add(quitButton);
		
		settings.add(buttonsGroup);
		
		getContentPane().add(settings, BorderLayout.EAST);
	}
	
	/**
	 * linkedDrawingPanel setter
	 * @param drawingPanel the drawing panel of the view
	 */
	public void setLinkedDrawingPanel(DrawingPanel drawingPanel) {
		linkedDrawingPanel = drawingPanel;
	}
	
	/**
	 * applique les demandes de peinture avec les methodes draw des shapes
	 */
	public void update(){
		linkedDrawingPanel.repaint();
		linkedDrawingPanel.revalidate(); // this line helps preventing paint-request skipping, which can cause visual lag 
	}

	/**
	 * linkedModel getter
	 * @return the current linkedModel of the view
	 */
	public Model getLinkedModel() {
		return linkedModel;
	}
	
	/**
	 * linkedDrawingPanel getter
	 * @return the current linkedDrawingPanel
	 */
	public DrawingPanel getLinkedDrawingPanel() {
		return linkedDrawingPanel;
	}

	/**
	 * linkedModel setter
	 * @param linkedModel the new linkedModel of the view 
	 */
	public void setLinkedModel(Model linkedModel) {
		this.linkedModel = linkedModel;
	}
	
	/**
	 * linkedController getter
	 * @return linkedController the current linkedController of the view
	 */
	public Controller getLinkedController() {
		return linkedController;
	}

	/**
	 * linkedController setter 
	 * @param linkedController the new linkedController of the view
	 */
	public void setLinkedController(Controller linkedController) {
		this.linkedController = linkedController;
	}
	
	/*
	 * EVENT LISTENERS
	 */
	
	private class ColorButtonListener implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changeColor();
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}

	}

	private class QuitButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.exit(EXIT_ON_CLOSE);
		}
		
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class CircleShapeRadioButtonListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changeShapeSelectionTo(AvailableShape.circle);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class SquareShapeRadioButtonListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changeShapeSelectionTo(AvailableShape.square);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}

	private class CirclePathRadioButtonListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.circle);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class SpiralPathRadioButtonListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.spiral);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class LemniscatePathRadioButtonListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.lemniscate);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class PathAndShapeDisplayListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			if(linkedModel.getShape().contains(new Point((int)event.getPoint().getX(), (int)(event.getPoint().getY())))) { 
				linkedController.changeColor();	
			}
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class FasterButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.accelerate();
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class SlowerButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.decelerate();
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class KeyBoardListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent event) {
			if(event.getKeyChar() == '+') {
				linkedController.accelerate();
			}
			if(event.getKeyChar() == '-') {
				linkedController.decelerate();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent event) {}
		
	}
	
	private class ResetButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedDrawingPanel.resetCanvas();
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class  StopTimeButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.stopTime();
		}
		
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {
		}
		
	}
}
