/*
 * To check whether the given string has all the unique characters or not
 * This method creates a new boolean array which stores true if the character is present in the string
 * We are considering only ASCII characters here : Hence the boolean array size is of 256 
 * Suppose we have the character P in the string : its ASCII value is 80 . So boolean[80] will be initialized as true
 * Time Complexity - O(n)        Space Complexity - O(n)
 */


package ch1ArraysAndStrings;

public class UniqueCharsInString 
{
	//TO check whether a given string has unique characters or not
	public boolean hasUnique(String str)
	{
		//Create a new boolean array of size equal to the number of ASCII characters
		boolean[] isPresent = new boolean[256];
		
		//Run the loop to traverse through all the characters in the given string
		for(int i = 0; i < str.length() ; i++)
		{
			/*
			 * Store individual characters in an int variable
			 * ASCII value of the corrosponding character will be stored in ch
			 */
			int ch = str.charAt(i);
			
			/*
			 * If the character being checked is already present, the boolean array would have a true value associated with it
			 * Return false as there is no unique character in the string anymore
			 */
			if( isPresent[ch] == true )
				return false;
			
			/*
			 * Else the character in mention is not yet repeated in the string
			 * Mark that index position as true and loop again to check for any repetitions
			 */
			isPresent[ch] = true;
		}
		
		//If the loop completes without returning false, it means that all characters
		return true;
	}
	
	
	public static void main(String[] args) 
	{
		UniqueCharsInString str = new UniqueCharsInString();
		
		System.out.println("Does the given string has unique characters :"+(str.hasUnique("azxsdcvfgbnhjmklpoiuytreq")? "Yes": "No"));
	}
}
