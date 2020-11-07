import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Superclass that controls the units of numbers, players, and other objects
 * on screen.
 * 
 * @author Afsaana, Alyssa, Jessica
 *
 */

public class Unit extends JComponent{

	protected int x = 500;
	protected int y = 600;
	protected int BOX_SIZE = 25;
	protected BufferedImage image;

	public int Size() {
		return BOX_SIZE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void changeY(int num) {
		y += num;
	}

	public void changeX(int num) {
		x += num;
	}
	
	public void unitImage(String filename) {
		try {
			this.image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			throw new RuntimeException("Could not load image file " + filename);
		}
	}
	
}
