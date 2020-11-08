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
	ArrayList<Level> levels = new ArrayList<Level>();
	private int currentlevel = 0;
	private boolean stop;

	NumberGameComponent(JFrame frame) {
		gameImage("cloudBlock.png");
		this.frame = frame;
	}

	public Player getPlayer() {
		return this.p;
	}

	public void addPlayer(Player player) {
		this.p = player;
	}

	public Level getCurrentLevel() {
		return this.levels.get(currentlevel);
	}

	public void gameImage(String filename) {
		try {
			this.image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			throw new RuntimeException("Could not load image file " + filename);
		}
	}

	public void changeLevel(int num) {
		if (num > 0 && currentlevel != levels.size() - 1)
			currentlevel++;
		if (num < 0 && currentlevel != 0)
			currentlevel--;
		p.ResetPosition();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(this.image, 0, 0, 800, 635, null);
		levels.get(currentlevel).drawOn(g2);
		try {
			p.drawOn(g);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void updateState() {

		p.updatePosition();
		if (p.getY() > this.frame.getHeight())
			p.die();
		if (levels.size() != 0) {
//			if (currentlevel == levels.size() - 1 && stop == false) {
//				stop = true;
////					StartScreen win = new StartScreen("winner.png", frame);
////					win.run();
//				frame.dispose();
//			}
			this.changeLevel(1);
		}
	}

	public void addLevel(Level l) {
		levels.add(l);
	}
}
