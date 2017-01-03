/*
 * To check whether a given number is a power oof 2 or not
 */

package ch5BitManipulations;

public class IsPowerOf2
{
	public boolean isPowerOf2(int num)
	{
		return ( (num & num-1) == 0 );
	}
	
	
	public static void main(String[] args)
	{
		IsPowerOf2 pow = new IsPowerOf2();
		System.out.println("Is the given number a power of 2? \n"+(pow.isPowerOf2(512)? "Yes" : "No"));
	}
}
