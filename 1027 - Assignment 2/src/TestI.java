/**
 * This is the program used to test the other programs
 * First you have to make an object of type IProgram and use the constructor with a single String parameter containing
 * 	the name of the input file
 * Then, you have to use the run() method of that IProgram object to run the I program
 * 
 * @author ctam68
 * @author Christian Tam
 * @author 250679865
 *
 */
public class TestI {
	public static void main (String [] args){
		IProgram test1 = new IProgram("pgm1.txt");
		test1.run();

		IProgram test2 = new IProgram("pgm2.txt");
		test2.run();
	}
}
