import java.awt.Rectangle;
import java.util.Timer;

import javax.swing.JFrame;

/**
 * Class that sets up the Player Unit.
 * 
 * @author Alyssa, Afsaana, Jessica
 *
 */

@SuppressWarnings("serial")
public class Player extends Unit {

	protected String PlayerImageName = "Link_transparent.png";
	protected Rectangle box = new Rectangle();
	protected int BOX_SIZE = 30;
	protected JFrame frame;
	protected int curUpV = 0;
	protected int curLeftV = 0;
	protected int curRightV = 0;
	protected boolean isRight = true;
	
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
			PlayerImageName = "Link_right.png";
		else
			PlayerImageName = "Link_leap_right.png";
		isRight = true;
	}
	
	public void moveLeft(int num) {
		curLeftV = num;
		if(curUpV == 0)
			PlayerImageName = "Link_transparent.png";
		else
			PlayerImageName = "Link_leap.png";
		isRight = false;
	}

	public void moveUp(int num) {
		curUpV = num;
		if(isRight)
			PlayerImageName = "Link_leap_right.png";
		else
			PlayerImageName = "Link_leap.png";
	}

	public void updatePosition() {
		if(curUpV == 0) {
			if(isRight)
				PlayerImageName = "Link_slash_right.png";
			else
				PlayerImageName = "Link_slash.png";
		}
		x += curRightV - curLeftV;
		if (getX() < 0)
			this.x = this.frame.getWidth();
		if (getX() > this.frame.getWidth())
			this.x = 0;
	}
	
}