/**
 * 
 * @author ctam68 
 * @author Student ID: 250679865
 * 
 * This class represents a data item stored in the binary search tree.
 *
 */
public class DictEntry {
	private Position p;
	private int color;
	
	/**
	 * Constructor which returns a new DictEntry with the specified coordinates and color.
	 * @param p - Position
	 * @param color - color
	 */
	public DictEntry(Position p, int color){
		this.p = p;
		this.color = color;
	}
	
	/**
	 * This method returns the Position of the DictEntry.
	 * @return y
	 */
	public Position getPosition(){
		return p;
	}
	
	/**
	 * This method returns the color of the DictEntry.
	 * @return y
	 */
	public int getColor(){
		return color;
	}
}
