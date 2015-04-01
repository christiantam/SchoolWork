/**
 * 
 * @author ctam68
 * lol I didn't actually write this code, but I guess I'll take credit for it if Eclipse wants me to :)
 *
 * An interface that is meant to be implemented using stacks n' queues yo
 * very interesting name for the class
 */

public interface Explorator{
	//I really don't want to be commenting right now
	//I could be playing HotS campaign :(
	
	//a method to clear the EXPLORATOR
	void clear();
	
	//method that returns a boolean variable telling the user if the EXPLORATOR is empty or not
	boolean isEmpty();
	
	//returns the next Square in the EXPLORATOR (sounds so epic)
	Square getNext();
	
	//adds a square to the implemented EXPLORATOR
	void add(Square s);
}