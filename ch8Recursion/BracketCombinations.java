/*
 * To print all valid combinations of a given number of parenthesis
 */


package ch8Recursion;

public class BracketCombinations
{
	
	/*
	 * To generate all valid combinations of brackets
	 * Input : Empty string, 0 , 0 , number of pairs of brackets
	 * Output : All the possible valid combinations
	 */
	public void Brackets(String output, int open, int close, int numPairs)
	{
		/*
		 * Base case: When both opening and closing brackets become equal to the number of total pairs
		 * Print the combination
		 */
		if( open == numPairs && close == numPairs)
			System.out.println(output);
		else
		{
			/*
			 * If more opening braces can be added
			 * Update the output with an opening brace
			 * Recurse with newly increased value of opening brace
			 */
			if( open < numPairs)
				Brackets(output + "(", open + 1, close, numPairs);
			
			/*
			 * Number of closing braces can never be greater than the number of opening braces
			 * So Recurse in the same way for closing brace for all its values less than the number of opening braces
			 */
			if( close < open )
				Brackets(output + ")", open, close + 1, numPairs);
		}
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		BracketCombinations bc = new BracketCombinations();
		bc.Brackets("",0,0,3);
	}
}
