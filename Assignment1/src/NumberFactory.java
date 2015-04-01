
public class NumberFactory {
	
	public static void main (String [] args){
		System.out.println(sumOfSquares(1));
		System.out.println(sumOfSquares(2));
		System.out.println(sumOfSquares(100));
		System.out.println(sumOfSquares(0));
		System.out.println(sumOfSquares(1000));
		System.out.println(sumOfSquares(-10));
	}
	public static int sumOfSquares(int n){
		if(n < 0){
			n = n*-1;
		}
		
		int [] entries = new int [n];
		for(int i = 0; i < n; i++){
			entries[i] = 0;
		}
		int sum = 0;
		
		for(int i = 0; i < n; i++){
			entries[i] += (i+1)*(i+1);
		}
		
		for(int i = 0; i < n; i++){
			sum += entries[i];
		}
		return sum;
	}
}
