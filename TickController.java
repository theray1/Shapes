package projetPOO;


import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class TickController extends TimerTask {
	private final Controller linkedController;
	
	public TickController(Controller controller) {
		this.linkedController = controller;
	}
	
	public void run() {
			linkedController.evolve();
	}
}
