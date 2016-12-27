/*
 * To check whether the given two strings are anagrams or not
 * Easy way - Sort and compare 
 */

package ch1ArraysAndStrings;
import java.util.Arrays;

public class Anagrams 
{
	public boolean areAnagrams(String str1, String str2)
	{
		/*
		 * Convert the given strings to lowerCase first 
		 * Convert the lowerCase strings to character arrays
		 */
		char[] c1 = str1.toLowerCase().toCharArray();
		char[] c2 = str2.toLowerCase().toCharArray();
			
		//Sort the two character arrays using the class Arrays
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		//Convert the character arrays back to Strings
		String s1 = new String(c1);
		String s2 = new String(c2);
		
		//Check whether the two strings match up or not
		return s1.equals(s2);
	}
	
	public static void main(String[] args) 
	{
		Anagrams angs = new Anagrams();
		
		System.out.println("Are the given two strings anagrams? \n"+(angs.areAnagrams("Parks", "spark")? "Yes":"No"));
	}
}