package projetPOO;

import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class TickController extends TimerTask {
	private final Model linkedModel;
	
	public TickController(Model model) {
		this.linkedModel = model;
	}
	
	public void run() {
			linkedModel.evolve();
	}
}
