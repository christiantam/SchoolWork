import java.awt.Color;

/**
 * class that represents a square
 * @author ctam68
 * it's almost 2 am
 * so tired zzzz
 */

public class Square {
	//represents row and column values respectively
	protected int i;
	protected int j;
	
	/**
	 * Constructor with two parameters 
	 * @param i is the row value
	 * @param j is the column value
	 * 
	 */
	public Square(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	/**
	 * HAD TO PUT IT IN THIS CLASS TO MAKE SQUARE(DOWN/LEFT/RIGHT/UP) (DLRU) FOR SHORT
	 * @return a graphical representation of the square
	 */
	public GraphicalObject step(){
		return new SquareObject(Color.red, i, j);
	}
	
	/**
	 * I IS TIRED
	 * THIS METHOD RETURNS THE I VALUE
	 * @return i
	 * ^WHAT DID YOU EXPECT
	 */
	public int getI(){
		return i;
	}

	/**
	 * I IS TIRED
	 * THIS METHOD RETURNS THE j VALUE
	 * @return J
	 * ^WHAT DID YOU EXPECT AGAIN
	 */
	public int getJ(){
		return j;
	}
	
	/**
	 * SETS THE I VALUE OF THIS SQUARE BROOOOOOOOO
	 * @param input WHAT THE USER WANTS THE I VALUE TO BE
	 */
	public void setI(int input){
		i = input;
	}

	/**
	 * SETS THE J VALUE OF THIS SQUARE BROOOOOOOOO
	 * @param input WHAT THE USER WANTS THE J VALUE TO BE
	 */
	public void setJ(int input){
		j = input;
	}

	/**
	 * I mainly used this to debug :D
	 * @return a string representation of the square
	 */
	public String toString(){
		return i + " " + j;
	}
	
	/**
	 * Checks if the given square is the same as this square
	 * Since the square has two variables, I decided to make it return a boolean
	 * 
	 * @param other
	 * @return true if both i and j values are the same
	 * @return false if one or both values are different
	 */
	public boolean equals(Square other){
		if(this.i == other.getI() && this.j == other.getJ()){
			return true;
		}
		return false;
	}
}
