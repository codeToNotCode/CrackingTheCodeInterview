/*
 * To check whether there is a route between any two given nodes in the graph
 */

package ch4TreesAndGraphs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class isARoute
{
	private Queue<Integer> queue;
	
	public isARoute()
	{
		queue = new LinkedList<Integer>();
	}
	
	
	//To check whether there is a route from source to destination
	public boolean isRoute(int adjM[][], int source, int destination)
	{
		
		//If there is a cycle in the graph
		if ( source == destination )
		{
			System.out.println("Source and Destination nodes are the same");
			return true;
		}
		
		int numNodes = adjM[source].length - 1 ;
		int visited[] = new int[numNodes + 1];
		
		int element;
		
		queue.add(source);
		visited[source] = 1;
		
		while( !queue.isEmpty() )
		{
			element = queue.remove();
			
			for(int i = 1 ; i <= numNodes ; i++)
			{
				if( adjM[element][i] == 1 && visited[i] == 0)
				{
					queue.add(i);
					visited[i] = 1;
					
					//Check for whether the newly visited node is the destination or not
					if( i == destination )
						return true;
				}
			}
		}
		//The BFS traversal of the graph is complete: No route Found
		return false;
	}
	
	//Initialize the graph using adjacency Matrix
	public int[][] initializeGraph(int numNodes)
	{
		Scanner scan = new Scanner(System.in);
		
		int[][] adjM = new int[numNodes + 1][numNodes + 1];
		System.out.println("\nEnter the adjacency matrix :\n");
		
		for( int i = 1 ; i <= numNodes ; i++)
			for(int j = 1 ; j <= numNodes ; j++)
				adjM[i][j] = scan.nextInt();
		
		return adjM;
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		isARoute graph = new isARoute();
		
		int source, destination,numNodes;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nEnter the total number of nodes in the graph :");
		numNodes = scan.nextInt();
		
		int[][] adjM = graph.initializeGraph(numNodes);
		
		System.out.println("\n Enter two nodes between which you want to check whether a route exists or not: <Source><Destination>");
		source = scan.nextInt();
		destination = scan.nextInt();
		
		boolean isRoute = graph.isRoute(adjM, source, destination);
		
		if( isRoute )
			System.out.println("There is a route from ["+source+"] to ["+destination+"] !!!");
		else
			System.out.println("There is NO route from ["+source+"] to ["+destination+"]");
		
		scan.close();
	}	
}
