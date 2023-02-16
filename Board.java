import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;

 /*  Board GUI for implementatin with various games
 *   Author: Kirill Levin, Troy Vasiga, Chris Ingram
 *   Edited by: Saad Koker, Rory Keogh, Ziyue Long
 */

public class Board extends JPanel
{
	private static final int X_DIM = 60;
	private static final int Y_DIM = 60;
	private static final int X_OFFSET = 30;
	private static final int Y_OFFSET = 30;
	private static final double MIN_SCALE = 0.25;
	private static final int GAP = 10;
	private static final int FONT_SIZE = 16;
	private static Color TEXT_COLOR = Color.BLACK;
	
	// Grid colours
	public static Color GRID_COLOR_A = new Color(84,137,139);
	public static Color GRID_COLOR_B = new Color(103,156,158);
	
	// Preset colours for pieces
	private static final Color[] COLOURS = 
		{Color.YELLOW, Color.BLUE, Color.CYAN, Color.GREEN, 
		 Color.PINK, Color.WHITE, Color.RED, Color.ORANGE };
	
	// String used to indicate each colour
	private static final String[] COLOUR_NAMES = 
	{"yellow", "blue", "cyan", "green", "pink", "white", "red", "orange"};
	
	// Colour to use if a match is not found
	private static final Color DEFAULT_COLOUR = Color.BLACK;
	private static Peg curPeg = null;
	
	//private Color[][] grid;
	private Peg[][] grid;
	private Coordinate lastClick;  // How the mouse handling thread communicates to the board where the last click occurred
	private String direction;
	private String message = "";
	private int numLines = 0;
	private int[][] line = new int[4][100];  // maximum number of lines is 100
	private int columns, rows;
	
	private boolean first = true;
	private int originalWidth;
	private int originalHeight;
	private double scale;
	public static JFrame f;
	
	/** A constructor to build a 2D board.
	 */
	public Board (int rows, int cols, String taskBarName)
	{
		super( true );
		f = new JFrame(taskBarName);
		JToolBar tools = new JToolBar(); //creating a toolbox to create a task bar
		JButton newGame = new JButton("New"); //creating a button for a new game
		JButton saveGame = new JButton("Save"); //used for saving the current board state
		JButton openButton = new JButton("Open");
		JButton resignButton = new JButton("Resign");
		f.add(tools, BorderLayout.PAGE_START);
		tools.add(newGame);
		tools.add(saveGame);
		tools.add(openButton); 
		this.columns = cols;
		this.rows = rows;
		originalWidth = 2*X_OFFSET+X_DIM*cols;
		originalHeight = 2*Y_OFFSET+Y_DIM*rows+GAP+FONT_SIZE;
		
		this.setPreferredSize( new Dimension( originalWidth, originalHeight ) );
																					
		f.setResizable(true);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		

		this.grid = new Peg[cols][rows];

		KeyAdapter listener = new KeyAdapter() {
		
			@Override 
			public void keyPressed(KeyEvent e)
				{
					int dir = 0;
					dir = e.getKeyCode();

					System.out.println("key pressed");
			
					synchronized(Board.this)
					{
						direction = KeyEvent.getKeyText(dir);
						Board.this.notifyAll() ;	
					}
				}
		};
		
	
		this.addKeyListener(listener);

		this.addMouseListener(
			new MouseInputAdapter() 
			{
				/** A method that is called when the mouse is clicked
				 */
				public void mouseClicked(MouseEvent e) 
				{ 
					int x = (int)e.getPoint().getX();
					int y = (int)e.getPoint().getY();
			
					// We need to by synchronized to the parent class so we can wake
					// up any threads that might be waiting for us
					synchronized(Board.this) 
					{
						int curX = (int)Math.round(X_OFFSET*scale);
						int curY = (int)Math.round(Y_OFFSET*scale);
						int nextX = (int)Math.round((X_OFFSET+X_DIM*grid.length)*scale);
						int nextY = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale);
						
						// Subtract one from high end so clicks on the black edge
						// don't yield a row or column outside of board because of
						// the way the coordinate is calculated.
						if (x >= curX && y >= curY && x < nextX && y < nextY)
						{
							lastClick = new Coordinate(y,x);
							// Notify any threads that would be waiting for a mouse click
							Board.this.notifyAll() ;
						} /* if */
					} /* synchronized */
				} /* mouseClicked */
			} /* anonymous MouseInputAdapater */
		);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane( this );
		f.pack();
	}
	
	/** A constructor to build a 1D board.
	 */
	public Board (int cols, String taskBarName)
	{
		this(1, cols, taskBarName);
	}
	
	public Board (int cols)
	{
		this(1, cols, "Board");
	}
	public Board (int rows, int cols)
	{
		super( true );
		f = new JFrame("Board");
		JToolBar tools = new JToolBar(); //creating a toolbox to create a task bar
		JButton newGame = new JButton("New"); //creating a button for a new game
		JButton saveGame = new JButton("Save"); //used for saving the current board state
		JButton openButton = new JButton("Open");
		JButton resignButton = new JButton("Resign");
		f.add(tools, BorderLayout.PAGE_START);
		tools.add(newGame);
		tools.add(saveGame);
		tools.add(openButton); 
		this.columns = cols;
		this.rows = rows;
		originalWidth = 2*X_OFFSET+X_DIM*cols;
		originalHeight = 2*Y_OFFSET+Y_DIM*rows+GAP+FONT_SIZE;
		
		this.setPreferredSize( new Dimension( originalWidth, originalHeight ) );
																					
		f.setResizable(true);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		
		this.grid = new Peg[cols][rows];

		KeyAdapter listener = new KeyAdapter() {
		
			@Override 
			public void keyPressed(KeyEvent e)
				{
					String dir = "";

					System.out.println("key pressed");
					if(e.getKeyCode() == KeyEvent.VK_UP)
						dir = "up";

					else if(e.getKeyCode() == KeyEvent.VK_DOWN)
						dir = "down";

					else if(e.getKeyCode() == KeyEvent.VK_LEFT)
						dir = "left";

					else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
						dir = "right";
			
					synchronized(Board.this)
					{
						direction = dir;
						Board.this.notifyAll() ;	
					}
				}
		};
		
	
		this.addKeyListener(listener);

		this.addMouseListener(
			new MouseInputAdapter() 
			{
				/** A method that is called when the mouse is clicked
				 */
				public void mouseClicked(MouseEvent e) 
				{ 
					int x = (int)e.getPoint().getX();
					int y = (int)e.getPoint().getY();
			
					// We need to by synchronized to the parent class so we can wake
					// up any threads that might be waiting for us
					synchronized(Board.this) 
					{
						int curX = (int)Math.round(X_OFFSET*scale);
						int curY = (int)Math.round(Y_OFFSET*scale);
						int nextX = (int)Math.round((X_OFFSET+X_DIM*grid.length)*scale);
						int nextY = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale);
						
						// Subtract one from high end so clicks on the black edge
						// don't yield a row or column outside of board because of
						// the way the coordinate is calculated.
						if (x >= curX && y >= curY && x < nextX && y < nextY)
						{
							lastClick = new Coordinate(y,x);
							// Notify any threads that would be waiting for a mouse click
							Board.this.notifyAll() ;
						} /* if */
					} /* synchronized */
				} /* mouseClicked */
			} /* anonymous MouseInputAdapater */
		);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane( this );
		f.pack();
	}
 
	private void paintText(Graphics g)
	{
		g.setColor(this.getBackground());
		g.setFont(new Font(g.getFont().getFontName(), Font.ITALIC+Font.BOLD, (int)(Math.round(FONT_SIZE*scale))));
		
		int x = (int)Math.round(X_OFFSET*scale);
		int y = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale + GAP  ) ;
		
		g.fillRect(x,y, this.getSize().width, (int)Math.round(GAP+FONT_SIZE*scale) );
		g.setColor(TEXT_COLOR);
		g.drawString(message, x, y + (int)Math.round(FONT_SIZE*scale));
	}
	private void paintText(Graphics g, String color)
	{
		g.setColor(this.getBackground());
		g.setFont(new Font(g.getFont().getFontName(), Font.ITALIC+Font.BOLD, (int)(Math.round(FONT_SIZE*scale))));
		
		int x = (int)Math.round(X_OFFSET*scale);
		int y = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale + GAP  ) ;
		
		g.fillRect(x,y, this.getSize().width, (int)Math.round(GAP+FONT_SIZE*scale) );
		g.setColor(convertColour(color));
		g.drawString(message, x, y + (int)Math.round(FONT_SIZE*scale));
	}
	private void paintText(Graphics g, Color color)
	{
		g.setColor(this.getBackground());
		g.setFont(new Font(g.getFont().getFontName(), Font.ITALIC+Font.BOLD, (int)(Math.round(FONT_SIZE*scale))));
		
		int x = (int)Math.round(X_OFFSET*scale);
		int y = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale + GAP  ) ;
		
		g.fillRect(x,y, this.getSize().width, (int)Math.round(GAP+FONT_SIZE*scale) );
		g.setColor(color);
		g.drawString(message, x, y + (int)Math.round(FONT_SIZE*scale));
	}
	
	private void paintGrid(Graphics g)
	{
		this.requestFocusInWindow();
		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{   
				if ((i%2 == 0 && j%2 != 0) || (i%2 != 0 && j%2 == 0))
					g.setColor(GRID_COLOR_A);
				else
					g.setColor(GRID_COLOR_B);
				int curX = (int)Math.round((X_OFFSET+X_DIM*i)*scale);
				int curY = (int)Math.round((Y_OFFSET+Y_DIM*j)*scale);
				int nextX = (int)Math.round((X_OFFSET+X_DIM*(i+1))*scale);
				int nextY = (int)Math.round((Y_OFFSET+Y_DIM*(j+1))*scale);
				int deltaX = nextX-curX; 
				int deltaY = nextY-curY;
																	 
				g.fillRect(curX, curY, deltaX, deltaY);
				
				Peg curPeg = this.grid[i][j];

				if (curPeg != null) // Draw pegs if they exist
				{
					//g.setColor(curColour);
					//g.fillOval(curX+deltaX/4, curY+deltaY/4, deltaX/2, deltaY/2);
					//g.drawImage(curPeg.getImage(), curX+deltaX/4, curY+deltaY/4, deltaX/2, deltaY/2, null);
					g.drawImage(curPeg.getImage(), curX, curY, 60, 60, null);
					
				}
			}
		}
		((Graphics2D) g).setStroke( new BasicStroke(0.5f) );
		g.setColor(Color.BLACK);
		int curX = (int)Math.round(X_OFFSET*scale);
		int curY = (int)Math.round(Y_OFFSET*scale);
		int nextX = (int)Math.round((X_OFFSET+X_DIM*grid.length)*scale);
		int nextY = (int)Math.round((Y_OFFSET+Y_DIM*grid[0].length)*scale);
		g.drawRect(curX, curY, nextX-curX, nextY-curY);
	}
	
	private void drawLine(Graphics g)
	{
		for (int i =0; i < numLines; i++ ) 
		{
			((Graphics2D) g).setStroke( new BasicStroke( 5.0f*(float)scale) );
			g.drawLine( (int)Math.round((X_OFFSET+X_DIM/2.0+line[0][i]*X_DIM)*scale), 
									(int)Math.round((Y_OFFSET+Y_DIM/2.0+line[1][i]*Y_DIM)*scale), 
									(int)Math.round((X_OFFSET+X_DIM/2.0+line[2][i]*X_DIM)*scale), 
									(int)Math.round((Y_OFFSET+Y_DIM/2.0+line[3][i]*Y_DIM)*scale) );
		}
	}
	
	public void texturePack(String texturePack, int duration)
	{
		boolean valid = false;

		if(texturePack.equalsIgnoreCase("wood"))
		{
			changeBoardColor(new Color(193,161,120), new Color(79,36,18));
			valid = true;
		}
		if(texturePack.equalsIgnoreCase("classic"))
		{
			changeBoardColor(new Color(169,169,169), new Color(220,220,220));
			valid = true;
		}
		if(texturePack.equalsIgnoreCase("alien"))
		{
			changeBoardColor(new Color(27,146,226), new Color(161, 255, 123));
			valid = true;
				
		}
		if(texturePack.equalsIgnoreCase("brainwave"))
		{
			for(int i = 0; i < duration; i++)
			{
				if(i%2 == 0)
				{
				changeBoardColor(new Color((int)((Math.random() * 255) + 0), (int)((Math.random() * 255) + 0), (int)((Math.random() * 255) + 0)) , new Color((int)((Math.random() * 255) + 0), (int)((Math.random() * 255) + 0), (int)((Math.random() * 255) + 0)));
				}
			}
		}
		else if(valid = false)
		{
			System.out.println("Error, invalid texture pack parameters");
		}

	}

	/*
	 * Convert a String to the corresponding Color defaulting to Black 
	 * with an invald input
	 */

	private Color convertColour(String theColour)
	{
		for( int i=0; i<COLOUR_NAMES.length; i++ )
		{
			if(COLOUR_NAMES[i].equalsIgnoreCase(theColour))
				return COLOURS[i];
		}
		
		return DEFAULT_COLOUR;
	}
    public void changeBoardColor(String colorNameA, String colorNameB){
        GRID_COLOR_A = convertColour(colorNameA);
        GRID_COLOR_B = convertColour(colorNameB);
        repaint();

    }
    public void changeBoardColor(Color colorA, Color colorB){
        GRID_COLOR_A = colorA;
        GRID_COLOR_B = colorB;
        repaint();
	}
	
	/* The method that draws everything
	 */
	public void paintComponent( Graphics g ) 
	{
		this.setScale();
		this.paintGrid(g);
		this.drawLine(g);
		this.paintText(g);
	}
	
	public void setScale()
	{
		double width = (0.0+this.getSize().width) / this.originalWidth;
		double height = (0.0+this.getSize().height) / this.originalHeight;
		this.scale = Math.max( Math.min(width,height), MIN_SCALE ); 
	}
	
	/* Sets the message to be displayed under the board
	 */
	public void displayMessage(String theMessage)
	{
		message = theMessage;
		this.repaint();
	}
	public void displayMessage(String theMessage, Color textColor)
	{
		message = theMessage;
		TEXT_COLOR = textColor;
		this.repaint();
	}
	public void displayMessage(String theMessage, String textColor)
	{
		TEXT_COLOR = convertColour(textColor);
		message = theMessage;
		this.repaint();
	}
	

	/* This method will draw custom pegs that the user has created
	*/

	public void putPeg(Peg myPeg, int row, int col)
	{
		this.grid[col][row] = myPeg;		
		this.repaint();
	} 

	/** Remove a peg from the gameboard.
	 */
	public void removePeg(int row, int col)
	{
		this.grid[col][row] = null;
		repaint();
	}
	
	/** Same as removePeg above but for 1D boards
	 */
	public void removePeg(int col)
	{
		this.grid[col][0] = null;
		repaint();
	}
	/** Waits for user to click somewhere and then returns the click.
	 */
	public Coordinate getClick()
	{
			Coordinate returnedClick = null;
			synchronized(this) {
					lastClick = null;
					while (lastClick == null)
					{
							try {
									this.wait();
							} catch(Exception e) {
									// We'll never call Thread.interrupt(), so just consider
									// this an error.
									e.printStackTrace();
									System.exit(-1) ;
							} /* try */
					}
		
					int col = (int)Math.floor((lastClick.getCol()-X_OFFSET*scale)/X_DIM/scale);
					int row = (int)Math.floor((lastClick.getRow()-Y_OFFSET*scale)/Y_DIM/scale);
					
					// Put this into a new object to avoid a possible race.
					returnedClick = new Coordinate(row,col);
			}
			return returnedClick;
	}
	
	public String getDirection()
	{	
		String lastDirection = null;
		synchronized(this)
		{
			direction = null;
			while(direction == null)
			{
				try 
				{
					System.out.println("waiting for click");
					this.wait();	
				} catch (Exception e) 
				{
					//TODO: handle exception
				}

				lastDirection = direction;
			}
		}
		return lastDirection;
	}
	/** Same as getClick above but for 1D boards
	 */
	public int getPosition()
	{
		return this.getClick().getCol();
	}
	
	public int getColumns()
	{
		return this.grid.length;
	}
		
	public int getRows()
	{
		return this.grid[0].length;
	}
	public void playBackground(String fileName){

		Background back = new Background(fileName);
		back.run();

	}
	public void vibrate(int shakeLength, int shakeIntensity) { //create method to vibrate the board
		try { //needed for Thread sleep
			final int originalX = f.getLocationOnScreen().x; //final because Visual Studio code did it. If it aint broke dont fix it
			final int originalY = f.getLocationOnScreen().y;

			for (int i = 0; i < shakeLength; i++) {
				Thread.sleep(10); //thread sleep for 10ms
				f.setLocation(originalX, originalY + shakeIntensity); //causes shake in the y to the right
				Thread.sleep(10); //thread sleep for 10ms
				f.setLocation(originalX, originalY - shakeIntensity); //causes shake in the y to the left
				Thread.sleep(10); //thread sleep for 10ms
				f.setLocation(originalX + shakeIntensity, originalY); //causes shake in the x to the right
				Thread.sleep(10); //thread sleep for 10ms
				f.setLocation(originalX, originalY); //causes shake in the y to the left
			}
		}
		catch(Exception e) {
			e.printStackTrace(); //useful for debugging
		}
	}
}
class Background extends Thread{ //create a new class for multithreading that extends Thread

	private String audioPath = null;

	public Background(String filePath){

		audioPath = filePath;
	}
	public void run() { //create run method

		try { //try required as AudioInputStream has unhandled exceptions

			File backgroundSound = new File(audioPath); //initialize sound file
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(backgroundSound); //access the AudioInputStream and get the input which is the file
			Clip clip = AudioSystem.getClip(); //create a clip using the AudioSystem
			clip.open(audioInput); //open the clip
			clip.start(); //start the clip (no need to clip.loop because it automatically does it)

		} catch(Exception e) {
			e.printStackTrace(); //made for troubleshooting INCASE
		}
	}
}



