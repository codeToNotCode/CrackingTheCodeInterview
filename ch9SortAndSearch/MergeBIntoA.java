/*
 * To merge sorted array B into sorted array A in a sorted order
 * Array A has enough buffer space to hold both Arrays A and B
 */

package ch9SortAndSearch;

import java.util.Arrays;

public class MergeBIntoA
{
	
	/*
	 * To merge array B into array A in a sorted order
	 * numA represents the number of actual elements in the array A
	 * numB represents the number of actual elements in the array B
	 * Array elements are copied in the reverse order : the greatest element is placed at the end
	 */
	public int[] merge(int[] A, int[] B, int numA, int numB)
	{
		/*
		 * Declaring and initializing indexes
		 */
		int mergedIndex = numA + numB - 1;
		int indexA = numA - 1;
		int indexB = numB - 1;
		
		//Iterate through the loop until all elements of array B have been merged into array A
		while ( indexB >= 0 )
		{
			/*
			 * Compare array elements from the last index
			 * whichever is greater, copy that element to the array A
			 */
			if ( indexA >= 0 && A[indexA] > B[indexB])
				A[mergedIndex--] = A[indexA--];
			else
				A[mergedIndex--] = B[indexB--];
		}
		
		//return the sorted array
		return A;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		MergeBIntoA mbia = new MergeBIntoA();
		int A[] = {1,2,3,5,7,9,0,0,0,0,0};
		int B[] = {4,5,6,8,10};
		
		mbia.merge(A,B,6,5);
		
		System.out.println(Arrays.toString(A));
	}
}
