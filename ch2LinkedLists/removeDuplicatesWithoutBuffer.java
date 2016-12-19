/*
 * Remove duplicates from a linked list without using a buffer
 */

package ch2LinkedLists;

import java.util.Hashtable;


class LinkedList
{

class Node
{
	int data;
	Node next;
	
	public Node(int d)
	{
		data = d;
		next = null;
	}
}
	Node head;
	
	public void push(int d)
	{
		Node newNode = new Node(d);
				
		newNode.next = head;
		head = newNode;
	}
	
	public void display(Node head)
	{
		Node traverse = head;
		
		if( traverse == null)
		{
			System.err.println("Cannot Display an Empty List");
		}

		while( traverse != null )
		{
			System.out.print(" "+traverse.data);
			traverse = traverse.next;
		}
	}
	
	/*
	 * Method to remove duplicates from a linked list
	 * Input - Unsorted Linked list with duplicate elements
	 * Output - Unsorted Linked List with NO duplicate elements
	 */
	public void removeDups(Node head)
	{
		//Check for empty list
		if ( head == null )
			return;
		
		//Create two nodes pointing to first and the second node
		Node previous = head;
		Node current = previous.next;
		
		//Outer loop that runs until current node reaches null
		while ( current != null )
		{
			/*
			 * Create a new node to check duplicates leading upto current
			 */
			Node runner = head;
			
			//Inner loop that runs until runner catches up with current node
			while ( runner != current )
			{
				if( runner.data == current.data )
				{
					/*
					 * Create a temp node to remove the current duplicate
					 * It is the next node that current points to in the LL
					 * current node is skipped 
					 */
					Node temp = current.next;
					
					//Change previous node's next pointer
					previous.next = temp;
					
					//Change the value of the new current as the next element in the LL
					current = temp;
					
					/*
					 * All other duplicates uptil this node have already been removed
					 * Exit from the inner loop
					 */
					break;
				}
				
				//Increment the runner node
				runner = runner.next;
			}
			
			/*
			 * If runner catches up with the current node
			 * increment current to the next node and run the loop again
			 * runner will be again initialized to head
			 */
			if( runner == current )
			{
				previous = current;
				current = current.next;
			}
		}
	}
}

public class removeDuplicatesWithoutBuffer
{

	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();
		
		llist.push(1);		llist.push(2);
		llist.push(2);		llist.push(3);
		llist.push(1);		llist.push(4);
		llist.push(1);		llist.push(3);
		llist.push(1);		llist.push(4);
		llist.push(1);		llist.push(1);
		llist.push(3);		llist.push(1);
		llist.push(4);		llist.push(1);
		
		llist.display(llist.head);
		System.out.println();
		llist.removeDups(llist.head);
		llist.display(llist.head);

	}
}
