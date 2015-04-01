import java.io.*;

public class RecursionLab{
    
    public static void reversePrint (String inString){
       
		if (inString.length() > 0)		// if string is not empty
		{
		
			// your code goes here
			System.out.print(inString.substring(inString.length()-1));
			reversePrint(inString.substring(0,inString.length()-1));
		}
		
    }

	
    public static String reverseString(String input){
    	if(input.length() > 0)
    		return input.substring(input.length()-1) + reverseString(input.substring(0,input.length()-1));
    	else
    		return "";
    }
    
    public static boolean isPalindrome(String input){
    	String reverse = reverseString(input);
    	return(reverse.equals(input));
    }
    
    public static void main(String[] args){
        String inString = "abcde";

		// test reversePrint
		System.out.println(reverseString(inString));
		System.out.println(isPalindrome(inString));
		inString = "abababa";
		System.out.println(isPalindrome(inString));
    }
}