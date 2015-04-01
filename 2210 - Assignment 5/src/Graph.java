import java.util.Iterator;

/**
 * This class represents a graph.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class Graph implements GraphADT{
	private LabyrinthNode [] graph;
	private int numElements;
	
	public Graph(int n){
		numElements = n;
		graph = new LabyrinthNode [n];
		for(int i = 0; i < n; i++){
			graph[i] = new LabyrinthNode(i);
		}
	}
	
	/* Adds to the graph an edge connecting the given vertices.
    The type of the edge is as indicated. The label of the
	edge is set to the empty String. Throws a GraphException
	if either node does not exist or if the dege is already 
	in the graph.*/
	public void insertEdge(Node u, Node v, String edgeType) throws GraphException{
		//checks for non-existent node
		if(u.getName() < 0 || u.getName() >= numElements || v.getName() < 0 || v.getName() >= numElements){
			throw new GraphException("input node does not exist.");
		}
		//check if edge exists already
		else if(graph[u.getName()].isAdjacent(v)){
			throw new GraphException("edge already exists");
		}
		else{
			//add the edges to each node
			graph[u.getName()].addAdjacent(new Edge(u,v,edgeType));
			graph[v.getName()].addAdjacent(new Edge(v,u,edgeType));
		}
	}
	
	/* Returns the node with the specified name. Throws a 
    GraphException if the node does not exist. */
	public Node getNode(int name) throws GraphException{
		if(name < 0 || name >= numElements){
			throw new GraphException("node with input name does not exist");
		}
		else{
			return graph[name].getNode();
		}
	}
	
	/* Returns a JAva Iterator storing all the edges incident
    on the specified node. IT returns null if the node does
    not have any edges incident on it. Throws a GraphException
    if the node does not exist. */
	public Iterator<Edge> incidentEdges(Node u) throws GraphException{
		if(u.getName() < 0 || u.getName() >= numElements){
			throw new GraphException("input node does not exist.");
		}
		return graph[u.getName()].incidentEdges();
	}
	
	/* Returns the edge connecting the given vertices. Throws 
    a GraphException if there is no edge conencting the given 
    vertices or if u or v do not exist. */
	public Edge getEdge(Node u, Node v) throws GraphException{
		if(u.getName() < 0 || u.getName() >= numElements || v.getName() < 0 || v.getName() >= numElements){
			throw new GraphException("input node does not exist.");
		}
		Edge temp = graph[u.getName()].getAdjacent(v);
		if(temp == null){
			throw new GraphException("there is no edge between u and v");
		}
		else{
			return temp;
		}
	}
	
	/* Returns true is u and v are adjacent, and false otherwise. 
    It throws a GraphException if either vertex does not 
    exist. */
	public boolean areAdjacent(Node u, Node v) throws GraphException{
		if(u.getName() < 0 || u.getName() >= numElements || v.getName() < 0 || v.getName() >= numElements){
			throw new GraphException("input node does not exist.");
		}
		else{
			return graph[u.getName()].isAdjacent(v);
		}
	}
}
