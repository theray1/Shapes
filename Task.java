package projetPOO;

public class Task implements Runnable {
	
	public Task(){
		
	}

	public void run() {
		View view = new View("my JFrame", 1920, 1080);
		view.setVisible(true);
		
	}
}