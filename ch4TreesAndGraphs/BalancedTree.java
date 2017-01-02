/*
 * To check whether a given tree is balanced or not
 * Depth : The number of links it takes to reach a given node from the root node 
 * Depth is also equal to the level at which the node is present
 */

package ch4TreesAndGraphs;

public class BalancedTree
{
	public class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}
	

	/*
	 * To find the maximum depth of the entire tree
	 * Recursively find max depth from the right and left subtrees
	 */
	public int maxDepth(Node root)
	{
		if( root == null )
			return -1;
		
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	
	/*
	 * To find the minimum depth of the entire tree
	 * Recursively find min depth from the right and left subtrees
	 */
	public int minDepth(Node root)
	{
		if( root == null )
			return 0;
		
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	
	/*
	 * To check whether the given tree is balanced or not
	 * If the difference between the maximum depth and minimum depth of the tree is greater than 1, then the tree is not balanced
	 */
	public boolean isBalanced(Node root)	
	{
		if( root == null )
		{
			System.err.println("Error: Tree is not defined");
			return false;
		}
		
		return (maxDepth(root) - minDepth(root)) <= 1 ;
	}
	
	//Function to initialize the tree
	public Node createTree()
	{
		Node root = new Node(40);
		
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node45 = new Node(45);
		Node node59 = new Node(59);
		Node node35 = new Node(35);
		Node node29 = new Node(29);
		Node node045 = new Node(45);
		Node node029 = new Node(29);
		Node node37 = new Node(37);
		
		root.left = node10;
		root.right = node20;
		
		node10.left = node30;
		node30.left = node45;
		node20.left = node59;
		node20.right = node35;
		node35.right = node029;
		node029.left = node045;
		node029.right = node37;
		node045.left = node29;
		return root;
	}
	
	
	
	//Driver Function
	public static void main(String[] args)
	{
		BalancedTree tree = new BalancedTree();
		Node root = tree.createTree();
		
		System.out.println("Is the given tree balanced ? \n"+( tree.isBalanced(root) ? "Yes":"No"));
		System.out.println("MaxDepth :"+tree.maxDepth(root));
		System.out.println("MinDepth :"+tree.minDepth(root));
	}
}
