import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

//testing ProteinDNA
public class testing2 {
	public static void main(String [] args) throws IOException{
		
		//input :D
		DNASequence zerg = new DNASequence ("ccgcttcgccttagcatgatttatcctacacaaatagcccttctaaacgctaatcca");
		ProteinDNA protoss = new ProteinDNA(zerg, 0);
		System.out.println(protoss.acidString());
		System.out.println(protoss.acidAt(3));
		System.out.println(protoss.acidLength());
		
		//another input test case
		BufferedReader reader = new BufferedReader(new FileReader("reMito.txt"));
	    String line = null;
	    String output = "";

        while ((line = reader.readLine()) != null)
        	output += line;
        
        reader.close();
        
        DNASequence ling = new DNASequence (output);
		ProteinDNA stalker = new ProteinDNA(ling, 4469);
		System.out.println(stalker.acidString());
	}
}

/*Output
 * MLRLSMIYPTQMALLNANP
 * R
 * 19
 * MNPLAQPVIYSTIFAGTLITALSSHWFFTWVGLEMNMLAFIPVLTKKMNPRSTEAAIKYFLTQATASMILLMAILFNNMLSGQWTMTNTTNQYSSLMIMMAMAMKLGMAPFHFWVPEVTQGTPLTSGLLLLTWQKLAPISIMYQISPSLNVSLLLTLSILSIMAGSWGGLNQTQLRKILAYSSITHMGWMMAVLPYNPNMTILNLTIYIILTTTAFLLLNLNSSTTTLLLSRTWNKLTWLTPLIPSTLLSLGGLPPLTGFLPKWAIIEEFTKNNSLIIPTIMATITLLNLYFYLRLIYSTSITLLPMSNNVKMKWQFEHTKPTPFLPTLIALTTLLLPISPFMLMIL
 */
