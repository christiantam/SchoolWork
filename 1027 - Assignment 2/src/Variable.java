/**
 * Class for a single variable
 * @author ctam68
 * @author Christian Tam
 * @author 250679865
 */
public class Variable {
	/**
	 * name is the name of the variable
	 * value is the value of the variable,
	 * 	value is a string because variables might have the value ?
	 */
	private String name;
	private String value;
	
	/**
	 * Constructor with two parameters, will initialize a variable with the given name and value
	 * @param varname the name of the given variable
	 * @param varvalue the value of the given variable
	 */
	public Variable(String varname, String varvalue){
		name = varname;
		value = varvalue;
	}
	
	/**
	 * This methods takes a parameter input and sets the value of the variable to that parameter
	 * @param input the value of the parameter
	 */
	public void setValue(String input){
		value = input;
	}
	
	/**
	 * This methods returns the name of the variable
	 * @return name of the variable
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This methods returns the value of the variable as a String
	 * @return the value of the variable
	 */
	public String getValue(){
		return value;
	}
}
