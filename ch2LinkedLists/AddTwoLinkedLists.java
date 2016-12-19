/*
 * Adds two given linked lists and stores the result in a new list
 */

package ch2LinkedLists;

public class AddTwoLinkedLists 
{

	Node head;

	class Node
	{
		int data;
		Node next;
	
		Node(int d)
		{
			data = d;
			next = null;
		}
	}


	//Insert nodes into linked list
	public void push(int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = head;
		
		head = new_node;
	}
	
	
	/*
	 * To add two given linked lists
	 * input - Two linked lists with their heads passed as arguments
	 * Output - Head of the resultant linked list
	 */
	public Node addTwoLists(Node first, Node second)
	{
		//Create nodes that will form the resultant linked list
		Node result = null, prev = null, temp = null;
		
		//Declare variables to store the sum and carry values
		int carry = 0 , sum = 0;
		
		//Loop stops when either of the given two linked lists goes out of nodes
		while ( first != null || second != null )
		{
			/*
			 * Calculate the sum
			 * If either of the lists go out of nodes, replace the value of null with 0
			 */
			sum = carry + (( first != null ) ? first.data : 0) + (( second != null ) ? second.data : 0);
			
			//If value of the sum calculated is more than 10 , initialize carry to 1 else to 0
			carry = (sum >= 10) ? 1 : 0;
			
			//Reduce the value of sum to a single digit
			sum = sum % 10;
			
			//Use the temporary node to store the value of sum obtained in a Node
			temp = new Node (sum);
			
			/*
			 * If it is the first calculation, ie. the resultant linked list is empty : Make temp the head
			 * else Make the previous's node next point to the new node 
			 */
			if ( result == null )
				result = temp;
			else
				prev.next = temp;
			
			//Move the prev to the new node and repeat the process again
			prev = temp;
			
			//Increment the first and the second Nodes to their respective next elements if they didn't reach their end
			if ( first != null )
				first = first.next;
			if ( second != null )
				second = second.next;
		}
		
		/*
		 * After all nodes have been added, check for the value of carry obtained in the last addition
		 * If the carry is equal to 1 , just create a new node with value 1
		 * Add this new node to the resultant linked list
		 */
		if ( carry == 1 )
			temp.next = new Node(carry);
		
		//return the head of the resultant linked list. In this case, the head is result
		return result;
	}
	//DIsplay linked list
	public void display(Node head)
	{
		Node traverse = head;
		
		if(traverse == null)
			System.out.println("\n EMPTY LIST");
			
		while( traverse!= null)
		{
			System.out.print(" "+traverse.data);
			traverse = traverse.next;
		}
	}
	
	
	public static void main(String[] args) 
	{
		
		//Create a Linked list
		AddTwoLinkedLists llist1 = new AddTwoLinkedLists();
		AddTwoLinkedLists llist2 = new AddTwoLinkedLists();
		AddTwoLinkedLists llist3 = new AddTwoLinkedLists();
						
		//Insert nodes into the list
		llist1.push(6);
		llist1.push(4);
		llist1.push(9);
		llist1.push(5);
		llist1.push(7);
		llist2.push(4);
		llist2.push(8);
		
		//Lists before Addition
		System.out.println("\nList before Addition");
		llist1.display(llist1.head);
		System.out.println();
		llist1.display(llist2.head);
		
		System.out.println("\nList After Addition");
		Node addition = llist3.addTwoLists(llist1.head, llist2.head);

		llist3.display(addition);
				
				
	}

}
