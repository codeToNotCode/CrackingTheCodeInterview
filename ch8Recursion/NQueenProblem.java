/*
 * To write down all positions of N number of queens in a NXN chessboard such that none of the queens attack each other
 */


package ch8Recursion;

import java.util.Arrays;

public class NQueenProblem
{
	
	/*
	 * A Class that stores the row and columns positions for each queen
	 * An Array Of Position data type will be defined in which each array element corrosponds to 1 queen
	 * Each Queen has its own row and column
	 */
	
	class Position
	{
		int row, col;

		Position(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}

	
	/*
	 * Wrapper function that calls the recursive function solveNqueen
	 */
	public Position[] NQueen(int n)
	{
		/*
		 * Create an array of queens of size n(size of the board) that stores positions of all the queens
		 * Initially the row and column positions for all the queens is set to 0 by default
		 */
		Position[] positions = new Position[n];

		//Call the recursive function
		boolean hasSolution = solveNQueen(n, 0, positions);

		//If the above function call evaluates to true, return the positions array else return null
		if (hasSolution)
			return positions;
		else
			return null;
	}

	
	/*
	 * Recursive function that finds positions for all the queens using backtracking
	 */
	private boolean solveNQueen(int n, int row, Position[] positions)
	{
		/*
		 * Base case
		 * If all the rows have been evaluated and last row + 1 is returned
		 * Return true
		 * Algorithm completed successfully
		 */
		if (n == row)
			return true;

		//Declare a variable to check for all the available columns in the row specified by the recursion level 
		int col;
		
		//Check for all the columns in that level
		for (col = 0; col < n; col++)
		{
			/*
			 * A call to isSafe() function that checks whether the position is safe for a new queen to be placed
			 * without getting attacked by the previous queens
			 */
 			if (isSafe(row, col, positions))
			{
 				/*
 				 * If the position is safe : update the new position in the position matrix
 				 * This statement is also the place where backtracking occurs if no column is safe at a particular recursion level
 				 * Control then goes to the previous row and loop is continued
 				 */
				positions[row] = new Position(row, col);
				
				/*
				 * If the below recursion evaluates to true:
				 * You have found a safe position to place the current queen
				 * Move to the next row and look for a safe position to place the next queen
				 * If all the columns of this new row are unsafe for placement of the new queen: Backtrack!
				 * else return true
				 */
				if (solveNQueen(n, row + 1, positions))
					return true;
			}
		}
		
		//Control reaches here only if all the possibilities have been checked but no solution has been obtained
		return false;
	}

	
	/*
	 * Function to check whether a given position is safe for the new queen to be placed
	 */
	public boolean isSafe(int row, int col, Position[] positions)
	{
		
		/*
		 * This loop checks for all the unsafe positions in  a particular recursive row and column
		 * It compares the position of the new queen with positions of all the previous queens
		 * It does not checks for a row as at each recursive call, you are considering 1 single row, so no need to check for that row
		 * you cannot place the new queen in that row itself
		 * Math.abs checks for whether the new queen will be attacked from the diagonals or not
		 * If all the queens dont attack the new queen, loop is finished and true is returned
		 */
		for (int queen = 0; queen < row; queen++)
			if (positions[queen].col == col
					|| Math.abs(positions[queen].row - positions[queen].col) == Math.abs(row - col))
				return false;

		//Return true if the particular column in concern of the particular recursive row level is found to be safe
		return true;
	}

	
	//Driver Function
	public static void main(String args[])
	{
		NQueenProblem s = new NQueenProblem();

		Position[] positions = s.NQueen(4);

		if (positions != null)
			Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
		else
			System.out.println("No solution");
	}
}
