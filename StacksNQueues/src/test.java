
public class test {
	public static void main (String [] args){
		
		ArrayUnorderedList<Integer> testing = new ArrayUnorderedList <Integer> ();
		testing.addToRear(1);
		testing.addToRear(2);
		testing.addToRear(3);
		testing.addToRear(4);
		testing.addToRear(5);
		System.out.println("found: " + testing.find(5));
	}
}
