/*
 * TO check whether the given two strings are anagrams or not
 * Count the number of time individual letter occurs in both the strings
 * If the difference of count of each letter is 0, then the strings are anagrams
 */

package ch1ArraysAndStrings;

public class AnagramsWithoutSort 
{
	public boolean areAnagrams(String s1, String s2)
	{
		//If both the strings are of different lengths, they cannot be anagrams
		if( s1.length() != s2.length())
			return false;
		
		//Convert each string to lowercase
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		/*
		 * 1 << 8 is another way of saying that the array size is 256 bytes
		 * This array stores all the 256 characters of the ASCII
		 * Letter[97] will corrospond to 'a' . equivalent to letters['a']
		 * In java, all the array elements are initialized to 0 upfront
		 */
		int[] letters = new int[1<<8];
	
		/*
		 * To traverse through all the characters present in the string s1
		 * For every character that is encountered, letters[c]++ will increment its initial value by 1
		 * For example: letters['a'] means value at letters[ASCII value of a] which is equal to saying value at letters[97]
		 * Initially letters[97] is 0 (default initialization)
		 * After letters['a']++ , we now increment its value by 1 . so letters['a'] now contains 1
		 */
		for( char c : s1.toCharArray())
			letters[c]++;
		
		/*
		 * To traverse through all the characters present in the string s1
		 * If the same characters are present in the second string: their values will be decremented by 1
		 */
		for( char c : s2.toCharArray())
			letters[c]--;
		
		//The letters array will contain all its elements as 0s if all the characters in both the strings are same
		for( int i : letters)
			if( i != 0 )
				return false;
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		Anagrams angs = new Anagrams();
		
		System.out.println("Are the given two strings anagrams? \n"+(angs.areAnagrams("TOugh", "Ought")? "Yes":"No"));
	}
}
