/*
 * To sort a given array of strings such that all the anagrams stay together
 * 
 * Algorithm:
 * 
 * Take each separate string
 * Convert each string into character array, sort it, convert it back to a string
 * Use this String as a KEY for the hashtable<String, LinkedList>
 * Check for anagrams and place all the anagrams together as a list corrosponding to their respective keys
 * Once done, convert the List of strings in the hashtable back to an array of Strings
 */

package ch9SortAndSearch;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class AnagramsTogether
{
	/*
	 * To generate unique keys to be used by the hashtable
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
	 * Function to sort the given array of strings keeping all the anagrams together
	 * Create a Hashtable with key as String and the values as a Linked List of Strings
	 * Push the strings of anagrams to their respective keys
	 * Convert the hashtable into a String array
	 */
	public void sort(String A[])
	{
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		
		for(String str: A)
		{
			String key = sortChars(str);
			
			if( !hash.containsKey(key))
				hash.put(key, new LinkedList<String>());
			
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(str);
		}
		
		int i = 0 ;
		for ( String key : hash.keySet())
		{
			LinkedList<String> list = hash.get(key);
			for( String str : list )
				A[i++] = str;
		}
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		AnagramsTogether at = new AnagramsTogether();
		String A[] = {"apple" ,"banana",  "carrot", "ele", "duck", "papel", "tarroc", "cudk","eel","lee","naaban", "nnbaaa"};
		System.out.println(Arrays.toString(A));
		at.sort(A);
		System.out.println(Arrays.toString(A));
	}
}
