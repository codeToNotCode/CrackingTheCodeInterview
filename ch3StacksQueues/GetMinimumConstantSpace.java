/*
 * To implement getMin() function of a stack that returns the minimum element present in the stack
 * Time Complexity O(1) and Space Complexity O(1)
 */

package ch3StacksQueues;
import java.util.Stack;

public class GetMinimumConstantSpace 
{
	//Create an object of the standard Stack class 
	Stack<Integer> s;
	
	//Create an Integer Object which will store the minimum element of the stack
	Integer minElement;	
	
	//Constructor to allocate memory for the standard stack
	public GetMinimumConstantSpace()
	{
		s = new Stack<Integer>();
	}
	
	//To print the minimum element present in the stack
	public void getMin()
	{
		//Check for isEmpty()
		if ( s.isEmpty() )
			System.err.println("Error: Stack is Empty");
		//The variable minElement always stores the minimum element present in the stack
		else
			System.out.println("Minimum element of the stack is :"+minElement);
	}
	
	//To print the topmost element in the Stack GetMinimumConstantSpace
	public void peek()
	{
		if(s.isEmpty() )
			System.err.println("Error: Stack is Empty");
		
		//Store the topmost element of the standard stack in an Integer object
		Integer top = s.peek();
		
		System.out.println("Topmost element is :");
		
		//If value of top is less than the minElement, then minElement stores the 
		if( top < minElement )
			System.out.println(minElement);
		else
			System.out.println(top);
	}
	
	
	/*
	 * To remove the topmost element of the stack
	 * If the element being removed	is the minimum element of the stack:
	 * Find the new minimum element in the stack and set it to minElement
	 */
	public void pop()
	{
		if(s.isEmpty() )
			System.err.println("Error: Stack is Empty");
		
		//Remove the topmost element from the stack and store it in an Integer Object
		Integer popped = s.pop();
		
		System.out.println("Element that is removed from the stack is :");
		
		//Compare the popped element with current Minimum element minElement
		if( popped < minElement )
		{
			System.out.println(minElement);
			//Update the new minimum element of the stack
			minElement = 2*minElement - popped;
		}
		else
			System.out.println(popped);
	}
	
	/*
	 * To push an element onto the stack
	 * if the element that is being pushed is greater than the current minimum element, simply push it
	 * else push the element and also update the minElement to the new minimum element
	 */
	public void push(Integer data)
	{
		if( s.isEmpty() )
		{
			minElement = data;
			s.push(data);
		}
		
		//If the number that is to be pushed is less than the current minimum, update the minElement
		if( data < minElement)
		{
			s.push( 2*data - minElement );
			minElement = data;
		}
		else
			s.push(data);
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		GetMinimumConstantSpace stk = new GetMinimumConstantSpace();
		
		stk.push(3);
        stk.push(5);
        stk.getMin();
        stk.push(2);
        stk.push(1);
        stk.getMin();
        stk.pop();
        stk.getMin();
        stk.pop();
        stk.peek();
	}
}
