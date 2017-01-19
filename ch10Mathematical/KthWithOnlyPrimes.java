/*
 * To find the kth number such that the only prime factors are 3,5 and 7
 * This number is also known as the UGLY number : a number whose only factors are prime numbers and 1
 * The algorithm used here is Brute force O(n^2) . It can be improved upon	
 */
package ch10Mathematical;


public class KthWithOnlyPrimes
{
	/*
	 * To return the number num after dividing it by the greatest divisible power of the given prime number
	 */
	public int getMaxDivide(int num, int prime)
	{
		while ( num % prime == 0 )
			num = num / prime;
		return num;
	}
	
	
	/*
	 * TO check whether the given number is an ugly number or not
	 * Divide the given number by the Greatest Divisible power of all the individual prime numbers specified
	 * If in the end, you are able to successfully divide the num and you get 1 as the quotient
	 * Then the given number is an UGLY number
	 * Else not
	 */
	public boolean isUgly(int num)
	{
		num = getMaxDivide(num, 3);
		num = getMaxDivide(num, 5);
		num = getMaxDivide(num, 7);
		
		return ( num == 1 ) ? true : false;
	}
	
	
	/*
	 * TO find the kth ugly number 
	 * Keep on checking for ugly numbers starting from 1 until you reach k
	 */
	public int findUgly(int k)
	{
		//1 is by default the starting point for ugly numbers
		int i = 1;
		
		//To keep track of the number of ugly numbers reached upto k
		int count = 1;
		
		//Iterate the loop until you reach k
		while( count < k )
		{
			i++;
			
			//Check whether the next number is an Ugly number or not, if yes : increment the ugly count and check the next number
			if( isUgly(i) )
				count++;
		}

		//Return the kth ugly number
		return i;
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		KthWithOnlyPrimes kwop = new KthWithOnlyPrimes();
		int kthUgly = kwop.findUgly(10);
		System.out.println(kthUgly);
		
	}
}
