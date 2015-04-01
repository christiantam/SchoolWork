//Question 1
public class DNASequence {
	protected String baseSequence = "";
	protected int lengthbase = 0;
	
	//empty default constructor
	public DNASequence(){}
	
	//constructor that takes one string input
	public DNASequence(String input){
		baseSequence = sortChars(input);
		lengthbase = baseSequence.length();
	}
	
	//takes a string parameter and gets rid of non "cgat" characters
	public String sortChars(String input){
		String value = "";
		String output = "";
		
		//ignores all characters that is not "c", "g", "a", "t", or "n"
		for(int i = 0; i < input.length(); i++){
			value = input.substring(i, i+1);
			if(value.equals("c") || value.equals("g") || value.equals("a") || value.equals("t") || value.equals("n")){
				output += value;
			}
		}
		return output;
	}
	
	//returns the complement DNA of the base sequence
	public DNASequence complement(){
		String reversed = "";
		String input = "";
		
		//checks each for each base and adds the complement to the reversed string
		for(int i = 0; i < lengthbase; i++){
			input = baseSequence.substring(i, i+1);
			if(input.equals("c")){
				reversed += "g";
			}
			else if(input.equals("g")){
				reversed += "c";
			}
			else if(input.equals("t")){
				reversed += "a";
			}
			else if(input.equals("a")){
				reversed += "t";
			}
			else if(input.equals("n")){
				reversed += "n";
			}
		}
		
		//makes new DNASequence with the reversed bases and then returns it
		DNASequence comp = new DNASequence(reversed);
		return comp;
	}
	
	//returns the the base at position 'i' in the baseSequence
	//note that the positions go from [0, lengthbase-1]
	public char baseAt(int i){
		return(baseSequence.charAt(i));
	}
	
	//returns the length of the base sequence
	public int baseLength(){
		return lengthbase;
	}
	
	//returns the base sequence
	public String baseString(){
		return baseSequence;
	}
}
