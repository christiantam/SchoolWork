import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 * This class represents a labyrinth.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class Labyrinth {
	Graph graph;
	BufferedReader in;
	int width;
	int length;
	int bombs;
	
	//node names of the entrance and exit
	int entrance;
	int exit;
	
	/**
	 * Constructor for building a labyrinth from the contents of the input file.
	 * Throws LabyrinthException if the input file does not exist.
	 */
	public Labyrinth(String inputFile) throws Exception{
		try {
			in = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			throw new LabyrinthException("File does not exist.");
		}
		
		//read S
		String currentLine = in.readLine();
		
		//read W
		currentLine = in.readLine();
		width = Integer.parseInt(currentLine);

		//read L
		currentLine = in.readLine();
		length = Integer.parseInt(currentLine);

		graph = new Graph(width * length);
		
		//read K
		currentLine = in.readLine();
		bombs = Integer.parseInt(currentLine);
		
		String currentCharacter;
		int count = -1;
		//read rest of the lines
		for(int i = 0; i < length*2 - 1; i++){
			currentLine = in.readLine();
			//read individual characters
			for(int j = 0; j < width*2 - 1; j++){
				currentCharacter = currentLine.substring(j,j+1);
				
				//check if the current character is a room
				if(currentCharacter.equals("o")){
					count++;
				}
				//horizontal wall
				else if(currentCharacter.equals("h")){
					graph.insertEdge(graph.getNode(count), graph.getNode(count + 1), "wall");
				}
				//horizontal hall
				else if(currentCharacter.equals("-")){
					graph.insertEdge(graph.getNode(count), graph.getNode(count + 1), "hall");
				}
				//vertical wall
				else if(currentCharacter.equals("v")){
					graph.insertEdge(graph.getNode(j/2 + i/2*width), graph.getNode(j/2 + (i/2 + 1)*width), "wall");
				}
				//vertical hall
				else if(currentCharacter.equals("|")){
					graph.insertEdge(graph.getNode(j/2 + i/2*width), graph.getNode(j/2 + (i/2 + 1)*width), "hall");
				}
				//unbreakable, solid rock
				else if(currentCharacter.equals(" ")){
					//do nothing
				}
				//entrance to the labyrinth
				else if(currentCharacter.equals("s")){
					count++;
					entrance = count;
				}
				//exit from the labyrinth
				else if(currentCharacter.equals("e")){
					count++;
					exit = count;
				}
			}
		}
		in.close();
	}
	
	/**
	 * Returns a reference to the graph representing the labyrinth.
	 * Throws a LabyrinthException if the graph is not defined.
	 */
	public Graph getGraph() throws LabyrinthException{
		if(graph == null){
			throw new LabyrinthException("graph is not defined.");
		}
		return graph;
	}
	
	/**
	 * Returns a java Iterator containing the nodes along the path from the 
	 * 	entrance to the exit of the labyrinth, if such a path exists. If the 
	 * 	path does not exist, this method returns the value null.
	 */
	public Iterator<Node> solve() throws GraphException{
		LinkedStack<Node> stack = new LinkedStack<Node>();
		LinkedStack<Node> path = new LinkedStack<Node>();
		int wallEdges = 0;
		
		//push entrance onto the path stack and mark it
		Node entranceNode = graph.getNode(entrance);
		path.push(entranceNode);
		entranceNode.setMark(true);
		
		Node temp;
		//push adjacent nodes of the entrance onto the stack
		Iterator<Edge> adjacentNodes = graph.incidentEdges(entranceNode);
		while(adjacentNodes.hasNext()){
			stack.push(adjacentNodes.next().secondEndpoint());
		}
		while(!stack.isEmpty()){
			//pop node off stack
			temp = stack.pop();
			//mark it
			temp.setMark(true);
			//push it onto the current path
			Node u = null;
			if(!path.isEmpty())
				 u = path.peek();
			path.push(temp);
			
			//if it's not the entrance node, mark the edge
			if(!path.isEmpty()){
				Edge labelthis = graph.getEdge(u, temp);
				labelthis.setLabel("discover");

				//check if a bomb is needed
				if(labelthis.getType().equals("wall")){
					wallEdges++;
				}
			}

			//check if it's the exit
			if(temp.getName() == exit)
				return reverse(path.iterator());

			//push nodes that connect to temp
			//push nodes that require bombs only if I have bombs available
			adjacentNodes = graph.incidentEdges(temp);
			int numAdjacentNodes = 0;
			while(adjacentNodes.hasNext()){
				Edge connection = adjacentNodes.next();
				
				//check if the edge is marked
				if(connection.secondEndpoint().getMark() == false){
					//edge is a wall, have to check if we have sufficient bombs
					if(connection.getType().equals("wall")){
						if(wallEdges < bombs){
							stack.push(connection.secondEndpoint());
							numAdjacentNodes++;
						}
					}
					//edge is a hall
					else{
						stack.push(connection.secondEndpoint());
						numAdjacentNodes++;
					}
				}
			}
			
			//backtrack algorithm			
			if(numAdjacentNodes == 0){
				Node backtrack;
				int valid = 0;
				Iterator<Edge> check;
				
				while(valid == 0){
					valid = 0;
					backtrack = path.pop();
					
					//unmark the node we backtrack from
					backtrack.setMark(false);
					
					//erase labels from node we backtracked from
					check = graph.incidentEdges(backtrack);
					while(check.hasNext()){
						check.next().setLabel("");
					}

					//replace bombs, if one was used
					if(graph.getEdge(backtrack, path.peek()).equals("wall")){
						wallEdges--;
					}
					
					//label the edge as backtrack
					graph.getEdge(path.peek(), backtrack).setLabel("backtrack");
					
					backtrack = path.peek();
					
					//check if we backtracked to the entrance, and if the stack is empty
					if(backtrack.getName() == entrance && stack.isEmpty()){
						return null;
					}
					
					//backtrack check
					//keep backtracking until you get to a node which has an incident edge that is
					//not labeled as backtrack, or which the second endpoint is not marked
					check = graph.incidentEdges(backtrack);
					while(check.hasNext()){
						Edge checktemp = check.next();
						if(checktemp.getLabel().equals("backtrack") || checktemp.secondEndpoint().getMark() == true){
							//do nothing
						}
						else if(checktemp.getType().equals("wall") && wallEdges >= bombs){
							//do nothing
						}
						else{
							valid++;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * This private method reverses the order of the elements in an iterator.
	 */
	private Iterator<Node> reverse(Iterator<Node> iter){
		LinkedStack<Node> temp = new LinkedStack<Node>();
		while(iter.hasNext())
			temp.push(iter.next());
		return temp.iterator();
	}
}
