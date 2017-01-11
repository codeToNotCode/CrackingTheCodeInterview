/*
 * To print the nth fibonacci number using both recursion and iteration
 */

package ch8Recursion;

import java.util.Scanner;

public class NthFibonacci
{
	
	//Iterative Solution
	public int getFibo(int num)
	{
		/*
		 * Checking for initial base case solution
		 * You can also check for num == 1 and return 1 but that is covered in the loop structure
		 */
		if ( num == 0)
			return 0;
		
		int a = 1, b = 1;
		
		for(int i = 3; i <= num ; i++ )
		{
			int c = a + b;
			a = b;
			b = c;
		}
		
		//Return the nth fibonacci number
		return b;
	}
	
	
	//Recursive Solution
	public int getFib(int num)
	{
		//Base cases for recursion
		if(num == 0)
			return 0;
		if(num == 1)
			return 1;
		
		//Recursive step
		return getFib(num-1) + getFib(num - 2);
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		NthFibonacci fib = new NthFibonacci();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nth number :");
		int num = scan.nextInt();
		
		System.out.println("The "+num+"th fibonacci number is :"+fib.getFib(num));
		System.out.println("The "+num+"th fibonacci number is :"+fib.getFibo(num));
		
		scan.close();
	}
}
