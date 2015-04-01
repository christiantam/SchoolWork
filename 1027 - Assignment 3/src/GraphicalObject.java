import java.awt.*;

/**
 * @author INSERT 1027 PROFFESSOR'S NAME HERE
 * Do I reeeeally have to comment this...
 * 
 * Represents a Graphical Object
 * Copypasta from circleobject :DDDDDDDDDDDDD
 */

abstract class GraphicalObject{
	
	//colour of the object
	protected Color color;
	//the x,y co-ordinates of the object yo
	protected int i0, j0;
	
	/**
	 * @param color the colour of the object
	 * @param i0 the "x co-ordinate"
	 * @param j0 the "y co-ordinate"
	 * moar copypasta
	 */
	public GraphicalObject(Color color, int i0, int j0){
		this.color = color;
		this.i0 = i0;
		this.j0 = j0;
	}
	
	/**
	 * hey it didn't give me the parameters when i type /**
	 * @param g is the thing you want to "draw" on I think
	 * @param size is the size of the thing you want to draw in g
	 * "insert innuendo here"
	 */
	abstract public void draw(Graphics g, int size);
}