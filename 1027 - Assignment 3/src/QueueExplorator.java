/**
 * 
 * @author ctam68
 * kay I actually wrote this one I promise
 *
 * Queue implementation of the Explorator interface
 */

public class QueueExplorator implements Explorator{
	
	//queue to represent the explorator
	LinkedQueue<Square> queue;
	
	//default constructor
	public QueueExplorator(){
		queue = new LinkedQueue<Square>();
	}
	
	//empties the queue explorator, don't know why you would use doe (though)
	public void clear() {
		while(!queue.isEmpty()){
			queue.dequeue();
		}
	}
	
	//returns a boolean telling the user if the queue explorator is empty or not
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	//returns the next square in the queue
	public Square getNext() {
		return queue.dequeue();
	}
	
	/**
	 * Adds a square to the Queue
	 * @param s is the square you want to add
	 */
	public void add(Square s) {
		queue.enqueue(s);
	}
}
