/*
 * Remove duplicates from a linked list using a buffer
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
	public void removeDups(Node traverse)
	{
		//Create a hashtable with key-value pair of value-Visited
		Hashtable table = new Hashtable();
		
		Node previous = null;
		
		while ( traverse != null )
		{
			if( table.containsKey(traverse.data))
			{
				previous.next = traverse.next;
			}
			else
			{
				table.put(traverse.data, true);
				previous = traverse;
			}
			
			traverse = traverse.next;
		}
	}
}

public class removeDuplicates 
{

	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();
		
		llist.push(1);
		llist.push(2);
		llist.push(2);
		llist.push(3);
		llist.push(1);
		llist.push(4);
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.push(4);
		llist.push(1);
		
		llist.display(llist.head);
		System.out.println();
		llist.removeDups(llist.head);
		llist.display(llist.head);

	}
}
