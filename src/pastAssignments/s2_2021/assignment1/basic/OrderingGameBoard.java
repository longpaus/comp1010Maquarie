package pastAssignments.s2_2021.assignment1.basic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pastAssignments.s2_2021.assignment1.intermediateAdvanced.Instructions;

public class OrderingGameBoard extends JPanel{	
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
	private int aim;
	private boolean shownOnceAfterSorted = false;
	private static long start = System.nanoTime();
	private static int timeLimit = 60;
	public static JFrame root;

	// The game that we are going to display
	protected OrderingLogic game;
	public static int score = 0;
	
	public OrderingGameBoard(int size){
		this.setPreferredSize(new Dimension(boardWidth,boardHeight));
		this.setBackground(Color.decode(LIGHTGRAY));

		// create a new game with a fixed size and a random seed
		game = new OrderingLogic(size);

		aim = LongestSortedSequenceFinder.longestSortedSubsequence(game.data);
	}

	// the method to draw the board
	protected void paintComponent(Graphics g) {
		//60 second game
		int timePassed = (int)((System.nanoTime() - start)/1000000000l);
		//int timeLeft = timeLimit - timePassed;
		if(timePassed >= timeLimit) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		super.paintComponent(g);
		int startX = 20;
		int tileSize = (int)(boardWidth/game.data.length/2);
		this.removeAll();
		if(!shownOnceAfterSorted) {
			boolean sorted = game.isSorted();
			boolean missedIt = LongestSortedSequenceFinder.longestSortedSubsequence(game.data) < aim;
			if(sorted || missedIt) {
				shownOnceAfterSorted = true;
			}
			if(sorted && !missedIt) {
				score++;
			}
			for(int i = 0; i < game.data.length; i++) {
				int el = 100 - game.data[i];
				Color col = Color.decode("#"+el+el+el);
				if(sorted) {
					col = Color.decode(GREEN);
				}
				if(missedIt) {
					col = Color.decode(RED);
				}
				this.add(new SequenceTile(game.data[i], startX + i * (int)(tileSize*1.5), 20, tileSize, tileSize, 8, col, this,i));
			}
			String msg = "Click tile to remove. Score:"+score;
			this.add(new Instructions(msg, 10, (int)(boardHeight*0.6), boardWidth-20, 80, 20, Color.decode("#AABBFF")), this);
		}
		else {
			shownOnceAfterSorted = false;			
			root = new JFrame("Ordering Sequences");
			root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			OrderingGameBoard b = new OrderingGameBoard(10);
			b.repaint();
			root.add(b);
			root.setContentPane(b);
			root.pack();
			root.setVisible(true);
		}
	}

	// This is the application's entry point. You can change the call to the SameGameBoard constructor
	// to change the game settings (change seed, change row/column numbers)
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				root = new JFrame("Ordering Sequences");
				root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				OrderingGameBoard b = new OrderingGameBoard(10);
				b.repaint();
				root.add(b);
				root.setContentPane(b);
				root.pack();
				root.setVisible(true);
			}
		});
	}
}
