/*
 * To replace all blank spaces with %20 in the given string
 * If the input is "Hi There   "
 * Output shpuld be "Hi%20There" and not "Hi%20There%20%20%20%20"
 */

package ch1ArraysAndStrings;

public class ReplaceSpaces 
{
	public String replaceSpaces(String str)
	{
		//Declare the StringBuffer class object to use the append function
		StringBuffer s = new StringBuffer();
		
		//To remove extra blank spaces that are present in the end of the string
		int j = str.length() - 1;
		while( str.charAt(j) == ' ')
			j--;
		
		//To replace every blank space with %20
		for(int i = 0 ; i < j+1 ; i++ )
		{
			if( str.charAt(i) == ' ')
				s.append("%20");
			else
				s.append(str.charAt(i));
		}
		
		//Convert StringBuffer to a String and return
		return s.toString();
	}
	
	public static void main(String[] args) 
	{
		ReplaceSpaces rs = new ReplaceSpaces();
		String newS = rs.replaceSpaces("Pras and eep Singh  U bh i");
		
		System.out.println("String after replacement : \n"+newS);
	}
}
