/*
 * To convert all nodes at a particular level to individual linked lists
 * If there are D levels in a tree, then there will be D separate linked lists
 * One for each level
 * 
 * We will perform a Level Order (BFS) traversal of the tree and keep track of each level
 * Add elements to the linked list as we are goin through the nodes of a particular level
 */

package ch4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelToLinkedList
{
	public class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node(int d)
		{
			data = d;
			left = null;
			right = null;
		}
	}
	
	
	/*
	 * Function to store each level nodes into a new Linked list
	 */
	public ArrayList<LinkedList<Node>> levelToList(Node root)
	{
		//Declare a variable to keep track of levels of the tree
		int level = 0;
		
		//Create an ArrayList of LinkedLists
		ArrayList<LinkedList<Node>> arrayOfLists = new ArrayList<LinkedList<Node>>();
		
		/*
		 * Create the First linked list containing only one node :the root of the tree
		 * Add this list to the ArrayList as the first element
		 */
		LinkedList<Node> llist = new LinkedList<Node>();
		llist.add(root);
		arrayOfLists.add(level,llist);
		
		//Keep executing the loop until you reach the bottommost level in the tree (break)
		while(true)
		{
			//Create a new linked list for every new level
			llist = new LinkedList<Node>();
			
			//Run the loop for a particular level
			for(int i = 0 ; i < arrayOfLists.get(level).size(); i++ )
			{
				/*
				 * Get the node which has been already stored in the arraylist's linked list
				 * For the First iteration: it will return the root node
				 */
				Node currentNode = arrayOfLists.get(level).get(i);
				
			
				if( currentNode != null )
				{
					//Add the children of the current node to the linked lists
					if( currentNode.left != null )
						llist.add(currentNode.left);
					if( currentNode.right != null )
						llist.add(currentNode.right);
				}
			}
			/*
			 * If children of the current node were added to the linkedlist: its size would be greater than 0
			 * Add the linked list to the next element of the ArrayList
			 * Else You reached the last level in the tree, break out
			 */
			if( llist.size() > 0 )
				arrayOfLists.add(level + 1 , llist );
			else
				break;
			
			//Go to the next level of the tree
			level++;
		}
		//Return the arrayList of Linked Lists
		return arrayOfLists;
	}
	
	//To create and initialize the tree
	public Node createTree()
	{
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node6.left = node8;
		node7.right = node9;
		
		return node1;
	}
	
	//To display elements of the arrayList of LinkedLists
	public void display(ArrayList<LinkedList<Node>> arrayOfLists)
	{
		
		for( int i = 0 ; i < arrayOfLists.size(); i++ )
		{
			System.out.print("Level ["+i+"] contains :");
			for(int j = 0; j < arrayOfLists.get(i).size(); j++ )
			{
				System.out.print(" "+arrayOfLists.get(i).get(j).data);
			}
			
			System.out.println();
		}
		
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		LevelToLinkedList levelList = new LevelToLinkedList();
		
		Node root = levelList.createTree();
		
		ArrayList<LinkedList<Node>> arrayOfLists = levelList.levelToList(root);
		
		levelList.display(arrayOfLists);
	}
}
