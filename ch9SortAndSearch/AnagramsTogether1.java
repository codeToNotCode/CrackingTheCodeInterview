/*
 * To sort a given array of strings such that all the anagrams stay together
 * Using the comparator interface
 */

package ch9SortAndSearch;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramsTogether1 implements Comparator<String>
{
	
	/*
	 * Convert given string into a character array
	 * Sort the array using the sort function of Arrays class
	 * Convert the sorted character array back to a new string
	 */
	public String sortChars(String str)
	{
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		
		return new String(ch);
	}
	
	
	/*
	 * Method of the Comparator interface
	 * Since we are implementing the comparator interface, we have to define the methods declared in the Comparator interface
	 */
	public int compare(String s1, String s2)
	{
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	// Driver function
	public static void main(String[] args)
	{
		String A[] =
		{ "apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee","naaban", "nnbaaa" };

		System.out.println(Arrays.toString(A));
		Arrays.sort(A, new AnagramsTogether1());
		System.out.println(Arrays.toString(A));
	}

	
}
