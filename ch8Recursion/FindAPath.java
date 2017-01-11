/*
 * To find and print a path from topleft corner of a NXN matrix to the bottomright corner
 * Using recursion and Backtracking
 * Not an efficient method
 */

package ch8Recursion;

public class FindAPath
{
	
	/*
	 * To check whether the index can be added to the path or not
	 * If value of the particular index is 1, it can be travelled
	 * If it is 0, it cannot be travelled
	 */
	public boolean isSafe(int matrix[][], int x, int y)
	{
		//Checking for validity of index values before checking for a 1
		if( x>=0 && x<matrix.length && y>=0 && y<matrix.length && matrix[x][y] == 1 )
			return true;
		return false;
	}
	
	
	/*
	 * To recursively find a path from topleft corner to the topright corner
	 * This code can be extended to searching for all the directions and starting from anywhere in the matrix and reaching anywhere
	 * Just add the recursive code for left and up directions and make changes to start and end points respectively
	 */
	public boolean findPath(int matrix[][], int x, int y, int sol[][])
	{
		/*
		 * Base case for recursion
		 * If the destination is reached:
		 * Update the solution matrix and return
		 */
		if ( x == matrix.length - 1 && y == matrix.length - 1 )
		{
			sol[x][y] = 1;
			return true;
		}
		
		
		/*
		 * Check whether the given point is safe for travelling
		 * if yes, update solution matrix and check for bottom and right paths one by one
		 * if not, return false
		 */
		if( isSafe(matrix, x , y))
		{
			sol[x][y] = 1;
			
			if(findPath(matrix, x + 1, y, sol))
				return true;
			
			if(findPath(matrix, x, y + 1, sol))
				return true;
			
			/*
			 * If both of the above do not return true, this means that although the given point is itself suitable for travelling
			 * It does not result in a path to the end point 
			 * Backtracking occurs 
			 * Update solution matrix
			 * Return false
			 */
			sol[x][y] = 0;
			return false;
		}

		//If code reaches this line, it means there is no path from source to end
		return false;
	}
	
	
	/*
	 * To display the solution matrix(path)
	 * All the ones show the path that has to be followed to go from topleft to bottomright
	 */
	public void displayPath( int sol[][])
	{
		for( int i = 0 ; i < sol.length ; i++ )
		{
			for( int j = 0 ; j < sol.length ; j++)
				System.out.print(sol[i][j]+" ");
			System.out.println();
		}
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		FindAPath fap = new FindAPath();
		int[][] matrix = {{1,1,1,0},{0,1,1,1},{1,1,0,1},{0,1,0,1}};
		int[][] sol = new int[matrix.length][matrix.length];
		
		boolean isPath = fap.findPath(matrix, 0, 0, sol);
		if(isPath)
			fap.displayPath(sol);
		else
			System.out.println("No Path exists");
	}
}
