/**
 * 
 * This class represents Ingredients.
 * @author ctam68
 *
 */
public class Ingredient {
	/**
	 * name and calorie count variables
	 */
	private String name;
	private double calorieCount;
	
	/**
	 * blank default constructor
	 */
	public Ingredient(){}
	
	/**
	 * constructor with two variables
	 * @param name is the name of the ingredient
	 * @param calories is how many calories there are in 100 grams of the ingredient
	 */
	public Ingredient(String name, double calories){
		this.name = name;
		calorieCount = calories;
	}
	
	/**
	 * @return the name of the ingredient
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return the calorie count of the ingredient
	 */
	public double getCalorieCount(){
		return calorieCount;
	}
}
