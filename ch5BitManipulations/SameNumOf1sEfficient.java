/*
 * To find the next smallest and largest number with the same number of 1s as the given number
 */



package ch5BitManipulations;

public class SameNumOf1sEfficient
{
	public boolean getBit(int num, int index)
	{
		return ( ( num & (1 << index ) ) > 0 );
	}
	
	public int setBit( int num, int index, boolean b)
	{
		if(b)
			return num | ( 1 << index );
		else
		{
			int mask = ~ ( 1 << index );
			return num & mask;
		}
	}
	
	
	public int nextLargest(int num)
	{
		if( num <= 0 )
			return -1;
		
		int index = 0;
		int countOnes = 0;
		
		//find the first 1
		while( !getBit(num, index))
			index++;
		
		//Turn on the next 0
		while( getBit(num, index))
		{
			index++;
			countOnes++;
		}
		
		num = setBit(num , index, true);
		index--;
		
		
		num = setBit( num, index, false);
		countOnes--;
		
		//Set 0s
		for( int i = index - 1 ; i >= countOnes ; i-- )
			num = setBit(num, i , false);
			
		
		//Set 1s
		for( int i = countOnes - 1 ; i >= 0 ; i-- )
			num = setBit(num, i , true);
		
		return num;
	}
	
	//Driver function
	public static void main(String[] args)
	{
		SameNumOf1sEfficient sm = new SameNumOf1sEfficient();
		System.out.println("The next largest integer with the same number of 1s is :"+sm.nextLargest(10));
		//System.out.println("The next smallest integer with the same number of 1s is :"+sm.nextSmallest(8));
	}
}
