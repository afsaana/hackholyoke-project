import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelBlock {

	protected int x;
	protected int y;
	private BufferedImage image;

	LevelBlock(int x, int y) {
		this.x = x;
		this.y = y;
		try {
			this.image = ImageIO.read(new File("cloudBlock.png"));
		} catch (IOException e) {
			throw new RuntimeException("Could not load image file " + "stones.png");
		}

	}

	public void drawOn(Graphics2D g) {
		g.drawImage(image, x, y, 50, 50, null);

	}
}
