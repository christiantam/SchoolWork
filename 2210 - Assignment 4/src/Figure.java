/**
 * This class represents an figure.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */	
public class Figure implements FigureADT{
	private int id, width, height, type;
	private Position pos;
	private BinarySearchTree tree;
	
	/**
	 * Constructor which returns a new Figure with the specified parameters.
	 */
	public Figure(int id, int width, int height, int type, Position pos){
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		tree = new BinarySearchTree();
	}
	
	/**
	 * Sets type of figure to the specified value.
	 */
	public void setType(int t){
		type = t;
	}
    
	/**
	 * Returns the width of the enclosing rectangle for this figure.
	 */
	public int getWidth(){
    	return width;
    }
    
	/**
	 * Returns the height of the enclosing rectangle for this figure.
	 */
    public int getHeight(){
    	return height;
    }
    
    /**
	 * Returns the type of this figure.
	 */
    public int getType(){
    	return type;
    }
    
    /**
	 * Returns the id of this figure.
	 */
    public int getId(){
    	return id;
    }
    
    /**
	 * Returns the offset of this figure.
	 */
    public Position getOffset(){
    	return pos;
    }
    
    /**
	 * Changes the offset of this figure to the specified value
	 */
    public void setOffset(Position value){
    	pos = value;
    }
    
    /**
	 * Creates a DictEntry to represent the given pixel and inserts it into the binary search tree associated with this figure.
	 * @throws BSTEception if an error occurs when inserting the pixel into the tree
	 */
    public void addPixel(int x, int y, int rgb) throws BSTException{
    	tree.insert(new DictEntry(new Position(x,y),rgb));
    }
   
    /**
     * Returns true if this figure intersects the one specified in the parameter.
     * It returns false otherwise.
     */
    public boolean intersects(Figure fig){
    	//check whether rectangles overlap first, before checking pixels
    	Position thisUL, thisUR, thisLL, thisLR, otherUL, otherUR, otherLL, otherLR;
    	
    	//upper left, upper right, lower left, and lower right corners of this figure
    	thisUL = new Position(pos.getX(),pos.getY());
    	thisUR = new Position(pos.getX() + width,pos.getY());
    	thisLL = new Position(pos.getX(),pos.getY() + height);
    	thisLR = new Position(pos.getX() + width,pos.getY() + height);

    	//upper left, upper right, lower left, and lower right corners of input figure
    	otherUL = new Position(fig.getOffset().getX(),fig.getOffset().getY());
    	otherUR = new Position(fig.getOffset().getX() + fig.getWidth(),fig.getOffset().getY());
    	otherLL = new Position(fig.getOffset().getX(),fig.getOffset().getY() + fig.getHeight());
    	otherLR = new Position(fig.getOffset().getX() + fig.getWidth(),fig.getOffset().getY() + fig.getHeight());
    	
    	boolean checkX, checkY, checkLeft, checkRight, checkUpper, checkLower;
    	
    	//check right side of this figure against left side of input figure
    	checkX = (thisUR.getX() >= otherUL.getX()) && (thisUR.getX() <= otherUR.getX());
    	checkY = (thisUR.getY() >= otherUL.getY()) && (thisUR.getY() <= otherLL.getY()) || (thisLR.getY() >= otherUL.getY()) && (thisLR.getY() <= otherLL.getY());
 
    	//checks for if this figure's height is greater than the input figure's height and if this figure "engulfs" the input figure
    	if((checkX) && (checkY == false)){
    		checkY = (thisUL.getY() < otherUL.getY()) && (thisLR.getY() > otherLR.getY());
    	}
    	checkRight = (checkX == true) && (checkY == true);
    	
    	if(checkRight){
    		//check pixels
    		return checkPixels(fig);
    	}
    	
    	//check left side of this figure against right side of input figure
    	checkX = (thisUL.getX() >= otherUL.getX()) && (thisUL.getX() <= otherUR.getX());
    	checkY = (thisUR.getY() >= otherUL.getY()) && (thisUR.getY() <= otherLL.getY()) || (thisLR.getY() >= otherUL.getY()) && (thisLR.getY() <= otherLL.getY());
    	
    	//checks for if this figure's height is greater than the input figure's height and if this figure "engulfs" the input figure
    	if((checkX) && (checkY == false)){
    		checkY = (thisUL.getY() < otherUL.getY()) && (thisLR.getY() > otherLR.getY());
    	}
    	
    	checkLeft = (checkX == true) && (checkY == true);
    	
    	if(checkLeft){
    		//check pixels
    		return checkPixels(fig);
    	}
    	
    	//check upper side of this figure against lower side of input figure
    	checkX = (thisUL.getX() >= otherUL.getX()) && (thisUL.getX() <= otherUR.getX()) || (thisUR.getX() >= otherUL.getX()) && (thisUR.getX() <= otherUR.getX());
    	checkY = (thisUL.getY() >= otherUL.getY()) && (thisUL.getY() <= otherLL.getY());
    	
    	//checks for if this figure's width is greater than the input figure's width and if this figure "engulfs" the input figure
    	if((checkY) && (checkX == false)){
    		checkX = (thisUL.getX() < otherUL.getX()) && (thisLR.getX() > otherLR.getX());
    	}

    	checkUpper = (checkX == true) && (checkY == true);    	
    	if(checkUpper){
    		//check pixels
    		return checkPixels(fig);
    	}

    	//check lower side of this figure against upper side of input figure
    	checkX = (thisUL.getX() >= otherUL.getX()) && (thisUL.getX() <= otherUR.getX()) || (thisUR.getX() >= otherUL.getX()) && (thisUR.getX() <= otherUR.getX());
    	checkY = (thisLL.getY() >= otherUL.getY()) && (thisLL.getY() <= otherLL.getY());
  
    	//checks for if this figure's width is greater than the input figure's width and if this figure "engulfs" the input figure
    	if((checkY) && (checkX == false)){
    		checkX = (thisUL.getX() < otherUL.getX()) && (thisLR.getX() > otherLR.getX());
    	}

    	checkLower = (checkX == true) && (checkY == true);
    	if(checkLower){
    		//check pixels
    		return checkPixels(fig);
    	}
    	
    	//if it gets here, all four checks are false, therefore, the figures do not intersect.
    	return false;
    	
    }
    
    /**
     * Returns true if there is a position in this figure which is also in the input figure.
     * Returns false otherwise.
     */
    private boolean checkPixels(Figure fig){
    	DictEntry current = tree.smallest();
    	Position temp;
    	
    	//traverse through the tree checking if each node in this figure's tree is in the other figure's tree
    	while(current != null){
    		temp = new Position(current.getPosition().getX() + pos.getX() - fig.getOffset().getX(), current.getPosition().getY() + pos.getY() - fig.getOffset().getY());
    		if(fig.tree.find(temp) != null){
    			return true;
    		}
    		current = tree.successor(current.getPosition());
    	}
    	return false;
    }
}
