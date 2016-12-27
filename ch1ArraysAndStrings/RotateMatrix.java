/*
 * TO rotate a N*N square matrix by 90 degrees clockwise inplace(Without using an extra matrix)
 */

package ch1ArraysAndStrings;

public class RotateMatrix 
{
	
	/*
	 * To rotate a given N*N square matrix
	 */
	public int[][] rotateMatrix(int[][] matrix)
	{
		//Store the maximum index of the array that is possible
		int length = matrix.length-1;
		
		/*
		 * The outer loop keeps tracks of the various layers that are possible for the array
		 * Number of layers will be equal to (length/2)
		 * After each iteration of the outer loop, the control moves to the next inner layer
		 */
		for (int i = 0; i <= (length)/2; i++) 
		{
			/*
			 * The inner loop traverses the particular layer in a clockwise direction
			 * It starts with all the corner elements
			 * Moves element by element in a clockwise direction until the row gets complete
			 */
			for (int j = i; j < length-i; j++) 
		      {
		          //Store the values of 4 array variables into 4 different variables
		    	  int p1 = matrix[i][j];
		    	  int p2 = matrix[j][length-i];
		    	  int p3 = matrix[length-i][length-j];
		    	  int p4 = matrix[length-j][i];
		        
		    	  //Swap values of 4 coordinates.
		    	  matrix[j][length-i] = p1;
		    	  matrix[length-i][length-j] = p2;
		    	  matrix[length-j][i] = p3;
		    	  matrix[i][j] = p4;
		      }
		  }
		  //Return the newly rotated matrix
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
		
		RotateMatrix rm = new RotateMatrix();
		
		int size = 4;
		int[][] matrix = new int[size][size];
		int count = 0;
		
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				matrix[i][j] = count++;
			}
			
		}
		
		System.out.println("Original Matrix");
		rm.showMatrix(matrix);
		System.out.println("\nRotated Matrix");
		rm.showMatrix(rm.rotateMatrix(matrix));
	}
}
