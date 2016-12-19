//To find nth node from the end of the list


package ch2LinkedLists;



public class NthFromEnd {

	
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
	Node head;
	
	public void push(int data)
	{
		
		//Create a new node and assign its data to input
		Node new_node = new Node(data);

	
		//make new node point to the head
		new_node.next = head;
		
		//update head
		head = new_node;
	}

	 
	 	int nthNode(Node head, int n)
	 	{
	 		//Create 2 nodes and initialize both to head
	 		Node traverse = head, main=head;
	 		
	 		int i =1;
	 		
	 		//Move the traverse node untill i == n
	 		while( i++ != n && traverse!=null)
	 			traverse = traverse.next;
	 		
	 		//If value of n is more than the number of nodes present in the list, return -1
	 		if (traverse == null)
	 		{
	 			return-1;
	 		}
	 		
	 		//Move the main node until traverse reaches null
	 		while (traverse.next!= null)
	 		{
	 			main = main.next;
	 			traverse = traverse.next;
	 		}
	 		
	 		return main.data;
	 	}


		//display linked list 
		public void display(Node head)
		{
			Node traverse = head;
			
			if( traverse == null)
			{
				System.out.println("Empty list");
				return;
			}
			else
			{
				while(traverse != null)
				{
					System.out.print(" "+traverse.data);
					traverse = traverse.next;
				}
					
			}
			
		}
		
		
	public static void main(String[] args) {
		
		//Create a linked list
		NthFromEnd llist = new NthFromEnd();
		
		llist.push(3);
		llist.push(3235);
		llist.push(31);
		llist.push(52);
		llist.push(64);
		llist.push(53);
		llist.push(343);
		llist.push(464);
		
		llist.display(llist.head);
		
		int nthNode = llist.nthNode(llist.head, 3);
		
		if( nthNode == -1 )
			System.err.println("\nGiven nth node number is greater than the total number of nodes in the Linked List");
		else
			System.out.println("\n\nNth Node from the end is ::"+nthNode);
		
		
	}

}
