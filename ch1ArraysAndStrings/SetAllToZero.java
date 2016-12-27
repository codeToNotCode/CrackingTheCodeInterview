/*
 * Set the entire row and column to zero if a particular element in the array is zero
 */

package ch1ArraysAndStrings;

public class SetAllToZero 
{
	//To set the entire row and column to zero if a particular element is zero
	public int[][] setToZero(int matrix[][])
	{
		//Create two new arrays rows and columns to keep track of the row(and Column) in which the element is zero
		int rows[] = new int[matrix.length];
		int cols[] = new int[matrix[0].length];
		
		/*
		 * Find the index of the element that is zero
		 * Mark that particular row and column as 1
		 */
		for(int i = 0 ; i < matrix.length ; i++ )
			for(int j = 0 ; j < matrix[0].length ; j++ )
				if( matrix[i][j] == 0)
				{
					rows[i] = 1;
					cols[j] = 1;
				}

		//If either of the row or column has been marked 1 , make all corrosponding elements as zero
		for(int i = 0 ; i < matrix.length ; i++ )
			for(int j = 0 ; j < matrix[0].length ; j++ )
				if( rows[i] == 1 || cols[j] == 1)
					matrix[i][j] = 0;
		
		return matrix;
	}
	
	//To display contents of a matrix
	public void showMatrix(int matrix[][])
	{
		for (int i = 0; i < matrix[0].length; i++) 
		{
			for (int j = 0; j < matrix[0].length; j++) 
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	//Driver function
	public static void main(String[] args) 
	{
		
		SetAllToZero rm = new SetAllToZero();
		
		int size = 3;
		int[][] matrix = new int[size][size];
		int count = -1;
		
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				matrix[i][j] = count++;
			}
			
		}
		
		System.out.println("Original Matrix");
		rm.showMatrix(matrix);
		System.out.println("\nZeroed Matrix");
		rm.showMatrix(rm.setToZero(matrix));
	}

}
