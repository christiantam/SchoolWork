
/**
 * Class for a list of variables
 * @author ctam68
 * @author Christian Tam
 * @author 250679865
 */
public class VariableList {
	/**
	 * the array of variables is to hold all the variables in the I program
	 * int count is the number of variables in the list
	 */
	private Variable [] list;
	private int count;
	
	/**
	 * default constructor
	 */
	public VariableList(){
		list = new Variable[8];
		count = 0;
	}
	
	/**
	 * This method takes a variable name and value, and adds it to the list
	 * Normally will be used with only a name given, but I find it easier to do both name and value as there will be
	 * cases where a value is given with the name
	 * 
	 * @param varname is the name of the variable you are adding
	 * @param varvalue is the value of the variable you are adding
	 */
	public void add(String varname, String varvalue){
		Variable temp = new Variable(varname, varvalue);
		
		/**
		 * check if the array is full, if it is, makes a new array double the size of the original array
		 */
		if(count == list.length - 1){
			Variable [] tempList = new Variable [list.length*2];
			for(int i = 0; i < list.length; i++){
				tempList[i] = list[i];
			}
			list = tempList;
		}
		list[count] = temp;
		count++;
	}
	
	/**
	 * This method changes the value of an already existing variable
	 * @param varname the name of the existing variable
	 * @param varvalue the new value you are assigning the variable
	 */
	public void putValue(String varname, String varvalue){
		int index = find(varname);
		list[index].setValue(varvalue);
	}
	
	/**
	 * 
	 * @param varname is the name of the variable you are looking for
	 * @return the index of the variable if it exists in the list, else returns -1, meaning it was not found in the list
	 */
	public int find(String varname){
		for(int i = 0; i < count; i++){
			if(varname.equals(list[i].getName())){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This methods returns the number of variables in the list
	 * @return the number of variables in the list
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * This method returns the value of the variable at the given index of the list
	 * @param index is which variable the user wants the value from
	 * @return the value of the variable at the given index of the list
	 */
	public String getValue(int index){
		String temp = list[index].getValue();
		return temp;
	}
}