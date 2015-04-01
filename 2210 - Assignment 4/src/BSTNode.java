/**
 * This class represents a node of a binary search tree.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */	
public class BSTNode {
	private DictEntry data;
	private Position key;
	private BSTNode left, right, parent;
	
	/**
	 * Constructor which returns a new BSTNode with data from a specific DictEntry.
	 */
	public BSTNode(DictEntry data){
		this.data = data;
		if(data != null)
			key = data.getPosition();
		left = null;
		right = null;
		parent = null;
	}
	
	/**
	 * This method returns the left child of the node.
	 * @return left
	 */
	public BSTNode getLeft(){
		return left;
	}
	
	/**
	 * This method returns the right child of the node.
	 * @return right
	 */
	public BSTNode getRight(){
		return right;
	}
	
	/**
	 * This method returns the key of the node.
	 * @return key
	 */
	public Position getKey(){
		return key;
	}
	
	/**
	 * This method returns the DictEntry of the node.
	 * @return DictEntry data
	 */
	public DictEntry getDictEntry(){
		return data;
	}
	
	/**
	 * This method returns the parent of the node.
	 * @return parent of the node
	 */
	public BSTNode getParent(){
		return parent;
	}
	
	/**
	 * This method sets the left child of this node to the input BSTNode.
	 * @param node
	 */
	public void setLeft(BSTNode node){
		left = node;
		if(node != null)
			left.setParent(this);
	}
	
	/**
	 * This method sets the right child of this node to the input BSTNode.
	 * @param node
	 */
	public void setRight(BSTNode node){
		right = node;
		if(node != null)
			right.setParent(this);
	}
	
	/**
	 * This method sets the parent of this node to the input BSTNode.
	 * @param node
	 */
	public void setParent(BSTNode node){
		parent = node;
	}
	
	/**
	 * This method sets the DictEntry of this node to the input DictEntry, as well as the key.
	 * @param node
	 */
	public void setData(DictEntry data){
		this.data = data;
		key = data.getPosition();
	}
}
