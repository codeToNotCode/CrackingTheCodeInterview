/*
 * To implement stacks as a pile of plates
 * Now pop function can happen from any of the stacks formed
 * If element gets popped from 1st stack, all the elements from subsequent stacks would rollover to fill that spot
 * Rest of the functionality remains the same
 */


package ch3StacksQueues;

import java.util.ArrayList;


/*
 * A class that maintains an Arraylist of all the stacks that are created
 * A Constructor
 * getLastStack()
 * push(), pop() , popAt() , leftShift(), display(), main()
 */
public class SetOfStacksFollowUp 
{
	//List of all the stacks 
	ArrayList<newStack> stacks = new ArrayList<newStack>();
	
	//Maximum number of elements a particular stack can hold
	public int capacity;
	
	public SetOfStacksFollowUp(int capacity)
	{
		this.capacity = capacity;
	}
	
	//Return the previous stack that is not completely full
	public newStack getLastStack()
	{
		//If no stacks avaialble , return null
		if( stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
	
	//To push elements onto the stack
	public void push(int data)
	{
		
		//Obtain the last stack that was being filled before the push operation
		newStack last = getLastStack();
	
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
			newStack newStack = new newStack(3);
			
			//Push the data onto the new Stack
			newStack.push(data);
			
			//Add the new stack into the arraylist
			stacks.add(newStack);
		}
	}
	
	
	//To remove the topmost element from the last stack that was added to the arraylist
	public int pop()
	{
		//Get the last stack from which the element has to be popped off
		newStack last = getLastStack();
		
		//Store the element that has to popped in a new variable
		int pop = last.pop();
		
		//If after the pop operation, the stack has no more elements: Remove that stack from the arraylist
		if(last.size == 0)
			stacks.remove(stacks.size() - 1);
		
		//Return the popped element
		return pop;
	}
	
	//To remove the topmost element from any given stack
	public int popAt(int index)
	{
		//A call to leftShift function which removes the topmost element of the mentioned stack and also takes care of rollover
		return leftShift(index, true);
	}
	
	
	/*
	 * To remove the topmost element of the given Stack
	 * Adjust all the subsequent stacks so that the empty space is filled 
	 */
	public int leftShift(int index, boolean removeTop)
	{
		//Get the particular stack from the arraylist from which an element has to be popped off
		newStack stack = stacks.get(index);
		
		//Create a variable to store the removed element
		int removed_item;
		
		/*
		 * Remove the topmost element of the mentioned stack
		 * If the stack from which the element is being removed is not the last stack
		 * Perform rollover with the help of recursion : remove the bottomost element and push it to the previous stack
		 */
		if(removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		
		/*
		 * If the element being removed was the last element of the stack, delete the stack from the arraylist
		 * Else carry out the recursion process
		 */
		if(stack.isEmpty())
		{
			stacks.remove(index);
		}
		//Base condition for the recursion to end
		else if( stacks.size() > index + 1)
		{
			int data = leftShift( index + 1, false);
			//Push the bottomost element of the current stack to the top of the previous stack
			stack.push(data);
		}
		
		//Return the popped element
		return removed_item;
	}
		
	
	//TO display all the stacks and their elements 
	public void display()
	{
		for(int i = 0 ; i < stacks.size() ; i++)
		{
			System.out.println("\nContents of stack["+i+"] :");
			if ( stacks.get(i).isEmpty() )
			{
				System.err.println("EMPTY STACK");
				return;
			}
				
			while ( stacks.get(i).top != null )
			{
				System.out.println(stacks.get(i).top.data);
				stacks.get(i).top = stacks.get(i).top.below;
			}
		}
	}
	
	
	//Driver Function
	public static void main(String[] args) 
	{
		SetOfStacksFollowUp set = new SetOfStacksFollowUp(3);
		
		set.push(5);set.push(4);set.push(5);set.push(12);set.push(14);
		set.push(15);set.push(544);set.push(352);set.push(253);set.push(2415);
	
		set.popAt(0);
		set.display();
	}
}


/*
 * Class to maintain individual stacks
 * instead of top, we have below and above nodes
 * Functions:
 * isAtCapacity(), join(), push(), pop(), isEmpty(), removeBottom()
 */ 
class newStack
{
	class Node
	{
		int data;
		Node below,above;
		
		public Node ( int d)
		{
			data = d;
			below = null;
			above = null;
		}
	}
	
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	//Constructor that initializes the capacity of the stack
	public newStack(int capacity)
	{
		this.capacity = capacity;
	}
	
	//Checks whether the mentioned stack is full or not
	public boolean isAtCapacity()
	{
		return capacity == size;
	}
	
	
	/*
	 * To link the current node with the next and previous nodes
	 * Acts as a Doubly linked list
	 */
	public void join(Node above, Node below)
	{
		if(below != null )
			below.above = above;
		if(above!= null)
			above.below = below;
	}
	
	
	//To push elements onto the stack
	public boolean push(int data)
	{
		//Increment the number of elements in the current stack
		size++;
		Node newNode = new Node(data);
		
		//If its the first element that is being added to the stack, initialize bottom to the newNode
		if( size == 1 )
			bottom = newNode;
		
		//Set the above and below pointers of the newNode that is being added to the stack
		join(newNode, top);
		
		//Initialize the top node as the newNode that is being added
		top = newNode;
		
		return true;
	}
	
	
	//To remove the topmost element from the last stack in the arraylist
	public int pop()
	{
		//Remove the current top and assign it to a new variable
		Node pop = top;
		
		//Update the new top
		top = top.below;
		
		//Decrement the size of the stack
		size--;
		
		//Return the popped Element
		return pop.data;
	}
	
	
	//TO check if the current stack is empty or not
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	
	/*
	 * One of the Steps for rollover
	 * Remove the bottommost element of the current stack
	 * Same as pop - just happens at the bottom of the stack rather than the top
	 */
	public int removeBottom()
	{
		//Remove the current bottom element of the stack and store in a variable
		Node b = bottom;
		
		//Make the second element as the new bottom
		bottom = bottom.above;
		
		//If the stack is not empty, make the below pointer of the bottom node as null
		if( bottom!=null)
			bottom.below = null;

		//After successful popping of the bottom element, decrement the size of the stack
		size--;
		
		//Return the element that has been removed from the stack
		return b.data;
	}
}
