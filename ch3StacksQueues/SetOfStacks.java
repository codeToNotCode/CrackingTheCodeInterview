/*
 * To implement stacks as a pile of plates
 * If  one stack reaches its maximum capacity, start filling up the next stack
 * If all plates from one stack are removed, dump that stack and stark removing from the previous stack
 * Rest of the functionality remains the same
 */


package ch3StacksQueues;

import java.util.ArrayList;

class Stack
{
	private class Node 
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
	private int capacity;
	public int size = 0;
	
	public Stack(int c)
	{
		this.capacity = c;
		top = null;
	}
	
	
	//To check whether the stack that is currently in use is empty or not
	public boolean isEmpty()
	{
		return size == 0 ;
	}
	
	
	//To check whether the stack that is currently in use if full or not
	public boolean isAtCapacity()
	{
		return size == capacity;
	}
	
	
	//To return the topmost element of the stack
	public int peek()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Stack is Empty");
			return 0;
		}
		
		return top.data;
	}
	

	//TO push elements onto the stack which is currently in use
	public boolean push(int data)
	{
		//If the stack is full: do not push
		if( size >= capacity )
			return false;

		//Increment the size as a new element will be added to the stack
		size++;
		
		Node newNode = new Node(data);
		
		if( isEmpty() )
		{
			top = newNode;
		}
		
		newNode.next = top;
		top = newNode;
		
		return true;
	}
	
	
	//TO remove an element from the current stack
	public int pop()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Stack is Empty");
			return 0;
		}
		
		int pop = top.data;
		top = top.next;
		
		//Decrement the number of stack elements once the topmost element has been removed
		size--;
		
		return pop;
	}
}



//Class that contains set of stacks
public class SetOfStacks 
{
	//Create an Array List of stacks to create new stacks on the go
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	
	//TO count the number of stacks that have been created 
	int stackCount = 0;
	
	
	/*
	 * To push data onto the current stack
	 * If the current stack is full, create a new stack and push data onto the newly created stack
	 */
	public void push(int data)
	{
		
		//Obtain the last stack that was being filled before the push operation
		Stack last = getLastStack();
	
		/*
		 * If the last stack is not full, push the new element onto it
		 * else - create a new stack and push the element onto the new stack
		 */
		if ( last != null && !last.isAtCapacity())
		{
			last.push(data);
		}
		else
		{
			//Create a new Stack with capacity = 3
			Stack newStack = new Stack(3);
			
			//Push the data onto the new Stack
			newStack.push(data);
			
			//Add the new stack into the arraylist
			stacks.add(newStack);
			
			//Increment the number of stacks that have been created
			stackCount++;
			
			System.out.println("Current Stack in operation"+stackCount);
		}
	
	}

	
	/*
	 * TO remove the topmost element of stack
	 * If all the elements of the stack have been popped, delete that stack and reduce the stackCount
	 */
	public int pop()
	{
		
		//Get the stack that is currently being filled
		Stack last = getLastStack();
		
		//Pop and store its topmost element in a variable
		int pop = last.pop();
		
		//If the element being popped was the last element of the stack, remove the stack from the arraylist
		if( last.size == 0 )
		{
			stacks.remove( stacks.size() - 1 );
			
			//Decrement the stack counter
			stackCount--;
			
			System.out.println("Current Stack in operation"+stackCount);
		}
		
		return pop;
	}
	
	
	//To return the last stack in the set of stacks
	public Stack getLastStack()
	{
		if( stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
		
	
	//Driver Function
	public static void main(String[] args) 
	{
		SetOfStacks set = new SetOfStacks();
		
		set.push(5);set.push(5);set.push(7);
		set.push(8);set.push(5);set.push(5);
		set.push(5);set.push(5);set.push(7);
		set.push(8);set.push(7);set.push(8);
		
		set.pop();set.pop();
		System.out.println(set.pop());
	}
}
