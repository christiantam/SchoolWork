//tests DNASequence
public class testing {
	public static void main(String [] args){
		//input
		DNASequence d = new DNASequence("cgta123234cgta2342cgta| |");
		
		//should return "t"
		char testbase = d.baseAt(2);
		System.out.println(testbase);
		
		//should return 12
		int baseL = d.baseLength();
		System.out.println(baseL);
		
		//test for complement method and baseString method
		DNASequence rev = d.complement();
		String input = rev.baseString();
		
		//should return "gcatgcatgcat"
		System.out.println(input);
	}
}

/*Output:
 * t
 * 12
 * gcatgcatgcat
 */
