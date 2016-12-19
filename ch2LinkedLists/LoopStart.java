//To detect a loop in the linked list

package ch2LinkedLists;

public class LoopStart 
{
	
	Node head;
	
	class Node
	{
		char data;
		Node next;
		boolean visited;
		
		Node(char d)
		{
			data = d;
			next = null;
		}
	}
	
	//Push a node
	public void push(char data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	
	//Detect a Loop --- Using Floyd's Cyccle Finding Algorithm
	//Traverse Linked List using 2 pointers
	//move slow pointer by 1 and fast pointer by 2
	//If they meet, there is a loop else not
	public void detectLoopFloyd(Node head)
	{
		//Slow and Fast Traverse node
		Node slowTraverse = head, fastTraverse = head;
		
		//Loop condition --- will exit if any of the current pointers is null 
		//Also if fastTraverse's next is null (Coz we are moving fastTraverse by 2, Therefore checking its next as we are skipping it)
		while( fastTraverse!= null  && fastTraverse.next!=null && slowTraverse!=null)
		{
			//Move fast pointer by two nodes
			fastTraverse = fastTraverse.next.next;
			
			//Move slow pointer by 1 node
			slowTraverse = slowTraverse.next;
		
			//If both the pointers are same
			if(slowTraverse == fastTraverse)
			{
	          	System.out.println("Loop In List");
	           	break;
	        }
		}
		
		if( fastTraverse.next == null )
		{
			System.out.println("No loops");
			return;
		}
		
		/*
		 * To find the beginning of the loop, make the slowTraverse to start at head again
		 * Keep fastTraverse at the meeting point
		 * Move both the nodes at the same pace now
		 * They will meet again at the starting point of the loop 
		 */
		slowTraverse = head;
		
		//Loop continues untill both slowTraverse and fastTraverse meet again
		while ( slowTraverse != fastTraverse )
		{
			slowTraverse = slowTraverse.next;
			fastTraverse = fastTraverse.next;
		}
		
		//Loop exits when both meet, so simply return/print any of the nodes data value.
		System.out.println("Begining of the loop is at : "+fastTraverse.data);
	}
	
	
	
	
	//Driver Function
	public static void main(String[] args)
	{
		//Create a Linked list
		LoopStart llist = new LoopStart();
			
		//Insert nodes into the list
		llist.push('A');
		llist.push('B');
		llist.push('C');
		llist.push('D');
		llist.push('E');
		llist.push('F');
		llist.push('G');
				
		/*Create loop for testing */
		llist.head.next.next.next.next = llist.head;
        
		llist.detectLoopFloyd(llist.head);
	}

}
