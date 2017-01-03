/*
 * To find the missing number from a given series of first n natural numbers
 */

package ch5BitManipulations;

import java.util.ArrayList;
import java.util.Random;

public class FindMissingUsingBits
{
	
	//Create a random array of numbers from 0 to n, but skip 'missing'
	public ArrayList<BitInteger> initialize(int n , int missing)
	{
		//To store the number of bits that are required to store the given number n in its binary form
		BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
		
		//Declare an arraylist of binary numbers
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();
		
		/*
		 * To store all the numbers from 0 to n in the arrayList in their binary from
		 * The missing number will be stored as a 0 
		 * Rest all the numbers will have their binary equivalents
		 */
		for(int i = 1; i <= n ; i++)
		{
			array.add(new BitInteger(i == missing ? 0 : i));
		}


		//Shuffle the array once
		for(int i = 0 ; i < n ; i++)
		{
			int rand = i + (int)(Math.random() * (n-i));
			array.get(i).swapValues(array.get(rand));
		}
		
		//Return the arrayList that contains all the numbers from 0 to n in their binary form with missing number set to 0
		return array;
	}
	
	
	public int findMissing(ArrayList<BitInteger> array)
	{
		return findMissing(array, BitInteger.INTEGER_SIZE - 1);
	}
	
	
	private int findMissing(ArrayList<BitInteger> input, int column)
	{
		//Base case and error condition
		if( column < 0 )
			return 0;
		
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size()/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size()/2);
		
		for(BitInteger t : input)
		{
			if( t.fetch(column) == 0)
				zeroBits.add(t);
			else
				oneBits.add(t);
		}
		
		if( zeroBits.size() <= oneBits.size())
		{
			int v = findMissing(zeroBits, column -1);
			System.out.print("0");
			return (v << 1) | 0;
		}
		else
		{
			int v = findMissing(oneBits, column -1);
			System.out.print("1");
			return (v << 1) | 1;
		}
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		FindMissingUsingBits fmub = new FindMissingUsingBits();
		
		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		int missing = rand.nextInt(n+1);
		ArrayList<BitInteger> array = fmub.initialize(n, missing);
		System.out.println("The array contains all numbers but one from 0 to "+ n +", except for "+missing);
		
		int result = fmub.findMissing(array);
		if( result != missing)
			System.out.println("Error in the algorithm!\n"+"The missing number is "+missing+", but the algorithm reported "+result);
		else
			System.out.println("The missing number is "+result);
	}
}
