/*
 * To findd the number of ways a coin change can be made given the denominations available and the amount of change required
 * This algorithm uses only recursion and is inefficient
 * To make it efficient, we use DP - Storing the number of ways in a table with key-
 */


package ch8Recursion;

import java.util.HashMap;

public class MakeChange
{
	
	/*
	 * Function to calculate the number of ways available to provide change in the given denominations
	 */
	public static Long makeChange(int changeRequired, int denom,HashMap<String,Long> memo) 
	{
		int next_denom = 0;
 
		//To select the next denomination based on the current denomination
		switch (denom) 
		{
			case 25:
				next_denom = 10;
				break;
			case 10:
				next_denom = 5;
				break;
			case 5:
				next_denom = 1;		
				break;
			case 1:
				return (long) 1;
		}
 
		String key = ""+changeRequired;
		if(memo.containsKey(key))
			return memo.get(key);
		
		long ways = 0;
	
		//Recursively count the number of ways 
		for (int i = 0; i * denom <= changeRequired; i++) 
		{
			ways += makeChange(changeRequired - i * denom, next_denom,memo);
		}
		
		memo.put(key, ways);
		//Return the total number of ways
		return ways;
	}

	
	//Driver Function
	public static void main(String[] args)
	{
		 System.out.println(makeChange(100, 25,new HashMap<String,Long>()));
	}
}