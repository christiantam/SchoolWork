import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//I assumed the input was from a .txt file
//created a class with only one constructor which took the name of the input file as the parameter
class ProblemB {
	String [] cases;
	String filename = "";
	
	//initializes the string array of cases
	public ProblemB(String input){
		filename = input;
		cases = new String [numCases()];
		initCases();
	}
	
	//returns the number of cases in the file
	public int numCases(){
		int numberCases = 0;
		try {
            // This creates an object from which you can read input lines.
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while ((! reader.readLine().equals("0"))){
            	numberCases++;
            }
            
            reader.close();
        }
		//deals with any IO exceptions that may occur
        catch (IOException e) {
            System.out.println("Caught IO exception");
        }
		
		return numberCases;
	}
	
	//initializes all the cases
	//puts one case in one slot of the array
	public void initCases(){
		try {
            // This creates an object from which you can read input lines.
            BufferedReader reader = new BufferedReader(new FileReader(filename));
           
            for(int i = 0; i < cases.length; i++){
            	cases[i] = reader.readLine();
            }
            
            reader.close();
        }
		//deals with any IO exceptions that may occur
        catch (IOException e) {
            System.out.println("Caught IO exception");
        }
	}
}
