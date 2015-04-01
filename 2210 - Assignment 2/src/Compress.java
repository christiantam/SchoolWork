import java.io.*;

/**
 * This class compresses an input file.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */
public class Compress {
	public static void main (String [] args) throws IOException{
		
		//variables
		int numcodes = 0;
		int currentbyte = -1;
		String currentstring = "";
		
		//input and output variables
		String inputFile = args[0];
		String outputFile = inputFile + ".zzz";
		MyOutput OutputHelp = new MyOutput();
		
		//my dictionary :D
		Dictionary MyDictionary = new Dictionary(4096);
		
		//insert the 256 ASCII values into the dictionary
		for(int i = 0 ; i < 256; i++){
			LinkedDictEntry ASCII = new LinkedDictEntry(Character.toString((char)i), i);
			try {
				MyDictionary.insert(ASCII);
				numcodes++;
			} catch (DictionaryException e) {}
		}
		
		//setup input and output helpers
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {}
		
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(outputFile));
		} catch (FileNotFoundException e) {}
		
		//read first byte
		try {
			currentbyte = in.read();
			currentstring = Character.toString((char)currentbyte);
		} catch (IOException e) {}
		
		while(currentbyte != -1){
			//check if the current string is in the dictionary
			//if it is, read another byte and add it to the current string until the longest sequence is already stored in the dictionary
			DictEntry search = MyDictionary.find(currentstring);
			searchbreak:
			
			while(search != null){
				currentbyte = in.read();
				
				//check for end of file
				if(currentbyte == -1){
					currentstring += " ";
					break searchbreak;
				}
				currentstring += Character.toString((char)currentbyte);
				search = MyDictionary.find(currentstring);
			}
			
			//the string that includes the last character, is not in the dictionary
			//therefore we have to cut off the last character to search for the corresponding code in the dictionary
			currentstring = currentstring.substring(0,currentstring.length()-1);
			DictEntry temp = MyDictionary.find(currentstring);
			
			//print the longest string, in code form, to the output file
			OutputHelp.output(temp.getCode(), out);
			
			//if it's the end of the file, we don't need to add anything to the dictionary
			//if the dictionary already has 4096 elements, we cannot add anymore
			if(currentbyte != -1){
				if(MyDictionary.numElements() < 4096){
					//append the character we cut off earlier so we can add the new string to the dictionary
					currentstring += Character.toString((char)currentbyte);
					try {
						MyDictionary.insert(new DictEntry (currentstring, numcodes));
						numcodes++;
					} catch (DictionaryException e) {}
				}
			}
			//reset the value of currentstring to the next byte
			if(currentbyte != -1){
				currentstring = Character.toString((char)currentbyte);
			}
		}
		
		//close readers and flush
		in.close();
		OutputHelp.flush(out);
		out.close();
	}
}
