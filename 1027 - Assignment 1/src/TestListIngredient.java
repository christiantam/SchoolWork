/**
 * 
 * @author ctam68
 * This class tests the ListIngredient class
 */
public class TestListIngredient{
	public static void main(String[] args) throws Exception{
		
		String database = "table.dat";
		String recipe = "pasta.txt";
		
		//Takes the table with all the ingredients and lists their names and calories/100g
		ListIngredient foodList = new ListIngredient();
		foodList.readList(database);

		for(int i = 0; i < foodList.listPosition; i++){
			System.out.println(foodList.IngredientList[i].getName());
			System.out.println(foodList.IngredientList[i].getCalorieCount());
		}
		
		//tests the count method
		System.out.println("Calorie count: " + foodList.count(recipe));
	}
}