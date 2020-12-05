package projetPOO;


import java.util.TimerTask;

import javax.swing.SwingUtilities;
/**
 * this class sets up an loop which calls the evolve method of the controller on a regular basis
 * @author theray1
 *
 */
public class TickController extends TimerTask {
	private final Controller linkedController;
	
	public TickController(Controller controller) {
		this.linkedController = controller;
	}
	
	public void run() {
			linkedController.evolve();
	}
}
