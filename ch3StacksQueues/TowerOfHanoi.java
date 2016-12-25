/*
 * To solve the Tower of Hanoi problem with 3 pegs and n disks
 * Used Stacks and Recursion
 */

package ch3StacksQueues;

import java.util.Stack;

public class TowerOfHanoi 
{

	private Stack<Integer> disks;
	private int index;
	
	public TowerOfHanoi(int i)
	{
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index()
	{
		return index;
	}
	
	public void add(int d)
	{
		if(!disks.isEmpty() && disks.peek() <= d)
		{
			System.err.println("Error placing disk :"+d);
		}
		else
		{
			disks.push(d);
		}
	}
	
	public void moveTopTo(TowerOfHanoi t)
	{
		int top = disks.pop();
		t.add(top);
		
		System.out.println("Move disk " +top+ " from "+index()+" to "+t.index());
	}
	
	public void print()
	{
		System.out.println("Contents of Tower :"+index());
		for(int i = disks.size() -1 ; i >= 0 ; i-- )
		{
			System.out.println(" "+disks.get(i));
		}
	}
	
	public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer)
	{
		if( n > 0 )
		{
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
	
	//Driver Function
	public static void main(String[] args) 
	{
		//Set up for the towers and the disks
		
		//Let the number of disks to be moved be 5
		int n = 3;
		
		//Create an array of 3 elements to denote the pegs
		TowerOfHanoi[] towers = new TowerOfHanoi[3];
		
		//intialize the towers[] array
		for(int i = 0 ; i < 3 ; i++)
			towers[i] = new TowerOfHanoi(i);
		
		//Add the disks onto the first tower
		for (  int i = n -1 ; i >= 0 ; i-- )
			towers[0].add(i);
		
		
		//Perform the operations to move all the disks from peg1 to peg3
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
