/*
 * TO sort a given stack
 */

package ch3StacksQueues;
import java.util.Stack;

public class SortAStack 
{
	//To sort a given stack that is passed as an argument
	public Stack<Integer> sortStack(Stack<Integer> stk)
	{
		/*
		 * Check for the basic validity of the stack
		 * Null means that the stack has not been allocated the memory
		 * isEmpty means that the stack has got the memory but there is no element in the stack
		 * Empty stack is always sorted
		 */
		if ( stk == null || stk.isEmpty() )
		{
			System.err.println("Error: Stack is either null or empty");
			return null;
		}
		
		//Create a new stack which will always be in a sorted order
		Stack<Integer> sortedStack = new Stack<Integer>();
		
		//Push the first element of the given stack onto the sortedStack as it is
		sortedStack.push(stk.pop());
		
		//Continue the loop until the given stack is not empty
		while( !stk.isEmpty() )
		{
			//Remove the topmost element from the given stack and store it in a variable
			int temp = stk.pop();
			
			//Continue the inner loop until the sortedStack is empty and temp is greater than the topmost element of SortedStack
			while( !sortedStack.isEmpty() && temp > sortedStack.peek() )
			{
				//Remove the topmost element from the sortedStack and place it in the given stack
				stk.push(sortedStack.pop());
			}
			
			//Push the temp variable back onto the sortedStack at its right position
			sortedStack.push(temp);
		}
		
		//Return the sorted stack back
		return sortedStack;
	}
	
	public static void main(String[] args) 
	{
		Stack<Integer> stk = new Stack<Integer>();
		
		stk.push(4);		stk.push(5);		stk.push(1);	
		stk.push(8);		stk.push(81);		stk.push(18);
		stk.push(28);		stk.push(38);		stk.push(88);
		
		SortAStack obj = new SortAStack();
		
		Stack<Integer> sortStk = obj.sortStack(stk);
		
		/*
		 * Converting to an array just to display the stack
		 * Can use the normal display of stacks too
		 */
		Object stkArray[] = sortStk.toArray();
		
		System.out.println("Sorted Stack :");
		for( int i=stkArray.length-1; i >= 0 ; i--)
			System.out.println(stkArray[i]);
	}
}
