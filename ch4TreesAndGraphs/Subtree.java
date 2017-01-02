/*
 * To check whether a given tree is a subtree of another tree
 * The bigger tree contains more than a million nodes
 */

package ch4TreesAndGraphs;


public class Subtree
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
	 * To check whether a given tree is a subtree of another tree
	 */
	public boolean containsTree( Node root1, Node root2)
	{
		/*
		 * If the second tree is not defined, then by default it is a subtree of the first
		 * If not, Check to find the node in first tree which matches with the root node of the second tree
		 */
		if( root2 == null )
			return true;
		else
			return subTree(root1, root2);
	}
	
	
	/*
	 * TO find a node in 1st tree which is the same as the root node of the second tree
	 */
	public boolean subTree(Node root1, Node root2)
	{
		//If the first tree is not initialized, return false (NO subtree is possible) 
		if( root1 == null )
			return false;
		
		/*
		 * If a node in First tree matches with root node of second tree, then there is a possiblity that t2 is subtree of t1
		 * Check and compare individual nodes of both the trees
		 */
		if( root1.data == root2.data )
			if( matchTree(root1, root2) )
				return true;
		
		//Keep on recursing untill you find a node in tree1 which matches with the rootnode of tree2
		return (subTree(root1.left,root2) || subTree(root1.right, root2));
	}
	
	/*
	 * To compare individual nodes of both the trees
	 * If all the nodes starting from a specific node in tree1 matches with all the nodes starting from rootnode in tree2
	 * Then tree2 is a subtree of tree1
	 */
	public boolean matchTree(Node root1, Node root2)
	{
		//YOu have reached the end of both the trees simultaneously
		if( root2 == null && root1 == null )
			return true;
		//If both the trees don't reach null at the same time, tree2 cannot be a subtree of tree1
		if( root1 == null || root2 == null )
			return false;
		
		//If the data in tree1 does not match with the corrosponding data elements in tree2: not a subtree
		if( root1.data != root2.data )
			return false;
		
		//Keep recursing and matching corrosponding elements in both the trees untill you reach their end 
		return (matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right));
	}
	
	
	/*
	 * To create 1st tree
	 */
	public Node createTree1()
	{
		Node rootNode1 = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node25 = new Node(25);
		Node node35 = new Node(35);
		
		rootNode1.left = node20;
		rootNode1.right = node60;
		
		node20.left = node10;
		node20.right = node30;
		node60.left = node50;
		node60.right = node70;
		node30.left = node25;
		node30.right = node35;
		
		return rootNode1;
	}
	
	
	/*
	 * To create 2nd tree
	 */
	public Node createTree2()
	{
		Node rootNode2 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		
		rootNode2.left = node50;
		rootNode2.right = node70;
		
		return rootNode2;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		Subtree sub = new Subtree();
		
		Node t1 = sub.createTree1();
		Node t2 = sub.createTree2();
		
		System.out.println("Is tree 2 a subtree of tree 1? \n"+(sub.containsTree(t1, t2)? "Yes":"No"));
	}
}
