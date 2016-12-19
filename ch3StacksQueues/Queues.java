/*
 * Implementation of queues using a Linked list
 */

package ch3StacksQueues;

public class Queues 
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
	
	//Two nodes that point to the head and tail of the queue
	Node head;
	Node tail;
	
	//To check whether the queue is empty or not
	public boolean isEmpty()
	{
		return head == null;
	}
	
	//To display the value of the first element in the queue
	public Object peek()
	{
		//Empty Queue check
		if (this.isEmpty())
		{
			System.err.println("Queue is Empty");
			return null;
		}
		
		//If queue is not empty, return value of the first element in the queue
		return head.data;
	}
	
	//To add an element at the end of the queue
	public void enqueue(Object data)
	{
		//Create a new node for the new element that will be added to the queue
		Node newNode = new Node(data);
		
		//Check for empty queue
		if ( this.isEmpty() )
		{
			head = newNode;
		}
		
		//Make the current tail point to the new element that has to be added
		if ( tail != null )
			tail.next = newNode;
		
		//Make the new element as the new tail of the queue
		tail = newNode;
	}
	
	//To remove an element from the begining of the queue
	public Object dequeue()
	{
		//Check for empty Queue
		if ( this.isEmpty() )
		{
			System.err.println("Cannot remove from an Empty Queue");
			return null;
		}
		
		//Store the value of the element that will be dequeued in a variable
		Object dequeuedElement = head.data;
		
		//Remove the head by making it point to its next element
		head = head.next;
		
		//If this results in an empty queue, set tail to null too
		if( head == null )
			tail = null;
		//Return the dequeued element
		return dequeuedElement;
	}
	
	//To display elements of a queue
	public void display(Node head)
	{
		//Store the head in a traverse Node
		Node traverse = head;
		
		//Check for empty queue
		if ( this.isEmpty() )
		{
			System.err.println("Queue is Empty");
			return;
		}
		
		//Traverse the queue until it reaches its end
		while ( traverse!=null)
		{
			System.out.println(traverse.data);
			traverse = traverse.next;
		}
	}
	
	//Driver function
	public static void main(String[] args) 
	{
		Queues queue1 = new Queues();
		queue1.enqueue("Hi");
		queue1.enqueue("My");
		queue1.enqueue("Name");
		queue1.enqueue("is");
		queue1.enqueue("Prasan");
		
		
		System.out.println("Elements of the queue are :\n");
		queue1.display(queue1.head);
		
		System.out.println("Element at the front of the queue :" +queue1.peek());
		System.out.println("Element removed from the queue :"+queue1.dequeue());
		queue1.display(queue1.head);
	}
}
