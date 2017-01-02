/*
 * TO find the first common ancestor of any two given nodes in a tree without altering the tree data structure
 * This algorithm is good because it visits the required nodes only once
 * Not all the nodes of the tree are visited
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

package ch4TreesAndGraphs;

import java.util.Stack;

public class FirstCommonAncestorStack
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
	 * Function to find the first common ancestor of any two given nodes in a tree 
	 * First store the paths to the given nodes in two separate stacks
	 * Then, repeatedly pop the top of both the stacks
	 * If both the top elements are same, store it in a variable and keep popping until both the tops are different
	 */
	public Node firstCommonAncestor(Node root, Node node1 , Node node2)
	{
		//If both the nodes are same, you already have an ancestor. return
		if( node1.equals(node2))
			return node1;
		
		//Store the paths of both the nodes in their respective stacks
		Stack<Node> pathToNode1 = pathTo(root, node1);
		Stack<Node> pathToNode2 = pathTo(root, node2);
		
		/*
		 * If either of the stacks is empty
		 * Node is not present in the tree
		 * Return null
		 */
		if( pathToNode1 == null || pathToNode2 == null )
			return null;
		
		//Declare a node to store the ancestor
		Node ancestor = null;
		
		/*
		 * Keep popping from both the stacks untill both the stacks are empty
		 * Or the popped elements are different from both the stacks : break
		 */
		while( !pathToNode1.isEmpty() && !pathToNode2.isEmpty() )
		{
			Node s1 = pathToNode1.pop();
			Node s2 = pathToNode2.pop();
			
			if( s1.equals(s2))
				ancestor = s1;
			else 
				break;
		}
		
		//return the common ancestor
		return ancestor;
	}
	
	
	/*
	 * To store path from the root to the given node in a stack
	 */
	public Stack<Node> pathTo(Node root, Node node)
	{
		//Return null if the tree is not been initialized
		if( root == null )
			return null;
		
		//If the given node is equal to the root node, push the root to the stack and return
		if( root.equals(node))
		{
			Stack<Node> s = new Stack<Node>();
			s.push(root);
			return s;
		}
		
		//Look for the element in the left subtree
		Stack<Node> left = pathTo(root.left, node);
		
		//Look for the element in the right subtree
		Stack<Node> right = pathTo(root.right, node);
		
		//push the node to the stack in accordance with the subtree it was found in
		if( left != null )
		{
			left.push(root);
			return left;
		}
		if( right != null )
		{
			right.push(root);
			return right;
		}
		
		//No path found
		return null;
	}
	
	/*
	 * To find the node which corrosponds to the given data elemen
	 */
	public Node find(Node root, int data)
	{
		if ( root == null )
			return null;
		
		if( root.data > data )
			return find( root.left, data);
		if( root.data < data )
			return find( root.right, data);
		
		return root;
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
		FirstCommonAncestorStack fca = new FirstCommonAncestorStack();
		Node root = fca.createTree();
		int data1 = 10;
		int data2 = 20;
		
		//Find the node to which the given data corrosponds
		Node node1 = fca.find(root,data1);
		if ( node1 == null )
			System.err.println("Error: ["+data1+"] not present in the tree");
		
		Node node2 = fca.find(root,data2);
		if ( node2 == null )
			System.err.println("Error: ["+data2+"] not present in the tree");
		
		Node commonAncestor = fca.firstCommonAncestor(root, node1,node2);
		if ( commonAncestor != null )
			System.out.println("The first common ancestor of the given nodes is : "+commonAncestor.data);
	}
}
