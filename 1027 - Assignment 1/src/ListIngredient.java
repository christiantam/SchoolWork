import java.util.StringTokenizer;

/**
 * Class representing a list of ingredients
 * @author ctam68
 */
public class ListIngredient extends Ingredient{
	/**
	 * array of ingredients
	 */
	Ingredient [] IngredientList;
	
	/**
	 * default size of the array above
	 */
	int DEFAULT_MAX_INGREDIENTS = 100;
	
	/**
	 * number of current ingredients in the list, 
	 * the position of the most "recent" ingredient in the array
	 */
	int listPosition = 0;
	
	/**
	 * default constructor
	 */
	public ListIngredient(){
		IngredientList = new Ingredient [DEFAULT_MAX_INGREDIENTS];
	}
	
	/**
	 * required constructor because the parent class has a constructor with two variables
	 * using this constructor is not recommended
	 * 
	 * However if you do use it, and you give it a string and double variable, it assumes that is the first
	 * ingredient in the list
	 */
	public ListIngredient(String name, double calories){
		add(new Ingredient(name, calories));
		IngredientList = new Ingredient [DEFAULT_MAX_INGREDIENTS];
	}
	
	/**
	 * This method adds an ingredient to the list
	 * @param input is the ingredient being added to the list
	 */
	public void add(Ingredient input){
		//checks if the array is full and if a new, larger array needs to be composed
		 
		if(listPosition == IngredientList.length - 1){
			Ingredient [] tempList = new Ingredient[IngredientList.length*2];
			for(int i = 0; i < IngredientList.length; i++){
				tempList[i] = IngredientList[i];
			}
			IngredientList = tempList;
		}
		
		//adds the ingredient to the list
		IngredientList[listPosition] = input;
		listPosition++;
	}
	
	/**
	 * This method is used to see if an ingredient is in the list
	 * @param name is the name of the ingredient you are looking for in the list
	 * @return the calorie count of said ingredient, or throws an exception if it does not find the ingredient
	 */
	public double find(String name){
		for(int k = 0; k < listPosition; k++){
			if(IngredientList[k].getName().equals(name)){
				return IngredientList[k].getCalorieCount();
			}
		}
		throw new Error("Ingredient not found");
	}
	
	/**
	 * This method takes a recipe and returns the number of calories in the recipe
	 * @param fileName is the name of the recipe file
	 * @return is the number of calories in the recipe
	 */
	public double count(String fileName) throws Exception{
		//variable for the total number of calories in the recipe
		double calorieTotal = 0;
		
		//this is the list with all the ingredients
		String numCalories = "table.dat";
		ListIngredient total = new ListIngredient();
		total.readList(numCalories);
		
		// create object that controls file reading and opens the file
		InStringFile reader = new InStringFile(fileName);
		System.out.println("\nReading from file " + fileName + "\n");
	    // read data from file one line at a time
				  
		String line;
		StringTokenizer tokenizer;
		String ingredientName;
		double calorieCount;

		do
		{
		    line = (reader.read());
		     
		    // get ingredient and quantity information
		    // Note: it is assumed that each line of the disk file has
		            
		    tokenizer = new StringTokenizer(line);
		    ingredientName = tokenizer.nextToken();
		    calorieCount = Double.parseDouble(tokenizer.nextToken())/100;
				  
		    //searches the ingredient list for the current ingredient in the recipe and adds the calorie count to the total
		    for(int k = 0; k < total.listPosition; k++){
		    	if(total.IngredientList[k].getName().equals(ingredientName)){
		    		calorieTotal += calorieCount * total.IngredientList[k].getCalorieCount();
		    		k = total.listPosition;
		    	}
		    }
		}while (!reader.endOfFile()); 
				   
		reader.close(); 
		
		return calorieTotal;
	}
	
	/**
	 * readList method adds into the university courses list from a file
	 * @param fileName	filename of file that contains course information
	 */
	public void readList(String fileName) throws Exception {		  
			
	  // create object that controls file reading and opens the file
	  InStringFile reader = new InStringFile(fileName);
	  System.out.println("\nReading from file " + fileName + "\n");

	  // read data from file one line at a time
			  
	  String line;
	  StringTokenizer tokenizer;
	  String ingredientName;
	  double calorieCount;

	  do
	    {
	      line = (reader.read());
	      
	      // get ingredient and quantity information
	      // Note: it is assumed that each line of the disk file has
	            
	      tokenizer = new StringTokenizer(line);
	      ingredientName = tokenizer.nextToken();
	      calorieCount = Double.parseDouble(tokenizer.nextToken());
			  
	      // insert your code here
	      add(new Ingredient(ingredientName, calorieCount));
	    }while (!reader.endOfFile()); 
			   
	  reader.close(); 
	}
}
