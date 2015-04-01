//Question 3
public class ProteinDNA extends DNASequence{
	//AA is the amino acids
	//numAA is how many there are of them
	//protected so that future base classes can use them
	protected String AA = "";
	protected int numAA = 0;
	
	//empty default constructor
	public ProteinDNA(){}
	
	//constructor
	//takes a DNASequence and translates the bases into their respective amino acids
	public ProteinDNA(DNASequence dna, int startAt){
		String data = dna.baseString();
		String bases = "";
		String acid = "";
		String protein = "";
		String baseseq = "";
		int numberofAA = 0;
		
		//changes the bases to amino acids
		for(int i = startAt; i < dna.baseString().length(); i += 3){
			 bases = data.substring(i, i+3);
			 acid = checkAcid(bases);
			 
			 if(acid.equals("*")){
				 break;
			 }
			 else{
				 protein += acid;
				 baseseq += bases;
				 numberofAA++;
			 }
		}
		//assigns all the values 
		//don't ask why I made new stuff :D
		numAA = numberofAA;
		lengthbase = numAA * 3;
		AA = "M" + protein.substring(1);
		baseSequence = baseseq;
	}
	
	//checks which amino acid the DNA sequence is and returns the abbreviated character
	public String checkAcid(String input){
		//Alanine - A
		if(input.equals("gct") || input.equals("gcc") || input.equals("gca") || input.equals("gcg")){
			return "A";
		}
		//Arginine - R
		else if(input.equals("cgt") || input.equals("cgc") || input.equals("cga") || input.equals("cgg")){
			return "R";
		}
		//Asparagine - N
		else if(input.equals("aat") || input.equals("aac")){
			return "N";
		}
		//Aspartic acid - D
		else if(input.equals("gat") || input.equals("gac")){
			return "D";
		}
		//Cysteine - C
		else if(input.equals("tgt") || input.equals("tgc")){
			return "C";
		}
		//Glutamic acid - E
		else if(input.equals("gaa") || input.equals("gag")){
			return "E";
		}
		//Glutamine - Q
		else if(input.equals("caa") || input.equals("cag")){
			return "Q";
		}
		//Glycine - G
		else if(input.equals("ggt") || input.equals("ggc") || input.equals("gga") || input.equals("ggg")){
			return "G";
		}
		//Glutamine - Q
		else if(input.equals("caa") || input.equals("cag")){
			return "Q";
		}
		//Histidine - H
		else if(input.equals("cat") || input.equals("cac")){
			return "H";
		}
		//Isoleucine - I
		else if(input.equals("att") || input.equals("atc")){
			return "I";
		}
		//Leucine - L
		else if(input.equals("ctt") || input.equals("ctc") || input.equals("cta") || input.equals("ctg") || input.equals("tta") || input.equals("ttg")){
			return "L";
		}
		//Lysine - K
		else if(input.equals("aaa") || input.equals("aag")){
			return "K";
		}
		//Methionine - M
		else if(input.equals("ata") || input.equals("atg")){
			return "M";
		}
		//Phenylalanine - F
		else if(input.equals("ttt") || input.equals("ttc")){
			return "F";
		}
		//Proline - P
		else if(input.equals("cct") || input.equals("ccc") || input.equals("cca") || input.equals("ccg")){
			return "P";
		}
		//Serine - S
		else if(input.equals("tct") || input.equals("tcc") || input.equals("tca") || input.equals("tcg") || input.equals("agt") || input.equals("agc")){
			return "S";
		}
		//Threonine - T
		else if(input.equals("act") || input.equals("acc") || input.equals("aca") || input.equals("acg")){
			return "T";
		}
		//Tryptophan - W
		else if(input.equals("tga") || input.equals("tgg")){
			return "W";
		}
		//Tryptophan - Y
		else if(input.equals("tat") || input.equals("tac")){
			return "Y";
		}
		//Valine - V
		else if(input.equals("gtt") || input.equals("gtc") || input.equals("gta") || input.equals("gtg")){
			return "V";
		}
		//Stop codons - *
		else if(input.equals("aga") || input.equals("agg") || input.equals("taa") || input.equals("tag")){
			return "*";
		}
		return "not found";
	}
	 
	// Number of amino acids. It "counts" by groups of three due to the constructor
	public int acidLength(){
		return numAA;
	}
	
	//returns the i-th amino acid. It "counts" by groups of three due to the constructor
	public char acidAt(int i){
		return AA.charAt(i-1);
	}
	
	//returns the code of amino acids
	public String acidString(){
		return AA;
	}
}
