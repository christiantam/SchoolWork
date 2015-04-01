/**
 * 
 * @author ctam68
 * @author Student ID: 250679865
 * 
 * This class represents a linked DictEntry.
 * It is used to implement separate chaining.
 * It is a DictEntry with a pointer to the next entry in the list.
 *
 */
public class LinkedDictEntry extends DictEntry{

	private LinkedDictEntry next;
	
	/**
	 * Constructor
	 * @param key
	 * @param code
	 */
	public LinkedDictEntry (String key, int code){
		super(key, code);
		next = null;
	}

	/**
	 * 
	 * @param input
	 * 
	 * This method sets the next value to the input DictEntry
	 * This method is used for separate chaining, like a linked list
	 * 
	 */
	public void setNext(LinkedDictEntry input){
		next = input;
	}
	
	/**
	 * This method returns the next DictEntry that this one points to
	 * @return the DictEntry that the current one points to
	 */
	public LinkedDictEntry getNext(){
		return next;
	}
}
