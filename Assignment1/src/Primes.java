
public class Primes {
	public static void main(String [] args){
		boolean [] list = makeList(1000);
		
		for(int i = 2; i < list.length; i++){
			cancelMultiples(list, i);
		}
		
		System.out.println("Prime numbers:");
		printList(list);
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
		for(int i = 2; i < list.length; i++){
			if(list[i]){
				System.out.print(i + " ");
			}
		}
	}
}
