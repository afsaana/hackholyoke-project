import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAdvanceListener implements ActionListener{
	private NumberGameComponent c;

	public GameAdvanceListener(NumberGameComponent c) {
		this.c = c;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			advanceOneTick();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private void advanceOneTick() throws InterruptedException {
		this.c.updateState();
		this.c.repaint();
	}
}
