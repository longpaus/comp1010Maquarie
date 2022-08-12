package pastAssignments.s2_2021.assignment1.intermediateAdvanced;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;

/*
 * The following class is a graphical interface for the SimpleSameGame board
 * 
 * If you like, you can play around with this file, as long as it doesn't interfere
 * with the game logic in SameGame.java. 
 */

public class MagicSquareTile extends JComponent {

	private static final long serialVersionUID = 2516851011912978902L;
	private String val;
	private int width;
	private int height;
	private int arc;
	private MagicSquareGameBoard board;
	private Color color;
	private int row, col;

	public MagicSquareTile(int val, int x, int y, int width, int height, int arc, Color color, MagicSquareGameBoard board, int row, int col) {
		this.val = val+"";
		this.width = width;
		this.height = height;
		this.arc = arc;
		this.color = color;
		this.board = board;

		// this determines where the tile is drawn
		this.setBounds(x,y,width,height);
		this.row = row;
		this.col = col;

		// add a behavior to the tile when clicked
		addMouseListeners();
	}

	public void paintComponent(final Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		g.setColor(color);
		g.fillRoundRect(0,0,width,height,arc,arc);
		g.fillRect(20,5,330,25);
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.PLAIN, Math.min(width,  height)/2));
		g.drawString(val,width/2-g.getFontMetrics().stringWidth(val)/2,2*height/3);
	}

	// adds a behavior to the tile when an event occurs
	public void addMouseListeners() {

		// add a listener for when a mouse is clicked, which listens for an event to
		// happen before executing some code
		this.addMouseListener(new MouseInputAdapter() {
			@Override
			// we use mouseReleased event because it is more accurate in detecting mouse clicks
			public void mouseReleased(MouseEvent e) {
				if(board.game.finished()) {
					try {
						Thread.sleep(2000);
					}
					catch (InterruptedException exp) {
						// TODO Auto-generated catch block
						exp.printStackTrace();
					}
					System.exit(0);
				}
				
				if(board.firstRow >= 0) {
					board.game.swap(board.firstRow, board.firstCol, row, col);
					board.firstRow = -1;
					board.repaint();
				}
				else {
					board.firstRow = row;
					board.firstCol = col;
				}
			}
		});
	}

}
