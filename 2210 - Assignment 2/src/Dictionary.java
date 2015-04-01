/**
 * 
 * @author ctam68
 * @author Student ID: 250679865
 *
 * This class represents a dictionary, using DictEntry 's as individual entries in the dictionary.
 *
 */
public class Dictionary implements DictionaryADT{
	private LinkedDictEntry [] dictionary;
	private int num_entries;
	
	/**
	 * Constructor that initializes the size of the dictionary to the input integer
	 * @param inputsize - initial size of the dictionary
	 */
	public Dictionary(int inputsize){
		dictionary = new LinkedDictEntry [inputsize];
		num_entries = 0;
		
		for(int i = 0; i < inputsize; i++){
			dictionary[i] = null;
		}
		
	}
	
	/**
	 * @param pair - is the entry the user wants to put into the dictionary
	 * @return 1 if the insertion of the input DictEntry object produces a collision
	 * @return 0 if there is no collision
	 * 
	 * Inserts the given pair (string,code) in the dictionary. 
	 * Throws a DictionaryException if the key associated with pair, pair.getKey(), is already in the dictionary. 
	 */
	public int insert(DictEntry pair) throws DictionaryException {
		int mapvalue = HashCode(pair.getKey());
		
		//check if position mapvalue in the dictionary has something in it already (ie. a collision occurs)
		LinkedDictEntry temp = dictionary[mapvalue];
		if(temp != null){
			while(temp.getNext() != null){
				//check for duplicate keys
				if(temp.getKey().equals(pair.getKey())){
					throw new DictionaryException("pair already exists in dictionary.");
				}
				temp = temp.getNext();
			}
			
			//check for duplicate keys
			if(temp.getKey().equals(pair.getKey())){
				throw new DictionaryException("pair already exists in dictionary.");
			}
			
			temp.setNext(new LinkedDictEntry(pair.getKey(),pair.getCode()));
			num_entries++;
			return 1;
		}
		else{
			dictionary[mapvalue] = new LinkedDictEntry(pair.getKey(),pair.getCode());
			num_entries++;
			return 0;
		}
	}
 
	
	/**
	 * @param key - The string that you wish to remove from the dictionary.
	 * 
	 * Removes the entry with the given key from the dictionary. 
	 * Throws a DictionaryException if the key is not in the dictionary
	 */
	public void remove(String key) throws DictionaryException {
		int mapvalue = HashCode(key);
		finished:
		
		//check if there is a node at the mapvalue location in the dictionary
		if(dictionary[mapvalue] == null){
			throw new DictionaryException("Key you are trying to remove is not in the dictionary.");
		}
		else{
			LinkedDictEntry temp = dictionary[mapvalue];
			
			//loop through the linked list
			while(temp != null){
				//check if the current node in the list is the one the user is trying to remove
				if(temp.getKey().equals(key)){
					//check if there is a node that temp is pointing to
					if(temp.getNext() == null){
						dictionary[mapvalue] = null;
						num_entries--;
						break finished;
					}
					else{
						dictionary[mapvalue] = temp.getNext();
						num_entries--;
						break finished;
					}
				}
				temp = temp.getNext();
			}	
			//if it gets here, there was a linked list in the slot of the mapvalue, but the key was not in the linked list
			throw new DictionaryException("Key you are trying to remove is not in the dictionary.");
		}
	}

	
	/**
	 * @param  key - The string the user is looking for in the dictionary.
	 * @return DictEntry object stored in the dictionary with the input key
	 * @return null if such key does not exist
	 * 
	 * A method which returns the DictEntry object stored in the dictionary with the given key, or null if no entry in the dictionary has the given key.
	 */
	public DictEntry find(String key) {
		//find the hashcode associated with the input key
		int search = HashCode(key);
		
		//check if it is in the dictionary
		//there is no linked list in the specified spot that the hash code points us to, therefore the key is not in the dictionary
		if(dictionary[search] == null){
			return null;
		}
		else{
			//have to check if the key is in the linked list
			LinkedDictEntry temp = dictionary[search];
			while(temp != null){
				if(temp.getKey().equals(key)){
					return new DictEntry(temp.getKey(),temp.getCode());
				}
				temp = temp.getNext();
			}
			return null;
		}
	}

	
	/**
	 * A method that returns the number of DictEntry objects stored in the dictionary.
	 * @return number of elements in the dictionary
	 */
	public int numElements() {
		return num_entries;
	}
	
	/**
	 * @param input - the input string
	 * @return converted code from the input
	 * 
	 * This method converts an input String into an integer code.
	 */
	public int HashCode(String input){
		//I am using the polynomial accumulation method
		int sum = 0;
		int z = 33;

		//biggest prime under 4096, unfortunately this means that 3 values in the dictionary will be unused
		int N = dictionary.length;
		
		//Horner's method
		for(int i = 0; i < input.length(); i++){
			sum = (sum*z + (int)input.charAt(i)) % N;
		}
		
		//Compression map using MAD method
		int a = 97;
		int b = 37;
		
		//the value which the key will be mapped to
		int compressed = (a * sum+b) % N;
		return compressed;		
	}
}
