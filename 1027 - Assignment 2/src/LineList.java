/**
 * This class used for working with all the lines in a given I program
 * @author ctam68
 * @author Christian Tam
 * @author 250679865
 */
public class LineList {
	/**
	 * list is the list of string variables that hold the code
	 * current is the current line of code that is going to be returned next
	 * count is the number of lines in the program
	 */
	private String [] list;
	private int current;
	private int count;
	
	/**
	 * This constructor takes a file name and creates an array of String variables with 1 line of code in each slot of the array
	 * @param fileinput the filename of the input file
	 */
	public LineList(String fileinput){
		list = new String [32];
		current = 0;
		count = 0;
		
		InStringFile reader = new InStringFile(fileinput);
		for(int i = 0; reader.endOfFile() == false; i++){
			list[i] = reader.read();
			count++;
			
			if(count == list.length - 1){
				String [] tempList = new String [list.length*2];
				for(int j = 0; j < list.length; j++){
					tempList[j] = list[j];
				}
				list = tempList;
			}
		}
	}
	
	/**
	 * This method returns the next line in the program that hasn't been called yet
	 * @return null if the last line read was the last line in the program
	 * @return the next line in the program if not
	 */
	public String nextLine(){
		if(lastLine() == true){
			return null;
		}
		String temp = list[current];
		current++;
		return temp;
	}
	
	/**
	 * This methods returns a boolean telling the user whether the the last line has been read or not
	 * @return a boolean telling the user whether the the last line has been read or not
	 */
	public boolean lastLine(){
		if(current == count){
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns the amount of lines in the program
	 * @return amount of lines in the program
	 */
	public int getLineCount(){
		return count;
	}
}
