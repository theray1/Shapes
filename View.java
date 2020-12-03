package projetPOO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class View extends JFrame{
	
	private DrawingPanel linkedDrawingPanel;
	private Controller linkedController;
	private Model linkedModel;
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public View(String title, int w, int h, Controller linkedController, Model linkedModel) {
		super(title);
		this.setLinkedController(linkedController);
		this.setLinkedModel(linkedModel);
		build(w, h);
	}
	
	private void build(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		buildContentPane(); //TODO (contenu)
		//setLocationRelativeTo(null); //set la position de la fenetre au milieu de l'écran
		setResizable(true); //la taille ne peut pas être modifiée
		pack(); // dimensionnement des composants (?);
		
	}
	
	private void buildContentPane() {
		getContentPane().setFocusable(true);
		getContentPane().addKeyListener(new KeyBoardListener());
		
		DrawingPanel pathAndShapeDisplay = new DrawingPanel();
		pathAndShapeDisplay.setFocusable(false);
		pathAndShapeDisplay.setPreferredSize(new Dimension(1220, 1080));
		pathAndShapeDisplay.addMouseListener(new PathAndShapeDisplayListener());
		getContentPane().add(pathAndShapeDisplay, BorderLayout.CENTER);
		
		this.linkedDrawingPanel = pathAndShapeDisplay;
		
		JPanel settings = new JPanel();
		settings.setFocusable(false);
		settings.setMinimumSize(new Dimension(100, 0));//Dimension minimum si resize de la fenetre.
		settings.setPreferredSize(new Dimension(300, 0));
		settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
		
		JPanel shapeButtons = new JPanel();
		shapeButtons.setMaximumSize(new Dimension(100, 200));
		
		ButtonGroup shapeButtonsGroup = new ButtonGroup();
		
		JRadioButton squareShapeButton = new JRadioButton("carré");
		squareShapeButton.setFocusable(false);
		JRadioButton circleShapeButton = new JRadioButton("cercle");
		circleShapeButton.setFocusable(false);
		circleShapeButton.setSelected(true);
		
		squareShapeButton.addActionListener(new SquareShapeRadioButtonListener());
		circleShapeButton.addActionListener(new CircleShapeRadioButtonListener());
		
		shapeButtonsGroup.add(squareShapeButton);
		shapeButtonsGroup.add(circleShapeButton);
		
		shapeButtons.add(squareShapeButton);
		shapeButtons.add(circleShapeButton);
		
		JPanel pathButtons = new JPanel();
		pathButtons.setMaximumSize(new Dimension(200, 200));
		
		ButtonGroup pathButtonsGroup = new ButtonGroup();
		
		JRadioButton spiralPathButton = new JRadioButton("spirale");
		spiralPathButton.setFocusable(false);
		JRadioButton lemniscatePathButton = new JRadioButton("lemniscate");
		lemniscatePathButton.setFocusable(false);
		JRadioButton circlePathButton = new JRadioButton("cercle");
		circlePathButton.setFocusable(false);
		circlePathButton.setSelected(true);
		
		spiralPathButton.addActionListener(new SpiralPathRadioButtonListener());
		lemniscatePathButton.addActionListener(new LemniscatePathRadioButtonListener());
		circlePathButton.addActionListener(new CirclePathRadioButtonListener());
		
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
		buttonsGroup.setMaximumSize(new Dimension(200,200));
		
		JButton colorButton = new JButton("color");
		colorButton.setFocusable(false);
		colorButton.addActionListener(new ColorButtonListener());
		buttonsGroup.add(colorButton);
		
		JButton stopTimeButton = new JButton("『ZA WARDUO』");
		stopTimeButton.setFocusable(false);
		stopTimeButton.addMouseListener(new StopTimeButtonListener());
		buttonsGroup.add(stopTimeButton);		
		JButton speed = new JButton("faster");
		speed.setFocusable(false);
		speed.addMouseListener(new FasterButtonListener());
		buttonsGroup.add(speed);
		
		JButton slow = new JButton("slower");
		slow.setFocusable(false);
		slow.addMouseListener(new SlowerButtonListener());
		buttonsGroup.add(slow);
		
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
	
	public void setLinkedDrawingPanel(DrawingPanel drawingPanel) {
		this.linkedDrawingPanel = drawingPanel;
	}
	
	void update(){
		linkedDrawingPanel.repaint();
		linkedDrawingPanel.revalidate(); // this line helps preventing paint-request skipping, which causes visual lag 
	}

	public Model getLinkedModel() {
		return linkedModel;
	}
	
	public DrawingPanel getLinkedDrawingPanel() {
		return linkedDrawingPanel;
	}

	public void setLinkedModel(Model linkedModel) {
		this.linkedModel = linkedModel;
	}

	public Controller getLinkedController() {
		return linkedController;
	}

	public void setLinkedController(Controller linkedController) {
		this.linkedController = linkedController;
	}
	
	private class ColorButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeColor();
		}

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
	
	private class CircleShapeRadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeShapeSelectionTo(AvailableShape.circle);
		}
		
	}
	
	private class SquareShapeRadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeShapeSelectionTo(AvailableShape.square);
		}
	}

	private class CirclePathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changePathSelectionTo(AvailablePath.circle);
			
		}
		
	}
	
	private class SpiralPathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.spiral);
		}
		
	}
	
	private class LemniscatePathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.lemniscate);
		}
		
	}
	
	private class PathAndShapeDisplayListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			if(linkedModel.getShape().contains(new Point((int)event.getPoint().getX(), (int)(event.getPoint().getY())))) { 
				linkedController.changeColor();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class FasterButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.accelerate();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class SlowerButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.decelerate();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
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
