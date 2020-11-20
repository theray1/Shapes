package projetPOO;

public class Task implements Runnable {
	
	public void run() {
		View view = new View("my␣JFrame", 300, 100);
		view.setVisible(true);
	}
}