import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ctam68 <<<< DATS ME.... EXCEPT I COPIED AND PASTED THIS CLASS (MOST OF IT)
 * 
 * Side note: the double space indenting really pisses off my OCD
 * This is for a Frame to represent the maze
 * 
 */

public class MazeFrame extends JFrame{
	//intializes final variables for colours :)
	final static Color BLACK = new Color(0, 0, 0);
	final static Color WHITE = new Color(255, 255, 255);
	final static Color RED = new Color(255, 0, 0);
	final static Color GREEN = new Color(0, 255, 0);
	final static Color BLUE = new Color(0, 0, 255);
	
	//makes a mazepanel to display the maze on I think?
	private MazePanel panel;
	
	/**
	 * adds an object to the panel, and repaints everything including the new object
	 * @param obj is the object you want to add
	 */
	void add(GraphicalObject obj){
		panel.add(obj);
		repaint();
	}
	
	/**
	 * uhhhhhhh why isn't there public or void? can you explain please?
	 * @param maze THE INPUT MAZE YOU WANT TO DRAW
	 * This is technically a constructor (I am 94% sure)
	 */
	MazeFrame(Maze maze){
		//DUNNO
		super("Maze");  
    
		//gets the maze's height and width :DDDD
		int h = maze.getHeight();
		int w = maze.getWidth();
		  
		//actually don't know lol
	    panel = new MazePanel(h, w);  
	    add(panel);  

	    // this part draws the maze
	    // white for empty
	    // black for walls
	    // not racist (?)
	    for(int i = 0; i < h; i++){
	    	for(int j = 0; j < w; j++){
		        if (maze.isFree(i, j)){
		        	add(new SquareObject(WHITE, i, j));
		        }
		        else{
		        	add(new SquareObject(BLACK, i, j));
		        }
	    	}
	    }
	    
	    //this displays the exit and start of the maze as blue and green circles respectively
	    add(new CircleObject(BLUE, maze.getExit().getI(), maze.getExit().getJ()));
	    add(new CircleObject(GREEN, maze.getStart().getI(), maze.getStart().getJ()));
	    
	    //I know some of these words
	    //???????????????
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    pack();
	    //makes it so you can't resize the window
	    setResizable(false);
	    //makes it so you can actually see the window lol
	    setVisible(true);
	    //PAINTS ALL THE STUFFS
	    repaint();
	}
}