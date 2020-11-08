
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Here is the main class for our game.
 * 
 * Please don't forget to write javadocs for your classes and functions! This
 * will make it easier for us to debug and add functionality!!
 * 
 * @author Afsaana, Alyssa, and Jessica
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		StartScreen start = new StartScreen("start.png", new JFrame("Number Nest"));
		start.run();
	}

	public static void runGame() throws FileNotFoundException{
		JFrame frame = new JFrame("Number Nest");
		frame.setSize(800, 635);
		NumberGameComponent component = new NumberGameComponent(frame);
		frame.add(component);
		GameAdvanceListener advanceListener = new GameAdvanceListener(component);
		Timer timer = new Timer(10, advanceListener);
		timer.start();

		Player player = new Player(frame, timer);
		component.addPlayer(player);
		
		Level lvl1 = new Level("Level1.txt", frame, player);
		component.addLevel(lvl1);
		KeyListener key = new GameKeyListener(component);
		frame.addKeyListener(key);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}