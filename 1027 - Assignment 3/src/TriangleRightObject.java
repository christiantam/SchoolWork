import java.awt.*;

/**
 * @author INSERT 1027 PROFFESSOR'S NAME HERE
 * Do I reeeeally have to comment this...
 * DO YOU ACTUALLY READ THIS???? PLEASE TELL ME IF YOU DO AND IF I HAVE TO COMMENT ALL THESE GIVEN CLASSES
 * 
 * Represents a TriangleRightObject Object
 * Copypasta from circleobject :DDDDDDDDDDDDD
 */

public class TriangleRightObject extends GraphicalObject{
	
	/**
	 * @param color the colour of the object
	 * @param i0 the row coordinate
	 * @param j0 the column coordinate
	 * moar copypasta
	 * 
	 * Technically a constructor
	 */
	TriangleRightObject(Color color, int i0, int j0){
		super(color, i0, j0);
	}

	/**
	 * hey it didn't give me the parameters when i type /**
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
		y[1] = i0*size + (size/2);
		
		x[2] = j0*size;
		y[2] = (i0+1)*size;
		
		g.fillPolygon(x, y, 3);
	}
}