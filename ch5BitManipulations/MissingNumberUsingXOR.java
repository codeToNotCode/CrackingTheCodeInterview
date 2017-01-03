/*
 * To find a missing number from a given set of first n natural numbers
 * Using XOR operator for the solution
 * XOR all the array elements : X1
 * XOR all naturall numbers upto n : X1
 * Missing number = X1 XOR X2
 */

package ch5BitManipulations;

public class MissingNumberUsingXOR
{

	/*
	 * To find the missing number from a series of first n natural numbers
	 */
	public int missingNum(int[] num)
	{
		//Store the length of the array that contains all the first n-1 natural numbers except the missing number
		int n = num.length;
		
		//Store the first element of the given array
		int x1 = num[0];
		
		//Store the first natural number
		int x2 = 1;
		
		//XOR all n - 1 elements of the given array
		for( int i = 1 ; i < n ; i++)
			x1 = x1 ^ num[i];
		
		//XOR all the first n natural numbers
		for( int i = 2 ; i <= n + 1 ; i++)
			x2 = x2 ^ i;
		
		//Return the XOR of x1 and x2 : missing number
		return x1 ^ x2;
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		int[] arr = {5,1,2,3,6,8,7,9,4};
		MissingNumberUsingXOR mn = new MissingNumberUsingXOR();
		System.out.println("The missing number in the given series is : "+mn.missingNum(arr));
	}
}
