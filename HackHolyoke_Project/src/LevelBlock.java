import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 50);

	}


	public void collidingLeft(Unit p) {
		if (p.getX() + p.Size() + 5 > x && p.getY() < y + 50 && p.getY() + p.Size() > y + 2 && p.getX() < x + 20)
			p.changeX(-7);
	}

	public void collidingRight(Unit p) {
		if (p.getX() < x + 55 && p.getY() < y + 50 && p.getY() + p.Size() > y + 2 && p.getX() > x + 30)
			p.changeX(7);
	}

	public void collidingTop(Player p) {
		if (p.getY() + p.Size() + 5 > y)
			p.setFallingVelocity(0);
	}

	public void collidingTop(Unit u) {
		if (u.getY() + u.Size() > y)
			u.changeY(-5);
	}

	public void collidingBottom(Unit h) {
		if (h.getY() < y + 54 && h.getY() > y + 45)
			h.changeY(7);
	}

	public void drawOn(Graphics2D g) {
		g.drawImage(image, x, y, 50, 50, null);

	}
}
