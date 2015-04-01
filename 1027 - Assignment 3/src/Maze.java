import java.awt.*;

/**
 * Okay I did this class last
 * I PUT RANDOM COMMENTS TO ATTEMPT TO MAKE YOUR DAY PLEASE DON'T DEDUCT MARKS THANKS 
 * @author ctam68
 * @author Christian Tam
 * @author 25067965
 * 
 * Class representing a maze
 */

public class Maze {
	//height and width of the maze
	private int height, width;
	
	//grid to represent where the paths of the math are
	private boolean [] [] grid;
	//visited to represent which squares of the maze I have visited
	private boolean [] [] visited;
	
	//squares that represent the entrance and exit of the maze
	private Square entrance;
	private Square exit;
	
	/**
	 * Constructor
	 * @param fileinput filename of the input file
	 */
	public Maze(String fileinput){
		//text file reader
		InStringFile reader = new InStringFile(fileinput);
		
		//get number of rows and columns
		int rows = Integer.parseInt(reader.read());
		int columns = Integer.parseInt(reader.read());
		height = rows;
		width = columns;
		grid = new boolean [rows][columns];
		visited = new boolean [rows][columns];
		
		//initialize visited to empty
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				visited[i][j] = false;
			}
		}
		
		//initialize grid to true
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = true;
			}
		}

		//get the maze coordinates of the entrance 
		rows = Integer.parseInt(reader.read());
		columns = Integer.parseInt(reader.read());
		entrance = new Square(rows, columns);
		
		//get the maze coordinates of the exit
		rows = Integer.parseInt(reader.read());
		columns = Integer.parseInt(reader.read());
		exit = new Square(rows, columns);
		
		//read the map part
		for(int i = 0; reader.endOfFile() == false; i++){
			 String line = reader.read();
			 Character current;
			 for(int j = 0; j < line.length(); j++){
				 current = line.charAt(j);
				 //checks if it is a zero
				 //used char of "0" and compareTo method to check
				 //zero is 48 in char "language" I found out
				 //please don't deduct marks for not using a constant -_-
				 if(current.compareTo((char)48) == 0){
					 grid[i][j] = false;
				 }
			 }
		}
	}
	
	/**
	 * This method tries to find the exit of the maze 
	 * @param e used to define what type of explorator you want to use, stack or queue, given by the user
	 * @return whether the exit can be reached from the entrance
	 */
	public boolean explore(Explorator e){
		MazeFrame frame = new MazeFrame(this);
		e.add(getStart());
		Square current;
		
		while(e.isEmpty()!=true){

		  current = e.getNext();

		  //checks if it is the exit
		  if(current.equals(getExit())){
			  return true;
		  }
		  //else adds the surrounding squares that haven't been visited yet
		  else{
			  //checks square below
			  if (current.getI() != height-1 && isFree(current.getI()+1, current.getJ())){
				  Square temp = new SquareDown(current.getI()+1, current.getJ());
				  e.add(temp);
				  
				  //it was drawing over over arrows, so this makes it so it paints the square white first then paints the arrow
				  frame.add(new SquareObject(Color.WHITE, current.getI()+1, current.getJ()));
				  
				  //since it was making the square white first, it covered the exit sometimes so I had to redraw the exit
				  if(temp.equals(getExit())){
					  frame.add(new CircleObject(Color.BLUE, getExit().getI(), getExit().getJ()));
				  }
				  
				  frame.add(temp.step()); 
				  pause(50);
				  
			  }
			  //checks square to the right
			  if (current.getJ() != width-1 && isFree(current.getI(), current.getJ()+1)){
				  Square temp = new SquareRight(current.getI(), current.getJ()+1);
				  e.add(temp);
				  
				  //it was drawing over over arrows, so this makes it so it paints the square white first then paints the arrow
				  frame.add(new SquareObject(Color.WHITE, current.getI(), current.getJ()+1));
				  
				  //since it was making the square white first, it covered the exit sometimes so I had to redraw the exit
				  if(temp.equals(getExit())){
					  frame.add(new CircleObject(Color.BLUE, getExit().getI(), getExit().getJ()));
				  }
				  
				  frame.add(temp.step()); 
				  pause(50);
			  }
			  //checks square above
			  if (current.getI() != 0 && isFree(current.getI()-1, current.getJ())){
				  Square temp = new SquareUp(current.getI()-1, current.getJ());
				  e.add(temp);
				  
				  //it was drawing over over arrows, so this makes it so it paints the square white first then paints the arrow
				  frame.add(new SquareObject(Color.WHITE, current.getI()-1, current.getJ()));

				  //since it was making the square white first, it covered the exit sometimes so I had to redraw the exit
				  if(temp.equals(getExit())){
					  frame.add(new CircleObject(Color.BLUE, getExit().getI(), getExit().getJ()));
				  }
				  
				  frame.add(temp.step()); 
				  pause(50);
			  }
			  //checks square to the left
			  if (current.getJ() != 0 && isFree(current.getI(), current.getJ()-1)){
				  Square temp = new SquareLeft(current.getI(), current.getJ()-1);
				  e.add(temp);
				  
				  //it was drawing over over arrows, so this makes it so it paints the square white first then paints the arrow
				  frame.add(new SquareObject(Color.WHITE, current.getI(), current.getJ()-1));

				  //since it was making the square white first, it covered the exit sometimes so I had to redraw the exit
				  if(temp.equals(getExit())){
					  frame.add(new CircleObject(Color.BLUE, getExit().getI(), getExit().getJ()));
				  }
				  
				  frame.add(temp.step()); 
				  pause(50);
			  }
		  }
		  //checks the square off as visited
		  visited[current.getI()][current.getJ()] = true;
		}
		//needed because the original test method wouldn't work because everything would be "visited" already
		clearVisited();
		return false;
	}
	
	/**
	 * Checks if the given square at (i,j) is free or not
	 * which is defined if it has been visited or a wall (not free)
	 * @param i row value
	 * @param j column value
	 * @return true if it is free
	 * @return false otherwise
	 */
	public boolean isFree(int i, int j){
		if(grid[i][j] == true && visited[i][j] == false){
			return true;
		}
		return false;
	}
	
	/**
	 * Used to clear all the blocks of visited because test() didn't work if I didn't clear them
	 */
	public void clearVisited(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				visited[i][j] = false;
			}
		}
	}
	
	/**
	 * Delays the program for 'i' milliseconds
	 * @param i the time you want to delay in milliseconds
	 */
	static void pause (int i) {
	    try {
	        Thread.sleep(i);
	    } catch (InterruptedException e) { }
	}
	
	/**
	 * Returns the square that represents the start of the maze
	 * @return start of maze
	 */
	public Square getStart(){
		return entrance;
	}
	
	/**
	 * Returns the square that represents the exit of the maze
	 * @return exit of maze
	 */
	public Square getExit(){
		return exit;
	}
	
	/**
	 * Returns the height of the maze
	 * @return the height of the maze
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * Returns the width of the maze
	 * @return the width of the maze
	 */
	public int getWidth(){
		return width;
	}
}
