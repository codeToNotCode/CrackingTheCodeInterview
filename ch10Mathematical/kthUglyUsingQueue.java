/*
 * To find the kth ugly number 
 * This algorithm uses Queue Data Structure
 * 
 * 1. Initialize queues Q3, Q5 and Q7
 * 2. Insert 1 into min.
 * 3. Insert 1*3, 1*5 and 1*7 into Q3, Q5 and Q7 respectively.
 * 4. Let x be the minimum element in Q3, Q5 and Q7. .
 * 5. If x was found in:
 *		 Q3 -> append x*3, x*5 and x*7 to Q3, Q5 and Q7. Remove x from Q3.
 *		 Q5 -> append x*5 and x*7 to Q5 and Q7. Remove x from Q5.
 * 		 Q7 -> only append x*7 to Q7. Remove x from Q7.
 * 
 * Note: we do not need to append x*3 and x*5 to all lists because they will already be found in another list.
 * 
 * 6. Repeat steps 4 - 6 until we’ve found k elements.
 */
package ch10Mathematical;

import java.util.LinkedList;
import java.util.Queue;

public class kthUglyUsingQueue
{
	/*
	 * Function to return the kth ugly number with prime numbers 3,5 and 7 as factors
	 */
	public int findUgly(int k)
	{
		if( k <= 0 )
			return -1;
		
		//1 is selected to be the default ugly number for this list
		int min = 1;
		
		//Declare Queues for each of the prime numbers
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		
		//Perform the first iteration by adding 3 5 and 7 to their respective queues manually
		q3.add(3);		q5.add(5);		q7.add(7);
		
		//Start from k and go till 0
		for( --k ; k > 0 ; --k )
		{
			//Find the minimum of the minimum of the values that are inserted in the 3 queues in this particular iteration
			min = Math.min(q3.peek().intValue(), Math.min(q5.peek().intValue(), q7.peek().intValue()));
			
			/*
			 * Remove the value from the queue which it came from
			 * Add the next element to the corrosponding queue
			 */
			if( min == q7.peek() )
				q7.remove();
			else
			{
				if( min == q5.peek() )
					q5.remove();
				else
				{
					q3.remove();
					q3.add(min*3);
				}
				q5.add(min * 5);
			}
			q7.add(min * 7);
			
		}
		return min;
	}
	
	// Driver function
	public static void main(String[] args)
	{
		kthUglyUsingQueue kwop = new kthUglyUsingQueue();
		int kthUgly = kwop.findUgly(10);
		System.out.println(kthUgly);

	}
}
