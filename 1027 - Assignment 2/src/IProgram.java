/**
 * The main class that runs the I programs
 * @author ctam68
 * @author Christian Tam
 * @author 250679865
 */
public class IProgram {
	/**
	 * code contains all the code of the program
	 * variables contains all the variables that will be initialized in the program
	 */
	private LineList code;
	private VariableList variables;
	
	/**
	 * constructor that takes the filename of the input file
	 * @param filename the filename of the input file
	 */
	public IProgram(String filename){
		code = new LineList(filename);
		variables = new VariableList();
	}
	
	/**
	 * The main method that the user calls to run the specified I program
	 */
	public void run(){
		String current;
		String first;
		
		while(code.lastLine() == false){
			current = code.nextLine();
			first = current.substring(0,1);
			System.out.println("Line: " + current);
			if(first.equals("e")){
				break;
			}
			else if(first.equals("v")){
				addVariables(current.substring(2));
			}
			else if(first.equals("p")){
				print(current.substring(2));
			}
			else if(first.equals("#")){
				//donothinglol
			}
			else{
				//pass to initializing method
				initialize(current);
			}
		}
		
	}
	
	/**
	 * This method adds variables to the variable list
	 * It is normally called when the user has a line of code that start with "v"
	 * @param input the names of all the variables that will be initialized to "?"
	 */
	public void addVariables(String input){
		for(int i = 0; i < input.length(); i = i+2){
			if(variables.find(input.substring(i, i+1)) == -1){
				variables.add(input.substring(i, i+1), "?");
			}
			else{
				System.out.println("Error: Attempt to redeclare a variable.");
			}
		}
	}
	
	/**
	 * This is the print method, it handles lines of code that start with "p"
	 * @param input The line of code with "p" at the start minus the initial two characters 
	 */
	public void print(String input){
		boolean brackets = false;
		String current;
		boolean error = false;
		
		for(int i = 0; i < input.length(); i++){
			current = input.substring(i, i+1);
			
			//check if it is reading stuff in brackets
			if(current.equals("\"")){
				if(brackets == false){
					brackets = true;
				}
				else{
					brackets = false;
				}
			}
			//check if inside brackets
			else if(brackets == true){
				System.out.print(current);
			}
			//not in brackets
			else if(brackets == false && !current.equals(" ")){
				int index = variables.find(current);
				//if the variable is found within the list
				if(index != -1){
					System.out.print(variables.getValue(index) + " ");
				}
				//if the variable is not found within the list
				else{
					char temp = current.charAt(0);
					//if the variable is an uninitialized digit
					if(Character.isDigit(temp) == true){
						System.out.print(current + " ");
					}
					//if the variable is a uninitialized letter
					else if(Character.isLowerCase(temp) == true){
						System.out.print("?");
						variables.add(current, "?");
						error = true;
					}
				}
			}
		}
		
		System.out.println();
		if(error == true){
			System.out.println("Error: Undefined variable(s).");
		}
	}
	
	/**
	 * This method is called when a line of code does not start with "e", "#", "p", or "v"
	 * It handles the initialization of variables 
	 * @param input The line of code, including the first two characters
	 */
	public void initialize(String input){
		String var = input.substring(0,1);
		int index = variables.find(var);
		
		String postfix = evaluatePostfix(input.substring(2));
		
		//check if the variable already exists
		if(index == -1){
			System.out.println("Error: Variable " + "\"" + var + "\"" +" not declared.");
			variables.add(var, postfix);
		}
		else{
			variables.putValue(var, postfix);
		}
		
	}
	
	/**
	 * This method evaluates postfix expressions
	 * @param input the postfix expression
	 * @return the result of the postfix expression
	 */
	public String evaluatePostfix(String input){
		LinkedStack <String> stack = new LinkedStack <String>();
		String current;
		for(int i = 0; i < input.length(); i++){
			current = input.substring(i,i+1);
			
			//check for operator
			if(current.equals("+") || current.equals("-") || current.equals("/") || current.equals("*")){
				String operand1, operand2;
				operand2 = stack.pop();
				operand1 = stack.pop();
				
				//check for null values, indicating the stack is empty
				if(operand1 == (null) || operand2 == (null)){
					System.out.println("Error: stack is empty");
					return "?";
				}
				
				//check for NaN (?) values
				if(operand1.equals("?") || operand2.equals("?")){
					return "?";
				}
				else{
					//addition stuff
					if(current.equals("+")){
						int result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
						result = result % 10;
						String sresult = "" + result;
						stack.push(sresult);
					}
					//subtraction stuff
					else if(current.equals("-")){
						int result = Integer.parseInt(operand1) - Integer.parseInt(operand2);
						if(result < 0){
							System.out.println("Error: negative number");
							result = 0;
						}
						else{
							result = result % 10;
						}
						String sresult = "" + result;
						stack.push(sresult);
					}
					//division stuff
					else if(current.equals("/")){
						int result;
						if(Integer.parseInt(operand2) == 0){
							System.out.println("Error: Division by zero.");
							return "?";
						}
						else{
							result = Integer.parseInt(operand1) / Integer.parseInt(operand2);
						}
						result = result % 10;
						String sresult = "" + result;
						stack.push(sresult);
					}
					//multiplication stuff
					else if(current.equals("*")){
						int result = Integer.parseInt(operand1) * Integer.parseInt(operand2);
						result = result % 10;
						String sresult = "" + result;
						stack.push(sresult);
					}
				}
			}
			
			//operand stuff
			else{
				//check if the operand is a letter
				if(Character.isLowerCase(current.charAt(0)) == true){
					int index = variables.find(current);
					//check if the letter has been initialized
					if(index == -1){
						System.out.println("Error: uninitialized variable");
						return "?";
					}
					else{
						stack.push(variables.getValue(index));
					}
				}
				//check if the operand is a single character digit
				else if(Character.isDigit(current.charAt(0)) == true){
					int index = variables.find(current);
					//check if the digit has been initialized
					if(index == -1){
						stack.push(current);
					}
					else{
						stack.push(variables.getValue(index));
					}
				}
				else if(current.equals(" ")){
					//youshouldbeashamedofyourselvesforputtingspacesinthecode
				}
				else{
					System.out.println("Error: not a digit or single-letter variable.");
					return "?";
				}
			}
		}
		
		//check if there is more than one item? in the stack
		int count = stack.size();
		if(count != 1){
			System.out.println("Error: more than one item in stack.");
			return "?";
		}
		else{
			return stack.pop();
		}
	}
}
