
public class Question5 {
	public static void main(String [] args){
		int findPrimes [] = new int [8];
		long primetime [] = new long [8];
		int num = 1;
		for(int i = 0; i < findPrimes.length; i++){
			num *= 10;
			findPrimes[i] = num;
		}
		for(int k = 0; k < findPrimes.length; k++){
			long start = System.currentTimeMillis();
			boolean [] list = makeList(findPrimes[k]);
			
			for(int i = 2; i < list.length; i++){
				cancelMultiples(list, i);
			}
			long stop = System.currentTimeMillis() - start;
			
			primetime[k] = stop;
			System.out.println("Time to find primes under "+ findPrimes[k] + ": " + primetime[k]);
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
}

