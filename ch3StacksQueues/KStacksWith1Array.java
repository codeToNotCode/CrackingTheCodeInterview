/*
 * To implement K stacks using 1 array
 */


package ch3StacksQueues;

public class KStacksWith1Array 
{
	/*
	 * Declarations
	 * topOfStack[]  - Contains all the index values of all the topmost elements of all the stacks
	 * stackData[]   - The actual array in which all the stacks are stored
	 * nextIndex[]   - Points to the next available free index in the array
	 * nextAvailable - Next Available index to which an element can be pushed to
	 */
	int topOfStack[];
	int stackData[];
	int nextIndex[];
	int nextAvailable = 0;
	
	public KStacksWith1Array(int numStacks, int capacity)
	{
		
		//topOfStack initialized to -1 indicating that all the stacks are currently empty and do not have a top element
		topOfStack = new int[numStacks];
		for(int i = 0 ; i < topOfStack.length ; i++)
			topOfStack[i] = -1 ;
		
		//All elements of the actual array are by default initialized to 0
		stackData = new int[capacity];
		
		//The elements of nextIndex array are initialized as 1 2 3 4 5 -1 
		//First element pointing to the next available free index in the stackData array
		nextIndex = new int[capacity];
		for(int i = 0 ; i < nextIndex.length - 1 ; i++)
			nextIndex[i] = i + 1 ;
		nextIndex[nextIndex.length - 1] = -1 ;
	}
	
	//To check whether the stack number provided is valid or not
	public boolean isInvalidStack(int stack)
	{
		return (stack < 0 || stack >= topOfStack.length);
	}
	
	//To check whether the Array is full or not: Whether a push operation can be performed
	public boolean isArrayFull()
	{
		return nextAvailable < 0 ;
	}
	
	//To push an element onto a given stack
	public void push(int stack, int value)
	{
		//Check for invalid stack
		if ( isInvalidStack(stack))
		{
			System.err.println("Error: Requested stack["+stack+"] does not exist");
			return;
		}
		
		//Check for a Full Array
		if ( isArrayFull() )
		{
			System.err.println("Error: Array is full- Cannot Perform Push operation");
			return;
		}
		
		//Put the value of nextAvailable index onto which new value can be pushed into a new variable
		int currentIndex = nextAvailable;
		
		//Update the nextAvailable 
		nextAvailable = nextIndex[currentIndex];
		
		//Push the new value onto the mentioned index position
		stackData[currentIndex] = value;
		
		//Store the previous top of the stack in consideration
		nextIndex[currentIndex] = topOfStack[stack];
		
		//update the topOfStack to its new index
		topOfStack[stack] = currentIndex;
	}
	
	//To check whether the Stack is empty or not: Whether a pop operation can be performed
	public boolean isStackEmpty(int stack)
	{
		return ( topOfStack[stack] < 0 );
	}
	
	//To pop an element from a given stack
	public int pop(int stack)
	{
		//Check for invalid stack
		if ( isInvalidStack(stack))
		{
			System.err.println("Error: Requested stack["+stack+"] does not exist");
			return 0;
		}
		
		//Check whether the given stack is empty
		if ( isStackEmpty(stack) )
		{
			System.err.println("Error: Stack["+stack+"] is Empty - Cannot Perform Pop operation");
			return 0;
		}
		
		//Store the index value of the current top element of the given stack in a new variable
		int currentIndex = topOfStack[stack];
		
		//Store the value of the current top element of the given stack in a new variable
		int value = stackData[currentIndex];
		
		//Now that the topmost element has been popped off the stack, update topOfStack
		topOfStack[stack] = nextIndex[currentIndex];
		
		//Update the next index that is now available because of the pop operation
		nextIndex[currentIndex] = nextAvailable;
		
		//Similarly update the nextAvailable 
		nextAvailable = currentIndex;
		
		//Return the value of the element that has just been popped off the given stack
		return value;
 	}
	
	//To display the requested stack
	public void display(int stack)
	{
		//Check for invalid stack
		if ( isInvalidStack(stack))
		{
			System.err.println("Error: Requested stack["+stack+"] does not exist");
			return;
		}
		
		//Check whether the given stack is empty
		if ( isStackEmpty(stack) )
		{
			System.err.println("Error: Stack["+stack+"] is Empty - Cannot Display");
			return;
		}
		
		//Store the index of the topmost element of the given stack in a new variable
		int currentIndex = topOfStack[stack];
		
		//Traverse the loop until the nextIndex points to -1 - meaning the stack gets empty
		while( nextIndex[currentIndex] != -1 )
		{
			System.out.println(stackData[currentIndex]);
			currentIndex = nextIndex[currentIndex];
		}
		
		//For the last element when nextIndex points to -1
		System.out.println(stackData[currentIndex]);
		
	}
	
	//Driver function for the program
	public static void main(String args[])
	{
		KStacksWith1Array kStacks = new KStacksWith1Array(3, 10);
		
		kStacks.push(0,1);		kStacks.push(0,2);		kStacks.push(1,15);
		kStacks.push(1,25);		kStacks.push(2,6);		kStacks.push(2,16);
		kStacks.push(2,26);		kStacks.push(2,36);		kStacks.push(1,35);
		kStacks.push(0,4);
		
		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);		
		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);
		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);		
		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);
		
		System.out.println("Elements of the First stack :");
		kStacks.display(0);
		
		System.out.println("\nElements of the Second stack :");
		kStacks.display(1);
		
		System.out.println("\nElements of the Third stack :");
		kStacks.display(2);
	}
}
