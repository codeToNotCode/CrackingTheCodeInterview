/*
 * Implementation of Stacks using a linked list
 */

package ch3StacksQueues;

public class Stacks 
{
	public class Node
	{
		Object data;
		Node next;
		
		public Node(Object d)
		{
			data = d;
			next = null;
		}
	}
	
	//To access the topmost(most recent) element
	Node top;
	
	//To check whether the stack is empty
	public boolean isEmpty()
	{
		return top == null;
	}
	
	//To see what value does the most recent element in the stack stores
	public Object peek()
	{
		return top.data;
	}
	
	//To push new elements onto the stack
	public void push(Object data)
	{
		//Create a new node that will contain the data of the new element
		Node newTop = new Node(data);
		
		//check for empty stack
		if ( this.isEmpty() )
		{
			this.top = newTop;
			return;
		}
		//Make the previous top point to the new top
		newTop.next = top;
		
		//Make the new element as the new top of the stack
		top = newTop;
	}
	
	//To remove the most recently added element from the stack
	public Object pop()
	{
		//If the stack is empty - Cannot pop
		if( top == null )
		{
			System.err.println("Cannot pop from an empty stack");
			return null;
		}
		
		//store the value of the element to be removed in a variable
		Object poppedElement = top.data;
		
		//Move the top element to the next element in order to pop it out
		top = top.next;
		
		//Return the popped element
		return poppedElement;
	}
	
	//Display stack elements
	public void display(Node top)
	{
		//Check for empty stack
		if ( isEmpty() )
		{
			System.err.println("EMPTY STACK");
			return;
		}
		
		
		while ( top != null )
		{
			System.out.println(top.data);
			top = top.next;
		}
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		Stacks stk1 = new Stacks();
		
		stk1.push("Prasan");
		stk1.push("Is");
		stk1.push("Name");
		stk1.push("My");
		stk1.push("Hi");
		
		System.out.println("Elements of the stack are :");
		stk1.display(stk1.top);
		System.out.println("Element at the top of the stack is :"+stk1.peek());
		
		
		System.out.println("Element removed from the stack :"+stk1.pop());
		System.out.println("Elements of the stack are :");
		stk1.display(stk1.top);
	}
}
