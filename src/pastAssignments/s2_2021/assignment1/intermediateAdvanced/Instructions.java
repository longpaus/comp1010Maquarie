package pastAssignments.s2_2021.assignment1.intermediateAdvanced;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;


public class Instructions extends JComponent {
	private static final long serialVersionUID = 8146663578386550527L;
	private String message;
	private int width;
	private int height;
	private int arc;
	private Color color;

	public Instructions(String msg, int x, int y, int width, int height, int arc, Color color) {
		this.message = msg;
		this.width = width;
		this.height = height;
		this.arc = arc;
		this.color = color;

		// this determines where the tile is drawn
		this.setBounds(x,y,width,height);
	}

	public void paintComponent(final Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		g.setColor(color);
		g.fillRoundRect(0,0,width,height,arc,arc);
		g.fillRect(20,5,330,25);
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", Font.PLAIN, 40));
		g.drawString(message,width/2-g.getFontMetrics().stringWidth(message)/2,2*height/3);
	}
}
