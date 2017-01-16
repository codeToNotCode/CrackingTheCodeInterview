/*
 * To search for an element in a circular sorted array
 * Assumptions : no duplicates
 * Method will not work if you have duplicate elements
 * For more comments - look for same solution under GeeksForGeeks/search
 */

package ch9SortAndSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchCircularSorted
{
	public int search(int A[], int num)
	{
		int start = 0;
		int end = A.length - 1;
		
		while( start <= end )
		{
			int mid = start + (end - start) / 2;
			
			if( num == A[mid] )
				return mid;
			
			if( A[mid] <= A[end] )
			{
				if( num > A[mid] && num <= A[end] )
					start = mid + 1;
				else
					end = mid - 1;
			}
			else if ( A[mid] >= A[start])
			{
				if( num >= A[start] && num < A[mid] )
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args)
	{
		SearchCircularSorted scs = new SearchCircularSorted();
		int A[] = {6,7,9,10,1,2,4};
		
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		int index = scs.search(A,num);
		
		if (index != -1)
			System.out.println("Element [" + num + "] is present in the array at index [" + index + "]");
		else
			System.err.println("Element not found");

		input.close();
	}
}
