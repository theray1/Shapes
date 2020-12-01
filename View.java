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
		getContentPane().addKeyListener(new keyBoardListener());
		
		DrawingPanel pathAndShapeDisplay = new DrawingPanel();
		pathAndShapeDisplay.setFocusable(false);
		pathAndShapeDisplay.setPreferredSize(new Dimension(1220, 1080));
		pathAndShapeDisplay.addMouseListener(new pathAndShapeDisplayListener());
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
		
		squareShapeButton.addActionListener(new squareShapeRadioButtonListener());
		circleShapeButton.addActionListener(new circleShapeRadioButtonListener());
		
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
		
		JButton testButton = new JButton("color");
		testButton.setFocusable(false);
		testButton.addActionListener(new TestListener());
		buttonsGroup.add(testButton);
		
		JButton quitButton = new JButton("close");
		quitButton.setFocusable(false);
		quitButton.addMouseListener(new quitButtonListener());
		buttonsGroup.add(quitButton);
		
		JButton resetButton = new JButton("reset canvas");
		resetButton.setFocusable(false);
		resetButton.addMouseListener(new resetButtonListener());
		buttonsGroup.add(resetButton);
		
		JButton speed = new JButton("faster");
		speed.setFocusable(false);
		speed.addMouseListener(new fasterButtonListener());
		buttonsGroup.add(speed);
		
		JButton slow = new JButton("slower");
		slow.setFocusable(false);
		slow.addMouseListener(new slowerButtonListener());
		buttonsGroup.add(slow);
		
		settings.add(buttonsGroup);
		
		getContentPane().add(settings, BorderLayout.EAST);
	}
	
	public void setLinkedDrawingPanel(DrawingPanel drawingPanel) {
		this.linkedDrawingPanel = drawingPanel;
	}
	
	void update(){
		this.linkedDrawingPanel.repaint();
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
	
	public void addShape(Shape shape) {
		this.linkedDrawingPanel.addShape(shape);
	}

	
	
	private class TestListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeColor();
		}

	}
	
	private class resetButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedDrawingPanel.resetCanvas(linkedDrawingPanel.getGraphics());
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class quitButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
		
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class circleShapeRadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeShapeSelectionTo(AvailableShape.circle);
		}
		
	}
	
	private class squareShapeRadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changeShapeSelectionTo(AvailableShape.square);
		}
	}

	private class circlePathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent action) {
			linkedController.changePathSelectionTo(AvailablePath.circle);
			
		}
		
	}
	
	private class spiralPathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.spiral);
		}
		
	}
	
	private class lemniscatePathRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			linkedController.changePathSelectionTo(AvailablePath.lemniscate);
		}
		
	}
	
	private class pathAndShapeDisplayListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			if(linkedModel.getShape().contains(new Point((int)event.getPoint().getX(), (int)(event.getPoint().getY())))) { //- 40 pour prendre en compte le haut de la fenetre, qui n'est pas pris en compte pour les coordonnées du drawing panel, à l'inverse des coordonnées sur l'écran
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
	
	private class fasterButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.accelerate(1);
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
	
	private class slowerButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			linkedController.decelerate(1);
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
	
	private class keyBoardListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent event) {
			System.out.println(event.getKeyChar());
			if(event.getKeyChar() == '+') {
				linkedController.accelerate(1);
			}
			if(event.getKeyChar() == '-') {
				linkedController.decelerate(1);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent event) {}
		
	}
}
