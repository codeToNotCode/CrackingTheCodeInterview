/*
 * To check whether a given string characters or not using BIT manipulations
 */

package ch1ArraysAndStrings;

public class UniqueCharsUsingBits 
{
	public boolean hasUnique(String str)
	{
		/*
		 * This variable is used to check whether a particular character is repeating or not
		 * If value of checker is greater than 0, means the character is repeating
		 * Else update the checker 
		 */
		int checker = 0 ;
		
		//Loop through the string to traverse all the characters in the given string
		for(int i = 0 ; i < str.length() ; i++ )
		{
			//Stores the integer difference between the extracted character and letter 'a'
			int val = str.charAt(i) - 'a';
			
			/*
			 * Performs left shift operator on 1
			 * 'Ands' the resultant binary number with checker
			 * 			 */
			if( (checker & (1 << val )) > 0)
				return false;
			
			/*
			 * If the character is not repeating:
			 * Updates the checker variable by "ORing" it with the left shift on 1
			 */
		}
		
		//If the loop completes without returning false, it means that all characters//If all the elements are 
		return true;
	}

	public static void main(String[] args) 
	{
		UniqueCharsUsingBits str = new UniqueCharsUsingBits();
		
		System.out.println("Does the given string has unique characters :"+(str.hasUnique("prsan")? "Yes": "No"));
	}
}
