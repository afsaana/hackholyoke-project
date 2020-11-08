import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


/**
 * Reads level files and constructs the platforms for the level
 * 
 */


public class Level {

	@SuppressWarnings("unused")
	private Player p;
	@SuppressWarnings("unused")
	private JFrame frame;
	private char[][] blocks = new char[12][16];
	private ArrayList<LevelBlock> blocklist = new ArrayList<LevelBlock>();

	public Level(String filename, JFrame frame, Player p) throws FileNotFoundException {
		this.frame = frame;
		FileReader file = new FileReader(new File(filename));
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 12; i++) {
			String currentline = scan.nextLine();
			for (int j = 0; j < 16; j++)
				blocks[i][j] = currentline.charAt(j * 2);
		}

		while (scan.hasNextInt()) {
			int next = scan.nextInt();
		}
		scan.close();
		setPlatforms();
	}
	
	public void drawOn(Graphics2D g) {
		for (LevelBlock block : blocklist)
			block.drawOn(g);
	}

	public void setPlatforms() {
		for (int i = 0; i < 12; i++) {
			char[] currentrow = blocks[i];
			for (int j = 0; j < 16; j++) {
				if (currentrow[j] == 'B') {
					LevelBlock block = new LevelBlock(50 * j, 50 * i);
					if (!blocklist.contains(block))
						blocklist.add(block);
				}
			}
		}

	}
	public ArrayList<LevelBlock> getBlocks() {
		return this.blocklist;
	}
	
}
