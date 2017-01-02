/*
 * To create a Tree with minimal height from a sorted Array
 */

package ch4TreesAndGraphs;

public class ArrayToTree
{
	public class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	/*
	 * To convert a given sorted array into a binary tree of minimal height
	 * A binary tree with minimal height will be a BST
	 * Since the array is already sorted: make the middle element of the array as the root node of the tree
	 * Recurse the left half of the array and keep on adding elements as nodes in the same way
	 * Recurse the right half of the array and keep on adding elements as nodes in the same way
	 */
	public Node arrayToTree(int arr[], int start , int end)
	{
		//base condition for recursion
		if ( start > end )
			return null;
		
		//Find the middle index of the array
		int mid = ( start + end )/2;
		
		//Create a newNode with the middle element as the root
		Node newNode = new Node(arr[mid]);
		
		//Recurse the left half of the array and assign it as the left subtree
		newNode.left = arrayToTree(arr, start, mid - 1 );
		
		//Recurse the left half of the array and assign it as the left subtree
		newNode.right = arrayToTree(arr, mid + 1 , end );
		
		//Return the root node of the new tree
		return newNode;
	}
	
	/*
	 * Using Pre-Order Traversal to display the BST
	 */
	public void displayTree(Node root)
	{
		if( root == null )
			return;
		
		System.out.print(root.data+" ");
		displayTree(root.left);
		displayTree(root.right);
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,4};
		
		ArrayToTree tree = new ArrayToTree();
		
		Node newTreeRoot = tree.arrayToTree(arr, 0, arr.length - 1);
		
		tree.displayTree(newTreeRoot);
	}
}
