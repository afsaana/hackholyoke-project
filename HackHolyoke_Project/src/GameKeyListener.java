import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class utilizes key-binding so that our player can be moved using user
 * input
 * 
 * @author russelj
 *
 */

public class GameKeyListener implements KeyListener {

	NumberGameComponent c;
	Player p;

	GameKeyListener(NumberGameComponent c) {
		this.c = c;
		this.p = c.getPlayer();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// This is to move the hero right with the right arrow key
		if (e.getKeyCode() == 39)
			p.moveRight(5);
		// This is to move the hero left with the left arrow key
		if (e.getKeyCode() == 37)
			p.moveLeft(5);

		// This is to move the hero up with the up arrow key
		if (e.getKeyCode() == 38)
			p.moveUp(5);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 39)
			p.moveRight(0);

		if (e.getKeyCode() == 37)
			p.moveLeft(0);

		if (e.getKeyCode() == 38)
			p.moveUp(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
