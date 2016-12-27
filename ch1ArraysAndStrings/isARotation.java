/*
 * To check whether the given string is a rotation of another
 * For example : "My Room" is a rotation of "Room My"
 */
package ch1ArraysAndStrings;

public class isARotation 
{
	//To check whether the 2nd string is a rotation of the first string
	public boolean isRotation(String s1, String s2)
	{
		//If the lengths of both the strings differ, return false
		if( s1.length() != s2.length())
			return false;
		
		//Convert both strings to lowercase to remove the case sensitivity
		s1 = s1.toLowerCase(); s2 = s2.toLowerCase();
		
		//Concatenate the first string with itself
		s1 = s1 + s1 ;
	
		/*
		 * Check whether s2 is a substring of self-concatenated string s1
		 * Two functions for checking whether one string is a substring of the other
		 * Use either of them --- .contains() or .indexOf() -- .contains() is the latest
		 */
		return s1.contains(s2);
		//return s1.indexOf(s2)!= -1;
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		isARotation rot = new isARotation();
		
		System.out.println("Is the second string a rotation of the first? \n"+(rot.isRotation("WaterBottle", "terBottlewa")? "Yes":"No"));
	
	}
}
