import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Class that sets up the Player Unit.
 * 
 * @author Alyssa, Afsaana, Jessica
 *
 */

@SuppressWarnings("serial")
public class Player extends Unit {

	protected String PlayerImageName = "Bird Player.png";
	protected Rectangle box = new Rectangle();
	protected int BOX_SIZE = 30;
	protected JFrame frame;
	protected int curUpV = 0;
	protected int curLeftV = 0;
	protected int curRightV = 0;
	protected boolean isRight = true;
	protected boolean isDead = false;
	
	public Player(JFrame frame, Timer timer) {
		this.frame = frame;
	}

	public void ResetPosition() {
		x = 400;
		y = 500;
	}

	public void moveRight(int num) {
		curRightV = num;
		if(curUpV == 0)
			PlayerImageName = "Bird Player.png";
		else
			PlayerImageName = "Bird Player.png";
		isRight = true;
	}
	
	public void moveLeft(int num) {
		curLeftV = num;
		if(curUpV == 0)
			PlayerImageName = "Bird Player.png";
		else
			PlayerImageName = "Bird Player.png";
		isRight = false;
	}

	public void moveUp(int num) {
		curUpV = num;
		if(isRight)
			PlayerImageName = "Bird Player.png";
		else
			PlayerImageName = "Bird Player.png";
	}

	public void updatePosition() {
		if(curUpV == 0) {
			if(isRight)
				PlayerImageName = "Bird Player.png";
			else
				PlayerImageName = "Bird Player.png";
		}
		x += curRightV - curLeftV;
		if (getX() < 0)
			this.x = this.frame.getWidth();
		if (getX() > this.frame.getWidth())
			this.x = 0;
	}
	
	protected void drawOn(Graphics g) throws IOException {
		if (isDead) {
			frame.dispose();
			StartScreen s = new StartScreen("gameOver.png", frame);
			s.run();
		}
		unitImage(PlayerImageName);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.box = new Rectangle(x, y, BOX_SIZE - 5, BOX_SIZE);
		g2.drawImage(this.image, x, y, BOX_SIZE - 5, BOX_SIZE, null);


	}

	public Rectangle getBounds() {
		return this.box;
	}
	
	public void die() {
		ResetPosition();

	}
	
}
