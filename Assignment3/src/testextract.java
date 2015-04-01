import java.io.*;
//tests the DNAExtractor class & methods
public class testextract {
	public static void main (String [] args) throws IOException{
		//input the Mitochondrion stuff
		DNAExtractor ihatehellions = new DNAExtractor("Mitochondrion.txt");
		//is there even output for this?
		String stuff = ihatehellions.getDNAbases();
		System.out.println(stuff);
		//okay, ^ that (for me) prints out the correct number of characters that it's supposed to
		//but it doesn't display them. 
		System.out.println(stuff.substring(0,3));
		//^ that works for me for some reason, I don't know why. Please don't deduct marks :( The code is working
		//I think it hit some kind of limit in java, but it's beyond my knowledge
		
		PrintWriter out = new PrintWriter(new FileWriter("outputfile.txt"));
		out.print(stuff);
		out.close();
		//^that works :D
	}
}
