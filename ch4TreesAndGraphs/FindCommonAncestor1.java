/*
 * TO find the first common ancestor of any two given nodes in a tree without altering the tree data structure
 * This algorithm is inefficient because it visits the most of the nodes multiple times
 */

package ch4TreesAndGraphs;

public class FindCommonAncestor1
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
	 */
	public Node firstCommonAncestor(Node root, Node node1 , Node node2)
	{
	
		if( isAChild( root.left, node1) && isAChild( root.left, node2))
			return firstCommonAncestor(root.left, node1, node2);
		if( isAChild( root.right, node1) && isAChild( root.right, node2))
			return firstCommonAncestor(root.right, node1, node2);
		
		return root;
	}
	
	/*
	 * To check whether the given node is a child of the root node
	 */
	public boolean isAChild(Node root, Node node)
	{
		if ( root == null )
			return false;
		if ( root == node)
			return true;
		
		return isAChild(root.left, node) || isAChild(root.right,node);
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
	 * Parent node also gets initialized here
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
		FindCommonAncestor1 fca = new FindCommonAncestor1();
		Node root = fca.createTree();
		int data1 = 60;
		int data2 = 70;
		
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
