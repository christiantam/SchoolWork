//Question 4 - ezpz yo
public class GeneComplement extends ProteinDNA{
	protected DNASequence reversal;
	protected String AAreversal;
	
	//constructor, just the same as the ProteinDNA constructor basically
	public GeneComplement(DNASequence dna, int startAt){
		super(dna, startAt);
		AAreversal = "";
	}
	
	//reverses the gene
	public String reverseGene(){
		//this is the complement of the bases
		
		reversal = complement();
		
		//convert the complemented bases to a gene
		String bases = "";
		String acid = "";
		for(int i = 0; i < reversal.baseString().length(); i += 3){
			 bases = reversal.baseString().substring(i, i+3);
			 acid = checkAcid(bases);
			 
			 if(acid.equals("*")){
				 break;
			 }
			 else{
				 AAreversal += acid;
			 }
		}
		//returns the reversed gene
		return AAreversal;
	}
}
