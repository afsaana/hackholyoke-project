import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Sets up the Screen for starting up the Game.
 * 
 * 
 */


public class StartScreen {
	protected ImageIcon image;
	
	public StartScreen(String imagename, JFrame frame) {
		this.image = new ImageIcon(imagename);
	}

	public void run() {
		JFrame frame = new JFrame();
		JButton button = new JButton("New Game");
		frame.add(new JLabel(image), BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);

		button.addActionListener(new StartGameButtonListener(frame));

		frame.setVisible(true);
		frame.pack();
		frame.setSize(800, 635);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
