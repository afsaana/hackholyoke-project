import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.imageio.ImageIO;


/**
 * Main component that draws and stores all objects for the game!
 */

@SuppressWarnings("serial")
public class NumberGameComponent extends JComponent {

	private Player p;
	private JFrame frame;
	private BufferedImage image;
	
	NumberGameComponent(JFrame frame){
//		gameImage("put name of image file for background here");
		this.frame = frame;
	}
	
	public Player getPlayer() {
		return this.p;
	}
	
}
