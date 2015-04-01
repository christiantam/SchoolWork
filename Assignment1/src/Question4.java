
public class Question4 {
	public static void main(String [] args){
		int findPrimes [] = new int [8];
		int num = 1;
		for(int i = 0; i < findPrimes.length; i++){
			num *= 10;
			findPrimes[i] = num;
		}
		for(int k = 0; k < findPrimes.length; k++){
			boolean [] list = makeList(findPrimes[k]);
			
			for(int i = 2; i < list.length; i++){
				cancelMultiples(list, i);
			}
			
			System.out.println("Number of prime numbers in the number: " + findPrimes[k]);
			printList(list);
		}
	}
	
	public static boolean[] makeList(int num){
		boolean [] list = new boolean [num];
		for(int i = 0; i < num; i++){
			list[i] = true;
		}
		return list;
	}
	
	public static void cancelMultiples(boolean [] list, int num){
		if(!list[num]){
			return;
		}
		else{
			for(int i = 2*num; i < list.length; i += num){
				list[i] = false;
			}
		}
	}
	
	public static void printList(boolean [] list){
		int num = 0;
		for(int i = 2; i < list.length; i++){
			if(list[i]){
				num++;
			}
		}
		System.out.println(num);
	}
}
