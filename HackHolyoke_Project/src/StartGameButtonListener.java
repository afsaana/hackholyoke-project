import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;


/**
 * Runs the main class again when the new game button is pressed. Effectively
 * restarts the game.
 * 
 * 
 */


public class StartGameButtonListener implements ActionListener{

	private JFrame frame;

	public StartGameButtonListener(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		try {
			Main.runGame();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
