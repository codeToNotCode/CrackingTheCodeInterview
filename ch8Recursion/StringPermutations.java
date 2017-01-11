/*
 * To print all permutations of a given string
 * Algorithm is to take the first character and merge it with all possible permutations of the remaining characters
 * Time complexity O(n!)
 */

package ch8Recursion;

import java.util.ArrayList;

public class StringPermutations
{
	
	/*
	 * A function to take the input and store the output in an ArrayList of Strings
	 */
	public ArrayList<String> permutations(String str)
	{
		ArrayList<String> result = new ArrayList<String>();
		permutations("",str,result);
		return result;
	}

	
	/*
	 * Function that finds all permutations of the given string using recursion
	 */
	public void permutations(String prefix, String suffix, ArrayList<String> result)
	{
		if( suffix.length() == 0 )
			result.add(prefix);
		
		else
		{
			for( int i = 0 ; i < suffix.length() ; i++ )
			{
				permutations(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1,suffix.length()), result);
			}
		}
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		StringPermutations sp = new StringPermutations();
		ArrayList<String> result = sp.permutations("abc");
		for(int i = 0 ; i < result.size() ; i++)
			System.out.println(result.get(i));
	}
}
