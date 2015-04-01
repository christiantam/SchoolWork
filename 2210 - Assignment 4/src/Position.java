/**
 * 
 * @author ctam68 
 * @author Student ID: 250679865
 * 
 * This class represents the position of a pixel.
 *
 */
public class Position {
	private int x, y;
	
	/**
	 * Constructor which returns a new Position with the specified coordinates.
	 * @param x - x coordinate
	 * @param y - y coordinate
	 */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Compares this Position with input position p using row order.
	 * @param p - position you want to compare this position with
	 * @return 1 : if this > p
	 * @return 0 : if this = p
	 * @return -1 : if this < p
	 */
	public int compareTo(Position p){
		if(this.y < p.getY()){
			return -1;
		}
		else if(this.y == p.getY()){
			if(this.x < p.getX()){
				return -1;
			}
			else if(this.x == p.getX()){
				return 0;
			}
			else{
				return 1;
			}
		}
		else{
			return 1;
		}
	}
	
	/**
	 * This method returns the x coordinate of the Position.
	 * @return x
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * This method returns the y coordinate of the Position.
	 * @return y
	 */
	public int getY(){
		return y;
	}
}
