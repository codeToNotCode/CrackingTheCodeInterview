/*
 * TO find the first common ancestor of any two given nodes in a tree
 * In this solution we will modify the tree data stucture by adding an instance of the parent
 * For every node, you have to initialize its parent element too while creating the tree
 */

package ch4TreesAndGraphs;


public class FirstCommonAncestorWithParent
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
	 * Function to find the first common ancestor of any two given nodes in a tree when parent node exists
	 * Find at what levels are the given two nodes
	 * If they are on the same level : simply go up in the tree untill there parents intersect
	 * If not : bring both the nodes to the same level in the tree and repeat the above step
	 */
	public Node firstCommonAncestor(Node root, int data1 , int data2)
	{
	
		//Find the node to which the given data corrosponds
		Node node1 = find(root,data1);
		if ( node1 == null )
		{
			System.err.println("Error: ["+data1+"] not present in the tree");
			return null;
		}
		Node node2 = find(root,data2);
		if ( node2 == null )
		{
			System.err.println("Error: ["+data2+"] not present in the tree");
			return null;
		}
		
		//Find the level at which both the given nodes are
		int level1 = findLevel(root,node1);
		int level2 = findLevel(root,node2);
		
		//If the nodes are at different levels in the tree, bring them to the same level
		while( level1 != level2 )
		{
			if ( level1 > level2)
			{
				level1--;
				node1 = node1.parent;
			}
			else
			{
				level2--;
				node2 = node2.parent;
			}
		}
		
		/*
		 * Create two parent nodes corrosponding to the given two nodes
		 * Just remove the .parent from both to make the logic same as the other books
		 */
		Node parent1 = node1.parent;
		Node parent2 = node2.parent;
		
		//Keep going up in the tree untill you find a common parent
		while( parent1 != null || parent2 != null )
		{
			if( parent1 == parent2 )
				return parent1;
			else
			{
				parent1 = parent1.parent;
				parent2 = parent2.parent;
			}
		}

		//If you reach the root node but still couldn't find a common ancestor, return null
		if( parent1 == null || parent2 == null )
			System.err.println("Error: No common Ancestor found!");
		
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
	 * To find level of the given node
	 */
	public int findLevel(Node root,Node node)
	{
		int level = 0; 
			
		if ( root.data == node.data )
			return level;
		
		while ( root != null)
		{
			if( root.data > node.data)
				root = root.left;
			else if( root.data < node.data )
				root = root.right;
			level++;
			
			if( root.data == node.data )
				break;
		}
		return level;
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
		FirstCommonAncestorWithParent fca = new FirstCommonAncestorWithParent();
		Node root = fca.createTree();
		
		Node commonAncestor = fca.firstCommonAncestor(root, 20,30);
		if ( commonAncestor != null )
			System.out.println("The first common ancestor of the given nodes is : "+commonAncestor.data);
	}
}
