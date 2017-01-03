/*
 * Given first n natural numbers with 1 missing number, find that number
 * Using sum formjula for first n natural numbers to solve the problem
 * Time Complexity - O(n)
 * Also if the value of n is very large, then the sum of first n natural numbers might go out of range
 * Use XOR operation technique instead
 */


package ch5BitManipulations;

public class MissingNum
{
	
	/*
	 * To find the missing number in the first n natural numbers
	 */
	public int missingNum(int[] arr)
	{
		//Store the length of the array that contains all the first n-1 natural numbers except the missing number
		int n = arr.length;
		
		/*
		 * Find the sum of first n natural numbers
		 * We are using n+1 instead of n because our array is missing a number and we calculate the sum by assuming it to be in the array
		 */
		int total = ((n+1) * (n+2)) / 2 ;
		
		/*
		 * Subtract all the individual array elements from the calculated sum of first n natural numbers
		 * The value remaining will be our missing number
		 */
		for( int i = 0 ; i < arr.length; i++ )
			total = total-arr[i];
		
		//Return the missing number
		return total;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		int[] arr = {5,1,2,3,6,8,7,9,10,4,12,11,14};
		MissingNum mn = new MissingNum();
		System.out.println("The missing number in the given series is : "+mn.missingNum(arr));
	}
}
