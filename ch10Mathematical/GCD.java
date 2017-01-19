/*
 * TO find the GCD( Greatest Common Divisor ) of two numbers
 * GCD of 6 and 8 can be found out using 2 methods
 * 
 * Factorization : Factors of 6 are 1 2 3 6 . Factors of 8 are 1 2 4 8 . GCD of 6 and 8 is 2
 * This method is works well for small numbers . But for very large numbers, Factorization is slow
 * 
 * Euclids Algorithm -  GCD of 42 and 90
 * divide 90 by 42 and note the quotient and remainder 90 = 2 ( 42 ) + 6
 * GCD of 42 and 90 will be equal to GCD of 42 and 6 ... 42 = 7 ( 6 ) + 0
 * GCD of 42 and 90 will be equal to GCD of 6 and 0. Which is 6
 * Hence by Euclids Algorithm, GCD of 42 and 90 is 6 
 * 
 */


package ch10Mathematical;

public class GCD
{
	
	/*
	 * Function to find Greatest common divisor using iteration
	 */
	public int findGCD(int num1, int num2)
	{

		if( num1 < num2)
		{
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		//Declare a temporary variable
		int c = num1;
		
		//Iterate the loop until c is 0
		while ( c != 0 )
		{
			c = num1 % num2;
			num1 = num2;
			num2 = c;
		}
		
		//Return GCD of the given two numbers
		return num1;
	}

	
	/*
	 * Function to find Greatest common divisor using Recursion
	 */
	public int findGCDR(int num1, int num2)
	{
		//Base condition for recursion
		if( num2 == 0 )
			return num1;
		
		//To make sure that num1 always contains the larger of the two numbers
		if( num1 < num2)
		{
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
			
		return findGCDR(num2, num1 % num2);
	}
	
	
	//Driver Function
	public static void main(String[] args)  
	{
		GCD gcd = new GCD();
		System.out.println(gcd.findGCD(7398,2877));	
		System.out.println(gcd.findGCDR(2877,7398));	
	}
}
