/**
 * 
 * @author ctam68
 * @author Student ID: 250679865
 * 
 * This class represents an entry in a Dictionary.
 *
 */
public class DictEntry {
	
	private String key;
	private int code;
	
	/**
	 * 
	 * @param key
	 * @param code
	 * 
	 * A constructor which returns a new DictEntry with the specified key and code.
	 * 
	 */
	public DictEntry(String key, int code){
		this.key = key;
		this.code = code;
	}
	
	/**
	 * 
	 * @return String key
	 * 
	 * This method returns the key in the entry.
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * 
	 * @return integer code
	 * 
	 * This method returns the code in the entry.
	 */
	public int getCode(){
		return code;
	}
	
}
