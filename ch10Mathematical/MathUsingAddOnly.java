/*
 * To implement Subtraction, Multiplication and Division using only Addition
 */


package ch10Mathematical;

public class MathUsingAddOnly
{
	
	/*
	 * Function to change the sign of the given number
	 * If its positive, make it negative
	 * If its negative, make it positive
	 */
	public int changeSign(int num)
	{
		int change = 0;
		int d = ( num < 0 ) ? 1 : -1 ;
		
		while( num != 0 )
		{
			change += d;
			num+= d;
		}
		
		return change;
	}
	
	
	
	/*
	 * TO subtract the given twp numbers 
	 * num1 - num2
	 * num1 + (-1)*num2
	 */
	public int subtract(int num1, int num2)
	{
		return num1 + changeSign(num2);
	}
	
	
	/*
	 * To check whether num1 and num2 are of same signs or opposite signs
	 * Used in multiplication and division
	 */
	public boolean isDifferentSign(int num1, int num2)
	{
		return ( (num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0));
	}
	
	
	/*
	 * To multiply the given two numbers
	 * num1 * num2
	 * num1 + num1 + num1 ..... num2 times
	 */
	public int multiply(int n1, int n2)
	{
		//Return 0 if either of the numbers is 0
		if( n1 == 0 || n2 == 0)
			return 0;
		
		int product = 0;
		int num1 = n1;
		int num2 = n2;
		
		/*
		 * Make both the numbers positive
		 * We are not using Math.abs() function here because we have to only use addition and nothing else
		 */
		num1 = abs(num1);
		num2 = abs(num2);
		
		//Add num1 to itself num2 times
		for(int i = 0 ; i < num2 ; i++)
			product+=num1;
		
		//If num1 and num2 were of opposite signs, change sign of the product
		if( isDifferentSign(n1, n2))
			return changeSign(product);
		
		//Return the product as it is if sign of num1 and num2 was same
		return product;
	}
	

	/*
	 * To return the absolute value of a given number
	 * Used in division so as to make both the numbers positive before performing division
	 */
	public int abs(int num)
	{
		if ( num < 0 )
			return changeSign(num);
		return num;
	}
	
	
	
	/*
	 * to divide the given two numbers
	 * num1 / num2
	 * if num2 is zero, return divide by zero error
	 * Subract num2 from num1 untill num1 reaches 0
	 */
	public int divide(int n1 , int n2)
	{
		//Return error if the denominator is zero
		if ( n2 == 0 )
		{
			System.err.println("Divide by Zero Error");
			return 0;
		}
		
		int quotient = 0;
		
		//Make both the numbers positive
		int num1 = abs(n1);
		int num2 = abs(n2);

		//Keep on subtracting num2 from num1 till num1 is zero
		while( num1 != 0 )
		{
			num1 += changeSign(num2);
			quotient++;
		}
		
		//If num1 and num2 were of opposite signs, change sign of the quotient
		if( isDifferentSign(n1, n2))
			return changeSign(quotient);
		
		//Return the quotient as it is if sign of num1 and num2 was same
		return quotient;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		MathUsingAddOnly muao = new MathUsingAddOnly();
		
		System.out.println("Subtraction : "+muao.subtract(-9,-1));
		System.out.println("Multiplication : "+muao.multiply(10,-8));
		System.out.println("Division : "+muao.divide(10,5));
	}
}
