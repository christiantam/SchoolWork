/**
 * 
 * @author ctam68 
 * I made dis
 * 
 * I think it's a test method for my program...., not sure though :DDDDDDD
 * I actually think I did the assignment incorrectly because the end result of maze2 with stackExplorator looks off...
 *
 */

public class Test{
	public static void main(String args[]){
	    
		//test StackExplorator
		Maze maze = new Maze("maze2.txt");
	    Explorator s = new StackExplorator();
	    System.out.println(maze.explore(s));
	    
	    //test QueueExplorator
	    maze = new Maze("maze2.txt");
	    Explorator q = new QueueExplorator();
	    System.out.println(maze.explore(q));
	}
}