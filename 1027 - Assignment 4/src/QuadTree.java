/**
 * Class representing a QuadTree consisting of QuadNodes
 * 
 * @author Christian Tam
 * @author ctam68
 * @author 250679865
 *
 * read the readme.txt file if you have not already!
 */
public class QuadTree {
	//root QuadNode of the tree
	private QuadNode root;
	
	/**
	 * Constructor
	 * @param pic 			input picture
	 * @param input 		input QuadNode
	 * @param maxLevel 		the maximum level of the height of the tree
	 * @param RedT 			threshold for the colour red
	 * @param GreenT 		threshold for the colour green
	 * @param BlueT 		threshold for the colour blue
	 */
	public QuadTree(MyPicture pic, QuadNode input, int maxLevel, double RedT, double GreenT, double BlueT){
		root = split(pic, input, maxLevel, RedT, GreenT, BlueT);
	}
	
	/**
	 * Splits the picture into 4 equal sections if the area given by the node is not homogeneous
	 * Keeps splitting by recursion
	 * 
	 * @param pic 			input picture
	 * @param inputnode 	input node in which the area of the section of the picture we are interested in is given
	 * @param maxLevel 		maximum level of splits
	 * @param RedT 			threshold for the colour red
	 * @param GreenT 		threshold for the colour green
	 * @param BlueT 		threshold for the colour blue
	 * @return 				input node, with any additional children made from splitting, if needed
	 */
	public QuadNode split(MyPicture pic, QuadNode inputnode, int maxLevel, double RedT, double GreenT, double BlueT){
		//statistics for the area of the picture given by the inputnode
		double [] stats = pic.simpleStatistics(inputnode.getX(), inputnode.getY(), inputnode.getSideLength());
		QuadNode node = new QuadNode(pic, inputnode.getX(), inputnode.getY(), inputnode.getSideLength(), inputnode.getLevel(), stats);
		
		//base case
		if(isHomogeneous(node, stats, maxLevel, RedT, GreenT, BlueT)){
			return node;
		}
		else{
			//north-west quadrant
			QuadNode nw = new QuadNode(pic, inputnode.getX(), inputnode.getY(), inputnode.getSideLength()/2, inputnode.getLevel() + 1, stats);
			node.setNorthWest(split(pic, nw, maxLevel, RedT, GreenT, BlueT));
			
			//north-east quadrant
			QuadNode ne = new QuadNode(pic, inputnode.getX() + inputnode.getSideLength()/2, inputnode.getY(), inputnode.getSideLength()/2, inputnode.getLevel() + 1, stats);
			node.setNorthEast(split(pic, ne, maxLevel, RedT, GreenT, BlueT));
			
			//south-west quadrant
			QuadNode sw = new QuadNode(pic, inputnode.getX(), inputnode.getY() + inputnode.getSideLength()/2, inputnode.getSideLength()/2, inputnode.getLevel() + 1, stats);
			node.setSouthWest(split(pic, sw, maxLevel, RedT, GreenT, BlueT));
			
			//south-east quadrant
			QuadNode se = new QuadNode(pic, inputnode.getX() + inputnode.getSideLength()/2, inputnode.getY() + inputnode.getSideLength()/2, inputnode.getSideLength()/2, inputnode.getLevel() + 1, stats);
			node.setSouthEast(split(pic, se, maxLevel, RedT, GreenT, BlueT));
		}
		return node;
	}
	
	/**
	 * This method returns a boolean telling the user if the given area of a picture is homogeneous
	 * 
	 * @param node 			the input node; used to find what level it is at
	 * @param stats 		array of doubles containing the average colour values of the area, aswell as the sigma colour values
	 * @return true 		if the area is deemed homogenous by the threshold values
	 * @return false 		otherwise
	 */
	public boolean isHomogeneous(QuadNode node, double [] stats, int maxLevel, double RedT, double GreenT, double BlueT){
		//checks if the area meets the criteria for homogeneity
		if((stats[3] <= RedT && stats[4] <= GreenT && stats[5] <= BlueT) || node.getLevel() == maxLevel){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * This method tells the user if the given input node is a leaf
	 * 
	 * @param input 	the node the user wants to check
	 * @return true 	if the node is a leaf
	 * @return false 	otherwise
	 */
	public boolean isLeaf(QuadNode input){
		//check north-west child
		if(input.getNorthWest() != null){
			return false;
		}
		//check north-east child
		else if(input.getNorthEast() != null){
			return false;
		} 
		//check south-west child
		else if(input.getSouthWest() != null){
			return false;
		} 
		//check south-east child
		else if(input.getSouthEast() != null){
			return false;
		}
		//return true if no children
		return true;
	}
	
	/**
	 * This method returns a queue in which the elements are the leaves of the input node, given by a preorder traversal of the tree underneath the node
	 * 
	 * @param node 		the inputnode in which the user wants to start the traversal from
	 * @param queue 	the queue which the user wants to enqueue the leaves
	 * @return 			the input queue, plus enqueued leaves
	 */
	public LinkedQueue<QuadNode> preorder(QuadNode node, LinkedQueue<QuadNode> queue){
		//uses preorder2 to find leaves
		QuadNode temp = find(node, root);
		if(temp != null){
			preorder2(temp, queue);
		}
	    return queue;
	}
	
	/**
	 * Performs a recursive preorder traversal.
     *
     * @param node  	the node to be used as the root for this traversal
     * @param queue  	the temporary list for use in this traversal
	 */
	protected void preorder2 (QuadNode node, LinkedQueue<QuadNode> queue){
		//checks if the node is a leaf
		if(isLeaf(node)){
			queue.enqueue(node);
		}
		//otherwise checks the children
		else{
			preorder2(node.getNorthWest(), queue);
			preorder2(node.getNorthEast(), queue);
			preorder2(node.getSouthWest(), queue);
			preorder2(node.getSouthEast(), queue);
		}
	}
	
	/**
	 * Draws the segmentation of the picture, using the elements in the input queue
	 * @param pic 		the picture in which we are drawing on top of
	 * @param queue 	contains quadnodes in which hold the dimensions of the segmentations we need to draw
	 */
	public void drawSegmentation(MyPicture pic, LinkedQueue<QuadNode> queue){
		QuadNode node;
		int num = queue.size();
		
		//dequeue and requeue to keep the queue "unchanged"
		for(int i = 0; i < num; i++){
			node = queue.dequeue();
			
			//draws the white square representing a segmentation
			pic.drawWhiteSquare(node.getX(), node.getY(), node.getSideLength());
			
			queue.enqueue(node);
		}
	}
	
	/**
	 * Draws squares of solid colour over the input picture
	 * the squares' dimensions are given by the elements in the input queue
	 * 
	 * @param pic 		input picture in which we are drawing on top of
	 * @param queue 	contains quadnodes in which hold the dimensions of the coloured squares we need to draw
	 */
	public void paintSquares(MyPicture pic, LinkedQueue<QuadNode> queue){
		QuadNode node;
		int num = queue.size();

		//dequeue and requeue to keep the queue "unchanged"
		for(int i = 0; i < num; i++){
			node = queue.dequeue();
			
			//draws the coloured square
			pic.paintSegment(node.getX(), node.getY(), node.getSideLength(), node.getMeanRed(), node.getMeanGreen(), node.getMeanBlue());
			
			queue.enqueue(node);
		}
	}
	
	/**
	 * Returns a reference to the specified target element if it is found in this QuadTree.
	 *
	 * @param input 	the element being sought in this tree
	 * @return 			reference to the specified target
	 * @return null 	if the element is not in the tree
	 */
	public QuadNode find(QuadNode input, QuadNode tree){
		QuadNode temp = findAgain(input, tree);
		return temp;
	}
	
	/**
	 * Returns a reference to the specified target element if it is found in this QuadTree.
	 *
	 * @param input  	the element being sought in this tree
	 * @param tree		the element to begin searching from
	 * @return 			the element if it is found
	 * @return null		if the element is not found
	 */
	private QuadNode findAgain(QuadNode input, QuadNode tree){
		if(tree == null){
			return null;
		}
		//checks if the x values, y values, sidelengths(and therefore level) is the same for both input and tree
		if((tree.getX() == input.getX()) && (tree.getY() == input.getY()) && (tree.getSideLength() == input.getSideLength())){
			return tree;
		}
		
		//checks north-west child
		QuadNode temp = findAgain(input, tree.getNorthWest());
		if(temp == null){
			temp = findAgain(input, tree.getNorthEast());
		}
		//checks north-east child
		if(temp == null){
			temp = findAgain(input, tree.getSouthWest());
		}
		//checks south-west child
		if(temp == null){
			temp = findAgain(input, tree.getSouthEast());
		}
		//south-east child
		//returns null if the south-east child does not contain the input node we are looking for
		//no need for if statement
		return temp;
	}
}
