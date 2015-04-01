//USE THIS CLASS!!!
public class TestingB {
	public static void main (String [] args){
		
		//I assumed the input was from a .txt file, so please change "input.txt" to your test case file name
		ProblemB test = new ProblemB("input.txt");
		
		
		
		
		
		
		
		
		
		//splits up each case
		SingleCase [] seperate = new SingleCase [test.cases.length];
		for(int i = 0; i < test.cases.length; i++){
			seperate[i] = new SingleCase(test.cases[i]);
		}
		
		//prints out the case number, coordinates of the meeting location, and the total distance all of the members have to walk
		for(int i = 0; i < test.cases.length; i++){
			System.out.println("Case " + (i+1) + ": " + "(" + seperate[i].meetX + "," + seperate[i].meetY + ") " + seperate[i].shortDistance);
		}
	}
}
