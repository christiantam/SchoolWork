/**
 * 
 * @author ctam68
 * kay I actually wrote this one I promise * 2
 *
 * Stack implementation of the Explorator interface
 * YOU HAVE NO IDEA HOW BADLY I WANT TO PLAY HOTS RIGHT NOW T_T 
 * WHY YOU MAKIN' ME DO DIS
 */

public class StackExplorator implements Explorator{
	
	//stack to represent the exploratorrrrrrrrrrrrrr
	LinkedStack<Square> stack;
	
	//default constructorrrrrrrrrrrrrrrrrrrrr rhymes with exploratorrrrrrrrrrrrrrrrrrrrrr
	public StackExplorator(){
		stack = new LinkedStack<Square>();
	}
	
	//empties the stack explorator (ezpz)
	public void clear() {
		while(!stack.isEmpty()){
			stack.pop();
		}
	}
	
	//returns a boolean telling the user if the queue explorator is empty or not
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	//returns the next square in the queue
	public Square getNext() {
		return stack.pop();
	}
	
	/**
	 * Adds a square to the stack
	 * @param s is the square you want to add
	 */
	public void add(Square s) {
		stack.push(s);
	}
}
