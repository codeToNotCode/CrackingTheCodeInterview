/*
 * To search for an element in a 2D array in which both rows and columns are sorted
 * Time complexity O(row + column)
 */

package ch9SortAndSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Search2DArray
{
	
	/*
	 * TO search for a given number
	 * Start from top right index
	 * If the given number is greater than the number at top right, increment the row
	 * Else Decrement the column
	 */
	public boolean search(int A[][], int num)
	{
		int row = 0;
		int col = A[0].length -1;
		
		while( row < A.length && col >= 0)
		{
			if( A[row][col] == num)
				return true;
			
			if( num > A[row][col])
				row++;
			else
				col--;
		}
		return false;
	}
	
	
	
	//Driver Function
	public static void main(String[] args)
	{
		Search2DArray sda = new Search2DArray();
		
		int A[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,90}};
		
		for(int i = 0 ; i < A.length ; i++)
			System.out.println(Arrays.toString(A[i]));
		
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		boolean index = sda.search(A,num);
		
		if (index )
			System.out.println("Element [" + num + "] is present in the array ");
		else
			System.err.println("Element not found");

		input.close();
	}
}
