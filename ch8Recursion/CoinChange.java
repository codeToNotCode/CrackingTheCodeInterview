/**
 * Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 *
 */

package ch8Recursion;


import java.util.HashMap;
import java.util.Map;

public class CoinChange
{

    /**
     * Top down dynamic programing. Using map to store intermediate results.
     * Returns Integer.MAX_VALUE if total cannot be formed with given coins
     */
    public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) 
        {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }

    /**
     * Bottom up way of solving this problem.
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     * Returns Integer.MAX_VALUE - 1 if solution is not possible.
     */
    public int minimumCoinBottomUp(int total, int[] coins)
    {
    	//Create two arrays to store the number of ways and to find the actual coins that will be used
    	int T[] = new int[total+1];
    	int R[] = new int[total+1];
    	
    	//Initializd the first element to 0 and rest all elements to Infinity
    	//For the 2nd array, initialize every element to -1
    	T[0] = 0;
    	
    	for(int i = 1; i<=total; i++)
    	{
    		T[i] = Integer.MAX_VALUE -1;
    		R[i] = -1;
    	}
    	
    	
    	/*
    	 * Actual Code through dynamic programming
    	 * The value at the last index of the T[] array will provide the solution for the number of ways required to form the given change amount
    	 * Corrosponding coin value index will be stored in the R[] array
     	 */
    	
    	for(int j = 0; j<coins.length; j++)
    	{
    		for(int i = 1; i<=total; i++ )
    		{
    			if( i >= coins[j] )
    			{
    				if( T[i - coins[j]] + 1 < T[i] )
    				{
    					T[i] = T[i - coins[j]] + 1;
    					R[i] = j;
    				}
    			}
    		}
    	}
    	
    	//To display the coin values that were used to arrive at the result
    	showCoinsUsed(R, coins); 
    	
    	//Return the last index value of the T[] array depicting the min no. of coins required
    	return T[total];
    }
    
    
    /*
     * To show the coin values that were used to arrive at the result for min no. of coins required
     */
    public void showCoinsUsed(int[] R, int[] coins)
    {
    	//Store the value of the last index
    	int start = R.length - 1;
    	
    	//If the value at the last index is -1 (unchanged), it means no solution for the given change value is possible
    	if( R[start] == -1 )
    	{
    		System.out.println("No Solution exists");
    		return;
    	}
    	
    	System.out.println("Coins which were used to arrive at the result:");
    	
    	//Display coins[j] until you reach 0
    	while( start > 0)
    	{
    		int j = R[start];
    		System.out.print(coins[j] + " ");
    		start = start - coins[j];
    	}
    }
    
    
    //Driver Function
    public static void main ( String args[] ) 
    {
        int total = 100;
        int coins[] = {25, 10, 5, 1};
        
        CoinChange cc = new CoinChange();
        Map<Integer, Integer> map = new HashMap<>();
        
        int topDownValue = cc.minimumCoinTopDown(total, coins, map);
        int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

        System.out.println("\nMinimum nummber of coins required by bottom-up DP:"+bottomUpValue);
        System.out.println("\nMinimum nummber of coins required by top-down DP:"+topDownValue);

    }
}