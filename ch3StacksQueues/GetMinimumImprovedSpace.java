/*
 *	To implement a special stack that has a getMin() function which return the minimum number present in the stack
 *	Time Complexity O(1)
 *	Space Complexity : Its better than the normal algorithm as we do not add all the elements to the auxillary stack
 *	Only those elements which are smaller than the previous stack element will be added to the auxillary stack
 *	SO, for average case : number of elements in auxillary stack will always be less than that in the actual stack
 *	In worst case, if elements are added in the decreasing order , then both the stacks will have the same number of elements
 *	Hence, O(n) space complexity again
 */

package ch3StacksQueues;



/*
 * Sub class that inherits from GetMinimum class
 * GetMinimum class have all the standard features of a stack - push() peek() pop()
 * The derived SpecialStack class consists of all the base class functions along with getmin() function
 * getMin() returns the minimum element present in the stack
 */

class AuxStack extends GetMinimumImprovedSpace
{
	/*
	 * Object of the super class
	 * This object acts as an auxillary stack
	 * Stores minimum of the stack as the topmost element as new elements are added to the stack
	 * Size of auxillary stack is kept the same as that of the original stack
	 */
	GetMinimum min = new GetMinimum();
	
	
	public void push(int data)
	{
		//If both the stacks are empty, push the new element onto both the stacks
		if(isEmpty())
		{
			super.push(data);
			min.push(data);
		}
		else
		{
			super.push(data);
			
			/*
			 * Retrieve the previous minimum element that is present in the auxillary stack
			 * The below 2 lines can also be substituted with a peek method on auxillary stack
			 */
			
			int minData = min.pop();
			min.push(minData);
			
			/*
			 * If data is less than the current minimum element, push the new minimum(data) onto the auxillary stack
			 */
			if( data <= minData )
				min.push(data);
		}
	}
	
	/*
	 * Pop operation performed on both the stacks
	 * Value popped from the original stack is returned
	 * Whereas value from the auxillary stack is simply popped off
	 */
	public int pop()
	{
		int poppedElement = pop();
		int auxPop = min.pop();
		
		//Push the element popped from the Auxillary stack back only if it is not equal to the elements being popped from the orginal stack
		if ( auxPop != poppedElement)
			min.push(auxPop);
		
		return poppedElement;
	}
	
	/*
	 * This function returns the minimum element that is present in the original stack
	 * The minimum element is always the topmost element of the auxillary stack
	 */
	public int getMin()
	{
		int minData = min.pop();
		min.push(minData);
		
		return minData;
	}
	
}

public class GetMinimumImprovedSpace
{
	public class Node
	{
		int data;
		Node next;
		
		public Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	Node top;
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	//Insert elements onto stack
	public void push(int data)
	{
		Node newNode = new Node(data);
		if( isEmpty() )
			top = newNode;
		
		newNode.next = top;
		top = newNode;
	}
	
	//Return the topmost element of the stack
	public int peek()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Cannot return the topmost element from an EMPTY stack");
			return 0;
		}
		
		return top.data;
	}
	
	//Remove the topmost element in the stack
	public int pop()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Cannot pop from an Empty stack");
			return 0;
		}
		
		Node poppedElement = top;
		top = top.next;
		
		return poppedElement.data;
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		AuxStack s = new AuxStack();
		
		s.push(10);
		s.push(20);
		s.push(30);
		
		System.out.println("Minimum element in the stack : "+s.getMin());
		
		s.push(5);
		System.out.println("Minimum element in the stack : "+s.getMin());
		
	}
}