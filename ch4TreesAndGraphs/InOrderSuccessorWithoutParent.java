/*
 * TO find the in-order successor of a given node in a BST without using the parent element
 * Time Complexity - O(h) where h = height of the tree h = log n
 * Tree data stucture is not modified
 */

package ch4TreesAndGraphs;


public class InOrderSuccessorWithoutParent
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
		 * 
		 */
		else
		{
			/*Create two nodes : successor - The node we have to find
			 * Ancestor : initialized as the root node
			 */
			Node successor = null;
			Node ancestor = root;
			
			//Execute the loop untill you reach the currentNode from the ancestor node
			while ( currentNode != ancestor)
			{
				/*
				 * If the currentNode's data is less than the ancestor : it means that the currentnode is towards the left of the ancestor
				 * Make this ancestor as the successor and proceed to find the next deepest ancestor of the newly found successor
				 * Else update the ancestor to the right subtree and search for the successor there
				 */
				if( currentNode.data < ancestor.data )
				{
					successor = ancestor;
					ancestor = ancestor.left;
				}
				else
					ancestor = ancestor.right;
			}
			
			//Return the successor
			return successor;
		}
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
		InOrderSuccessorWithoutParent inOrd = new InOrderSuccessorWithoutParent();
		Node root = inOrd.createTree();
		
		Node successor = inOrd.inOrderSuccessor(root, 35);
		if ( successor != null )
			System.out.println("In order Successor of [35] is : "+successor.data);
	}
}
