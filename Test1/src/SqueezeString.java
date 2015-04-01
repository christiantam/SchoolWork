import java.io.*;

public class SqueezeString
{
    static int i;
    
    static void squeeze(String s)
    {
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch != ' ')
            System.out.print(ch);
        }
    }
    
    
    public static void main (String args[]) throws IOException
    {
    	BufferedReader in = new BufferedReader(new FileReader("manga.txt"));
        
    	while(in.ready())
    		SqueezeString.squeeze(in.readLine());
    	in.close();
    }
}