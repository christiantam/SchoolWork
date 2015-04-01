import java.awt.*;

/**
 * 
 * @author ctam68
 * k so I'm going to copy and paste this three times
 * This represents a square that can return a graphical representation with an arrow pointing down
 */

public class SquareDown extends Square{
	/**
	 * constructor
	 * @param i the value of i the user wants to set
	 * @param j the value of j the user wants to set
	 */
	public SquareDown(int i, int j){
		super(i, j);
	}

	/**
	 * @return a Object in the shape of a triangle pointing down, it is also of the colour red
	 */
	public GraphicalObject step(){
		return new TriangleDownObject(Color.red, i, j);
	}
}