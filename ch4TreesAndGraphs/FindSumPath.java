/*
 * To find all paths in a tree that sum up to a given value
 * Path can start from any level in the tree 
 * Time Complexity - O(nlogn)
 * Space Complexity - O(nlogn)
 */

package ch4TreesAndGraphs;

import java.util.ArrayList;

public class FindSumPath
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
	 * TO find all the paths that lead up to a given sum from any given level
	 * An ArrayList of integers is also passed as an argument to keep on adding elements of the path 
	 */
	public void findSum(Node head, int sum, ArrayList<Integer> buffer, int level)
	{
		//If the head is null, No path exists
		if( head == null )
		{
			System.err.println("Error: No Path exists");
			return;
		}
		
		//Store the required sum in a new variable as the original sum should remain unaltered for each recursive call
		int tmp = sum;
		
		//Add the current node's data to the buffer as a path
		buffer.add(head.data);
		
		// Keep going up in the levels until you reach the head or you reach the desired sum
		for( int i = level; i>-1 ; i--)
		{
			//Subtract the required sum from the element at the present level
			tmp -= buffer.get(i);
			
			//If you reach the desired sum, print the path ( elements of the buffer arraylist)
			if( tmp == 0 )
				print(buffer, i, level);
		}

		/*
		 * Create references of the current path 
		 * c1 - it will contains the paths that are generated from the left subtrees
		 * c2 - it will contains the paths that are generated from the left subtrees
		 */
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		
		//Recursively search for the required sum in the left and right subtrees incrementing the level each time
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}
	
	
	/*
	 * To print the paths formed wrt the required sum
	 */
	public void print(ArrayList<Integer> buffer, int level, int i2)
	{
		for (int i = level; i <= i2 ; i++)
			System.out.println(buffer.get(i) + " ");
		
		System.out.println();
	}
	
	/*
	 * To create a BST
	 */
	public Node createTree()
	{
		Node rootNode = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node25 = new Node(25);
		Node node35 = new Node(35);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left = node10;
		node20.right = node30;
		node60.left = node50;
		node60.right = node70;
		node30.left = node25;
		node30.right = node35;
		
		return rootNode;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		FindSumPath fsp = new FindSumPath();
		Node head = fsp.createTree();
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		
		fsp.findSum(head, 115, buffer, 0);
	}
}
