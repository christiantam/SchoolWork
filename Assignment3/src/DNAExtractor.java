//Question 2
import java.io.*;

public class DNAExtractor {
	private String DNAbases = "";
	private String filename = "";
	
	//constructor
	public DNAExtractor(String name){		
		filename = name;
		DNAbases = getDNA();
	}
	
	//returns a String of the bases in the filename
	public String getDNA(){
		String output = "";
		try {
            // This creates an object from which you can read input lines.
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = null;

            // readLine reads input lines (without the \n), catching any 
            // exceptions, and returns null if there is no more input.
            while ((line = reader.readLine()) != null)
            	output += line;
            
            reader.close();
        }
		//deals with any IO exceptions that may occur
        catch (IOException e) {
            System.out.println("Caught IO exception");
        }
		
		//gets rid of non "cgat" characters
		output = sortChars(output);
		return output;
	}
	
	//takes a string parameter and gets rid of non "cgat" characters
	public String sortChars(String input){
		String value = "";
		String output = "";
		
		//ignores all characters that is not "c", "g", "a", or "t"
		for(int i = 0; i < input.length(); i++){
			value = input.substring(i, i+1);
			if(value.equals("c") || value.equals("g") || value.equals("a") || value.equals("t") || value.equals("n")){
				output += value;
			}
		}
		//returns the sorted String
		return output;
	}
	
	//returns the DNAbases
	public String getDNAbases(){
		return DNAbases;
	}
}
