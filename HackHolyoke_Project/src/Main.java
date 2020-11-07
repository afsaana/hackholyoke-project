
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
		StartScreen start = new StartScreen("start.png", new JFrame("Joust Game"));
		start.run();
	}

	public static void runGame() throws FileNotFoundException{
		JFrame frame = new JFrame("Number Nest");
		frame.setSize(1200, 952);
		NumberGameComponent component = new NumberGameComponent(frame);
		frame.add(component);
	}
	
}