import java.awt.*;
import javax.swing.*;

/**
 * I WOKE UP AT 11 AM YAYYY
 * @author ctam68
 * 
 * This class is used in the mazeframe class to draw stuff
 *
 */
public class MazePanel extends JPanel  {
	//default size of the objects
	final int SQUARE_SIZE = 30;
	//grey
	final Color GREY = new Color(200, 200, 200);
	
	
	// maybe something here
	// queue to hold all the objects that need to be drawn
	private LinkedQueue<GraphicalObject> queue = new LinkedQueue<GraphicalObject>();
	
	/**
	 * Adds an object to the list (queue) of stuff to draw :D
	 * @param obj the object you want to add to draw
	 */
	void add(GraphicalObject obj){
		// your code here
		queue.enqueue(obj);
	}
	
	/**
	 * Constructor
	 * Creates a panel with dimensions h and w
	 * Sets the background colour to grey
	 * @param h height of the panel
	 * @param w width of the panel
	 */
	MazePanel(int h, int w){
		// you may add something here
		// I didn't add anything lol
		Dimension g = new Dimension(SQUARE_SIZE*w, SQUARE_SIZE*h);
		setPreferredSize(g);
		setBackground(GREY);
		
	}
	
	/**
	 * Paints everything in the panel using the queue
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		GraphicalObject temp;
		
		// your code here
		// takes the original queue size
		// now that I think about it, this isn't necessary
		int qsize = queue.size();
		
		//dequeues an object, draws it, enqueues that object for every object in the queue
		for(int i = 0; i < qsize; i++){
			temp = queue.dequeue();
			temp.draw(g, SQUARE_SIZE);
			queue.enqueue(temp);
		}
	}
}