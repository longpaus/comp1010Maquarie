
package pastAssignments.s2_2021.assignment1.intermediateAdvanced;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MagicSquareGameBoard extends JPanel{	
	public static String LIGHTGRAY = "#F2F3F3";
	public static String DARKGRAY = "#A2A3A3";
	public static String YELLOW = "#FFDA89";
	public static String BLUE = "#C4F0F0";
	public static String GREEN = "#55CBCD";
	public static String PURPLE = "#ECD5E3";
	public static String RED = "#FF0000";

	// You can ignore the following variable (it is used for serialization)
	private static final long serialVersionUID = 985903368434308429L;
	private int boardWidth = 1024;
	private int boardHeight = 1024;

	// The game that we are going to display
	protected MagicSquareLogic game;
	protected int firstRow, firstCol;

	public MagicSquareGameBoard(int size){
		this.setPreferredSize(new Dimension(boardWidth,boardHeight));
		this.setBackground(Color.decode(LIGHTGRAY));

		// create a new game with a fixed size and a random seed
		game = new MagicSquareLogic(size);
		firstRow = -1;
	}

	// the method to draw the board
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int startX = 20;
		int startY = 20;
		int tileSize = (int)(boardWidth/game.data.length/3);
		// to draw the tiles, we get the state of the board (i.e. ArrayList<Tile> 
		// from the game and then draw the tiles in the ArrayList one by one
		// remove everything on the panel (wipe the screen basically)
		this.removeAll();

		Color col = Color.decode(DARKGRAY);

		if(game.finished()) {
			col = Color.decode(GREEN);
		}

		for(int i = 0; i < game.data.length; i++) {
			for(int k = 0; k < game.data[i].length; k++) {
				MagicSquareTile temp = new MagicSquareTile(game.data[i][k], startX + k * (int)(tileSize*1.5), startY + i * (int)(tileSize*1.5), tileSize, tileSize, 8, col, this, i, k);
				this.add(temp);
			}
		}
		this.add(new Instructions("Click on first tile and then second tile to swap them. Green(ish) background indicates completion.", 10, (int)(boardHeight*0.6), boardWidth-20, 80, 20, Color.decode("#AABBFF")));
	}

	// This is the application's entry point. You can change the call to the SameGameBoard constructor
	// to change the game settings (change seed, change row/column numbers)
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame root = new JFrame("Magic Square");
				root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				MagicSquareGameBoard b = new MagicSquareGameBoard(3);
				b.repaint();
				root.add(b);
				root.setContentPane(b);
				root.pack();
				root.setVisible(true);

			}
		});
	}
}
