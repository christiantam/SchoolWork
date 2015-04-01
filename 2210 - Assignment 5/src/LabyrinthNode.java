import java.util.Iterator;

/**
 * This class represents a node specifically used in a labyrinth problem.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class LabyrinthNode{
	//a node can only have 4 adjacent nodes
	//each edge's first endpoint should be this node
	private Edge [] adjacent;
	private int count;
	private Node node;
	
	/**
	 * Constructor
	 */
	public LabyrinthNode(int name){
		node = new Node(name);
		adjacent = new Edge [4];
		count = 0;
	}
	
	/**
	 * Adds an edge to the adjacent list.
	 */
	public void addAdjacent(Edge input){
		adjacent[count] = input;
		count++;
	}
	
	/**
	 * This method checks if the input node is adjacent to this node.
	 * Returns true if it is, false otherwise.
	 * 
	 */
	public boolean isAdjacent(Node input){
		for(int i = 0; i < count; i++){
			if(adjacent[i].secondEndpoint().getName() == input.getName())
				return true;
		}
		return false;
	}
	
	/**
	 * This method returns the adjacent edge of the input node.
	 * Returns null if there is no such edge between the input node and this node.
	 * 
	 */
	public Edge getAdjacent(Node input){
		for(int i = 0; i < count; i++){
			if(adjacent[i].secondEndpoint().getName() == input.getName())
				return adjacent[i];
		}
		return null;
	}
	
	/**
	 * Returns the number of nodes adjacent to this node. (ie. number of edges connected to this node.)
	 */
	public int getNumAdjacent(){
		return count;
	}
	
	/**
	 * Returns the node part of the labyrinth node.
	 */
	public Node getNode(){
		return node;
	}
	
	public Iterator<Edge> incidentEdges(){
		LinkedStack<Edge> stack = new LinkedStack<Edge>();
		for(int i = 0; i < count; i++){
			stack.push(adjacent[i]);
		}
		return stack.iterator();
	}
}
