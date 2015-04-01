import java.awt.*;

/**
 * @author INSERT 1027 PROFFESSOR'S NAME HERE
 * Do I reeeeally have to comment this...
 * 
 * Represents a TriangleDownObject Object
 * Copypasta from circleobject :DDDDDDDDDDDDD
 * 
 * PLEASE LET ME KNOW IF YOU ACTUALLY READ THESE 
 */

public class TriangleDownObject extends GraphicalObject{
	
	/**
	 * @param color the colour of the object
	 * @param i0 the row coordinate
	 * @param j0 the column coordinate
	 * moar copypasta
	 * 
	 * Technically a constructor
	 */
	TriangleDownObject(Color color, int i0, int j0){
		super(color, i0, j0);
	}
	
	/**
	 * hey it didn't give me the parameters when i typed /**
	 * @param g is the thing you want to "draw" on I think
	 * @param size is the size of the thing you want to draw in g
	 * "insert innuendo here"
	 * so much copy and pasting my hands are getting tired
	 */
	public void draw(Graphics g, int size){
		g.setColor(color);
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = j0*size;
		y[0] = i0*size;
			
		x[1] = (j0+1)*size;
		y[1] = i0*size;
		
		x[2] = j0*size + (size/2);
		y[2] = (i0+1)*size;
		
		g.fillPolygon(x, y, 3);
	}
}