import java.io.*;

//tests Question4
public class ComplementTest {
	public static void main(String [] args) throws IOException{
		//input
		BufferedReader reader = new BufferedReader(new FileReader("reMito.txt"));
	    String line = null;
	    String output = "";
	    
        while ((line = reader.readLine()) != null)
        	output += line;
        reader.close();
        
        DNASequence ling = new DNASequence (output);
		GeneComplement stalker = new GeneComplement(ling, 14673);
		//prints the original gene then the reversed gene
		System.out.println(stalker.AA);
		System.out.println(stalker.reverseGene());
	}
}

/*
 * Output
 * MSRTDYNHDQWYEKPSLYFNYKNTNDPNTQN
 * M
 */