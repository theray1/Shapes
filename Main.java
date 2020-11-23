package projetPOO;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Task()
				/*new Runnable(){
					public void run() {
						View view = new View("my JFrame", 300, 100);
						view.setVisible(true);
					}
				}*/
		);
	}
}