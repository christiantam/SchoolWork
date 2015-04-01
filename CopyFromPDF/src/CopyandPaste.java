import java.io.*;

public class CopyandPaste {
	public static void main (String [] args){
        String output = "";
		
		try
        {
            BufferedReader in = new BufferedReader(new FileReader(new File("copy.txt")));
            String temp = in.readLine();
            
            while(temp != null){
	            output += temp + " ";	
            	temp = in.readLine();            
            }
            in.close();
        }
        catch(IOException e)
        {
            System.out.println("File I/O error!");
        }
		System.out.println(output);
	}
}
