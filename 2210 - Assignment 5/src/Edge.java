/**
 * This class represents an edge.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class Edge {
	private Node first;
	private Node second;
	private String type;
	private String label;
	
	/**
	 * Constructor which initializes the endpoints of the edge, as well as the type.
	 */
	public Edge(Node u, Node v, String type){
		first = u;
		second = v;
		this.type = type;
		label = "";
	}
	
	/**
	 * This method returns the first endpoint of the edge.
	 */
	public Node firstEndpoint(){
		return first;
	}

	/**
	 * This method returns the second endpoint of the edge.
	 */
	public Node secondEndpoint(){
		return second;
	}
	
	/**
	 * This method returns the type of the edge.
	 */
	public String getType(){
		return type;
	}

	/**
	 * This method sets the label of the edge.
	 */
	public void setLabel(String label){
		this.label = label;
	}

	/**
	 * This method returns the label of the edge.
	 */
	public String getLabel(){
		return label;
	}
}
