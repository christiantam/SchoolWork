/**
 * This class represents a node.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class Node {
	private int name;
	private boolean mark;

	/**
	 * Constructor which initializes the name of the node.
	 */
	public Node(int name){
		this.name = name;
		mark = false;
	}

	
	/**
	 * This method sets the mark of the node to the input boolean variable.
	 */
	public void setMark(boolean mark){
		this.mark = mark;
	}

	
	/**
	 * This method returns the mark of the node.
	 */
	public boolean getMark(){
		return mark;
	}
	
	/**
	 * This method returns the name of the node.
	 */
	public int getName(){
		return name;
	}
}
