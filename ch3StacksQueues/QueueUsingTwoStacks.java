/*
 * To implement Queue data structure using Two Stacks
 */


package ch3StacksQueues;
import java.util.Stack;


public class QueueUsingTwoStacks 
{
	
	Stack<Integer> oldStack ;
	Stack<Integer> newStack ;
	private int topElement;
	
	public QueueUsingTwoStacks()
	{
		oldStack = new Stack<Integer>();
		newStack = new Stack<Integer>();
		topElement = -1;
	}
	
	/*
	 * To check whether the Queue is empty or not
	 * Queue will be empty if both the stacks are empty
	 */
	public boolean isEmpty()
	{
		return  ( oldStack.isEmpty() && newStack.isEmpty() );
 	}
	
	/*
	 * Enqueue operation
	 * Push elements only to the newStack
	 */
	public void enqueue(int data)
	{
		newStack.push(data);
	}
	
	
	/*
	 * Dequeue Operation
	 * To remove the element from the queue, perform pop() operation from the oldStack
	 * If oldStack is empty, copy all contents from newStack to oldStack
	 * pop from oldStack
	 */
	public int dequeue()
	{
		topElement = -1;
		
		//If old stack is empty, copy contents of newStack one by one onto the old stack
		if( oldStack.isEmpty())
			while ( !newStack.isEmpty())
				topElement = oldStack.push(newStack.pop());

		//If old stack is not empty, pop out elements from the top of oldStack
		if( !oldStack.isEmpty() )
			topElement =  oldStack.pop();
		
		//Return the dequeued element
		return topElement;
	}
	
	/*
	 * To return the number of elements present in the Queue
	 */
	public int size()
	{
		return (oldStack.size() + newStack.size());
	}
	
	
	//Driver Function
	public static void main(String[] args) 
	{
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		
		System.out.println("IS the queue empty?  "+queue.isEmpty());
		
		queue.enqueue(10);
		System.out.println("Enqueued ["+10 +"] into the queue");
		queue.enqueue(20);
		System.out.println("Enqueued ["+20 +"] into the queue");
		
		System.out.println("\nSize of the Queue : "+queue.size());
		
		
		System.out.println("Dequeued ["+ queue.dequeue() +"] from the queue ");
		System.out.println("Dequeued ["+ queue.dequeue() +"] from the queue ");
		
		queue.enqueue(30);
		System.out.println("Enqueued ["+30 +"] into the queue");
		queue.enqueue(40);
		System.out.println("Enqueued ["+40 +"] into the queue");
		
		System.out.println("\nSize of the Queue : "+queue.size());
		
		System.out.println("Dequeued ["+ queue.dequeue() +"] from the queue ");
		
		System.out.println("Dequeued ["+ queue.dequeue() +"] from the queue ");
	
		System.out.println("\nSize of the Queue : "+queue.size());
		
	}
}
