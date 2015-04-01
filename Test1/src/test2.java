
public class test2 {
	public static void main (String [] args){
		int test = 1;
		System.out.println(Foo(test));
	}


	public static int Foo (int n){
		int x = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				x += 1;
			}
		}
		return x;
	}
}