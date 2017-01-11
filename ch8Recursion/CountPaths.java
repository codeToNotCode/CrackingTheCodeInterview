/*
 * To count the number of paths that can be taken to go to bottom right corner of a matrix starting from the top left
 * You can only go right and down
 */

package ch8Recursion;

import java.util.Scanner;

public class CountPaths
{
	/*
	 * To count the number of paths using dynamic programming and recursion
	 * Start with 2X2 3X3 matrices and then build for general case
	 * 
	 */
	public long countPaths(long[][] matrix, int rows, int columns)
	{
		if( rows == 0 || columns == 0)
			return 1;
		else if ( matrix[rows][columns] > -1 )
			return matrix[rows][columns];
		else
		{
			matrix[rows][columns] = countPaths(matrix, rows-1 , columns) + countPaths(matrix, rows, columns -1);
			return matrix[rows][columns];
		}
		
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		CountPaths cp = new CountPaths();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the dimensions of the matrix : <rows> <columns> :");
		int rows = scan.nextInt();
		int columns = scan.nextInt();
		
		long[][] matrix = new long[rows][columns];
		for( int i = 0; i < rows ; i++)
			for(int j = 0 ; j < columns ; j++)
				matrix[i][j] = -1;
		
		System.out.println("Total number of paths to reach the bottom right corner :"+cp.countPaths(matrix,rows-1,columns-1));
		
		scan.close();
	}
}
