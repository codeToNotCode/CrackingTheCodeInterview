/*
 * To find the next smallest and largest number with the same number of 1s as the given number
 * Brute Force technique
 */


package ch5BitManipulations;

public class SameNumOf1s
{
	/*
	 * To find the next largest integer with the same numbera of 1s as the given integer
	 */
	public int nextLargest(int num)
	{
		int count;
		String binary = toBinary(num);
		count = get1s(binary);
		
		num = num +1;
		while( count != get1s(toBinary(num)))
			num++;
		
		return num;
	}
	

	/*
	 * To find the next smallest integer with the same number of 1s as the given integer
	 */
	public int nextSmallest(int num)
	{
		int count;
		String binary = toBinary(num);
		count = get1s(binary);
		
		num = num - 1;
		while( count != get1s(toBinary(num)))
			num--;
		
		return num;
	}
	

	/*
	 * To convert a given integer to its binary equivalent
	 * The binary digits will be returned in the form of a string
	 */
	public String toBinary(int num)
	{
		String binary = "";
		while ( num > 0 )
		{
			int remainder = num % 2;
			num >>= 1;
			binary += remainder;
		}
		StringBuilder b = new StringBuilder(binary);
		binary = b.reverse().toString();
		
		return binary;
	}
	
	
	/*
	 * TO count the number of 1s in a given binary string
	 */
	public int get1s(String str)
	{
		int count = 0;
		for(int i = 0; i < str.length() ; i++)
			if(str.charAt(i) == '1')
				count++;
		
		return count;
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		SameNumOf1s sm = new SameNumOf1s();
		System.out.println("The next largest integer with the same number of 1s is :"+sm.nextLargest(8));
		System.out.println("The next smallest integer with the same number of 1s is :"+sm.nextSmallest(8));
	}
}
