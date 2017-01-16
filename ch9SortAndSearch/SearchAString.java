/*
 * To search for a string in a given String array
 * The String array might also contain empty strings
 */

package ch9SortAndSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAString
{
	
	/*
	 * TO search for a given string in a string array that might contain empty strings
	 * Find the middle index
	 * If the string at the middle index is an empty string : find the middle index towards the left/right until you get an index with a non mpty string
	 * Check this non empty string middle index with the given string using compareTo function
	 * If the result is zero: you found your string : return its index
	 * If the result is greater than zero : given string is greater than the current string at middle index: Search only the right half now
	 * If the result is less than zero : given string is less than the current string at middle index: Search only the left half now
	 * Return -1 if the given string is not present in the array
	 */
	public int search(String[] A, String str)
	{
		int start = 0;
		int end = A.length;
		
		while( start <= end )
		{
			int mid = start + (end-start) / 2;
			
			/*
			 * If the string at the middle index is empty
			 * Look for a new middle index by scanning its left and right indexes
			 */
			if( A[mid].isEmpty() )
			{
				int left = mid - 1;
				int right = mid + 1;
				
				while(true)
				{
					if ( left < start && right > end)
						return -1;
					else if ( right <= end && !A[right].isEmpty() )
					{
						mid = right;
						break;
					}
					else if ( left >= start && !A[left].isEmpty() )
					{
						mid = left;
						break;
					}
					
					left--;
					right++;
				}
			}
			
			//If the middle index with a non empty string is located, compare it with the given string
			int result = A[mid].compareTo(str);
			
			
			if( result == 0)
				return mid;
			else if ( result > 0 )
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		//If the given string is not present in the string array , return -1
		return -1;
	}
	
	
	
	//Driver Function
	public static void main(String[] args)
	{
		SearchAString sas = new SearchAString();
		
		String[] A = {"abs","","","","asdsa","","dfsa"};
		
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		int index = sas.search(A,str);
		
		if (index != -1)
			System.out.println("String [" + str + "] is present in the array at index [" + index + "]");
		else
			System.err.println("String not found");

		input.close();
	}
}
