import java.awt.*;

/**
 * @author INSERT 1027 PROFFESSOR'S NAME HERE
 * Do I reeeeally have to comment this...
 * 
 * Represents a Circle Object
 */

public class CircleObject extends GraphicalObject{
	/**
	 * 
	 * @param color the colour of the object
	 * @param i0 the "x co-ordinate"
	 * @param j0 the "y co-ordinate"
	 */
	CircleObject(Color color, int i0, int j0){
		super(color, i0, j0);
	}
	

	/**
	 * hey it didn't give me the parameters when i type /**
	 * @param g is the thing you want to "draw" on I think
	 * @param size is the size of the thing you want to draw in g
	 * "insert innuendo here"
	 */
	public void draw(Graphics g, int size){
		g.setColor(color);
    	g.fillOval(j0*size, i0*size, size, size);
	}
}