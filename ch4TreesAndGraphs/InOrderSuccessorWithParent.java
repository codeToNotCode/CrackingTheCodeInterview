/*
 * TO find the in-order successor of a given node in a BST
 * In this solution we will modify the tree data stucture by adding an instance of the parent
 * For every node, you have to initialize its parent element too while creating the tree
 * Time Complexity - O(h) where h = height of the tree h = log n
 */

package ch4TreesAndGraphs;


public class InOrderSuccessorWithParent
{
	public class Node
	{
		int data;
		Node left;
		Node right;
		Node parent;	//add parent node too
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	/*
	 * Function to find the in-order successor of a given node when parent node exists
	 */
	public Node inOrderSuccessor(Node root, int data)
	{
	
		//Find the node to which the given data corrosponds
		Node currentNode = find(root,data);
		if ( currentNode == null )
		{
			System.err.println("Error: Data not present in the tree");
			return null;
		}
		
		/*
		 * If the entered data is the largest element of the tree
		 * Since it is a BST, the largest element will also be the rightmost element
		 * Hence the last element in the BST
		 * Therefore no successor for this node
		 */
		if( currentNode == getMax(root) )
		{
			System.err.println("Error: Data is the last element of the tree: NO successor ahead");
			return null;
		}
	
		//Declare a node to store the parent of the current Node
		Node par;
		
		/*
		 * Case 1 : If the given node has a right subtree
		 * Then the successor element will be the leftmost element in that right subtree
		 * The leftmost element of any subtree in a BST is also the minimum element of the BST
		 * Hence the successor node in this case will be the minimum element of the right subtree of the currentNode
		 */
		if( currentNode.right != null)
			return getMin(currentNode.right);
		
		/*
		 * Case 2 : If the given node has no right subtree
		 * Get the parent node of the currentNode element
		 * If the currentNode is to the left of the parent, then the parent node will be its successor node
		 * Else, keep on moving up in the heirarchy untill the currentnode is to the left of the parent node
		 */
		else
		{
			//Store the parent node of the currentNode in a new node
			par = currentNode.parent;
			
			//Keep on going up in the heirarchy until you reach the root node
			while( par != null )
			{
				/*
				 * If the currentnode is to the left of the parent node
				 * You found the successor
				 * break from the loop
				 */
				if ( par.left == currentNode)
					break;
				
				/*
				 * If not, update the currentnode
				 * update the parent node
				 * Repeat the loop
				 */
				currentNode = par;
				par = par.parent;
			}
		}
		//Return the successor
		return par;
	}
	
	/*
	 * To return the maximum (rightmost) node of the BST
	 */
	public  Node getMax( Node root)
	{
		while( root.right != null )
			root = root.right;
		return root;
	}

	
	/*
	 * To return the minimum (leftmost) node of the BST
	 */
	public Node getMin( Node root)
	{
		while ( root.left != null )
			root = root.left;
		
		return root;
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
		rootNode.parent = null;
		
		
		node20.left = node10;
		node20.right = node30;
		node20.parent = rootNode;
		
		node60.left = node50;
		node60.right = node70;
		node60.parent = rootNode;
		
		node30.left = node25;
		node30.right = node35;
		
		node25.parent = node35.parent = node30;
		node10.parent = node30.parent = node20;
		node50.parent = node70.parent = node60;
		
		return rootNode;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		InOrderSuccessorWithParent inOrd = new InOrderSuccessorWithParent();
		Node root = inOrd.createTree();
		
		Node successor = inOrd.inOrderSuccessor(root, 34);
		if ( successor != null )
			System.out.println("In order Successor of [35] is : "+successor.data);
	}
}
